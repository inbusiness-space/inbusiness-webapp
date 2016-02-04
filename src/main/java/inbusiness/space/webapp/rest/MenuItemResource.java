package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inbusiness.space.webapp.domain.MenuItems;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.dto.MenuItemsDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.MenuItemsRepository;
import inbusiness.space.webapp.repository.SitesRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/menuitem")
public class MenuItemResource {

    @Inject
    private MenuItemsRepository menuItemsRepository;

    @Inject
    private SitesRepository sitesRepository;

//    @Inject
//    private RespondPublishService respondPublishService;

    @Inject
    @Named("respondMapperImpl")
    private RespondMapper respondMapper;

    @RequestMapping(value = "/list/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<MenuItemsDto>> listAll(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pageable pageSpecification = new PageRequest(0, 1000);
        List<MenuItemsDto> res = menuItemsRepository.findBySiteIdOrderByPriorityAsc(dataToken.getSiteId(), pageSpecification).stream()
                .map((p) -> respondMapper.menuItemToDto(p))
                .collect(Collectors.toList());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/toggle/nested",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void toogleNested(HttpServletRequest httpRequest,@RequestParam String menuItemId, @RequestParam int isNested) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        MenuItems menuItem = menuItemsRepository.findOne(menuItemId);
        menuItem.setNested(isNested==1);
        menuItem.setLastModifiedDate(new Timestamp(new Date().getTime()));
        menuItem.setLastModifiedBy(dataToken.getUserId());
        menuItemsRepository.save(menuItem);

    }

    @RequestMapping(value = "publish",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void publish(HttpServletRequest httpRequest) throws Exception {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        // TODO: rebuild all pages (dependency on page layout)
        // respondPublishService.republishAllPages(site);

    }

    @RequestMapping(value = "save/priorities",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void savePriorities(HttpServletRequest httpRequest, @RequestParam String priorities) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Integer>  prioritiesMap = objectMapper.readValue(priorities, new TypeReference<Map<String, Integer>>() {});

        prioritiesMap.forEach((menuItemId, priority) -> {
            MenuItems menuItem = menuItemsRepository.findOne(menuItemId);
            menuItem.setPriority(priority);
            menuItem.setLastModifiedDate(new Timestamp(new Date().getTime()));
            menuItem.setLastModifiedBy(dataToken.getUserId());
            menuItemsRepository.save(menuItem);
        });

    }

    @RequestMapping(value = "add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public MenuItemsDto add(HttpServletRequest httpRequest, @RequestParam String name
            , @RequestParam String cssClass
            , @RequestParam String type
            , @RequestParam String url
            , @RequestParam String pageId
            , @RequestParam Integer priority
            ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        MenuItems menuItem = new MenuItems();
        menuItem.setName(name);
        menuItem.setCssClass(cssClass);
        menuItem.setType(type);
        menuItem.setUrl(url);
        menuItem.setPageId(pageId);
        menuItem.setPriority(priority);
        menuItem.setSiteId(dataToken.getSiteId());
        menuItem.setLastModifiedDate(new Timestamp(new Date().getTime()));
        menuItem.setLastModifiedBy(dataToken.getUserId());
        menuItemsRepository.save(menuItem);

        return respondMapper.menuItemToDto(menuItem);
    }

    @RequestMapping(value = "remove",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void remove(HttpServletRequest httpRequest, @RequestParam String menuItemId
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        menuItemsRepository.delete(menuItemId);

    }

}
