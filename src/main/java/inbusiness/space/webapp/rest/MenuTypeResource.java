package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;

import inbusiness.space.webapp.domain.MenuTypes;
import inbusiness.space.webapp.dto.MenuTypesDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.MenuTypesRepository;
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
import java.util.stream.Collectors;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/menutype")
public class MenuTypeResource {

    @Inject
    MenuTypesRepository menuTypesRepository;

    @Inject
    @Named("respondMapperImpl")
    RespondMapper respondMapper;

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<MenuTypesDto>> findBySiteId(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        Pageable pageSpecification = new PageRequest(0, 1000);

        List<MenuTypesDto> res = menuTypesRepository.findBySiteId(dataToken.getSiteId(), pageSpecification).stream()
                .map((p) -> respondMapper.menuTypesToDto(p))
                .collect(Collectors.toList());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public MenuTypesDto add(HttpServletRequest httpRequest, @RequestParam String friendlyId
            , @RequestParam String name
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        MenuTypes menuType = new MenuTypes();
        menuType.setFriendlyId(friendlyId);
        menuType.setSiteId(dataToken.getSiteId());
        menuType.setName(name);

        menuType.setLastModifiedDate(new Timestamp(new Date().getTime()));
        menuType.setLastModifiedBy(dataToken.getUserId());

        menuTypesRepository.save(menuType);

        return respondMapper.menuTypesToDto(menuType);
    }


}
