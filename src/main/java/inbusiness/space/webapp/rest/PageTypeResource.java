package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;

import inbusiness.space.webapp.domain.PageTypes;
import inbusiness.space.webapp.domain.Pages;
import inbusiness.space.webapp.dto.PageTypesDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.PageTypesRepository;
import inbusiness.space.webapp.repository.PagesRepository;
import inbusiness.space.webapp.repository.UserSearchRepository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/pagetype")
public class PageTypeResource {

    @Inject
    private PageTypesRepository pageTypesRepository;

    @Inject
    private PagesRepository pagesRepository;

    @Inject
    private UserSearchRepository userSearchRepository;

    @Inject
    @Named("respondMapperImpl")
    RespondMapper respondMapper;


    @RequestMapping(value = "/list/allowed",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<PageTypesDto>> findBySiteId(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        List<PageTypesDto> res = new ArrayList<>();
        res.add(buildRootDefaultPageType());
        Pageable pageSpecification = new PageRequest(0, 1000);
        res.addAll(pageTypesRepository.findBySiteId(dataToken.getSiteId(), pageSpecification).stream()
                .map((p) -> respondMapper.pageTypeToDto(p))
                .collect(Collectors.toList()));



        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<PageTypesDto>> listeAllBySiteId(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        List<PageTypesDto> res = new ArrayList<>();
        res.add(buildRootDefaultPageType());
        Pageable pageSpecification = new PageRequest(0, 1000);
        res.addAll(pageTypesRepository.findBySiteId(dataToken.getSiteId(),pageSpecification).stream()
            .map((p) -> respondMapper.pageTypeToDto(p))
            .collect(Collectors.toList()));

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PageTypesDto> add(HttpServletRequest httpRequest
            , @RequestParam String friendlyId
            , @RequestParam String layout
            , @RequestParam String stylesheet
            , @RequestParam String isSecure
            , @RequestParam(required = false) String pageTypeId
        ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        PageTypes pageTypes = new PageTypes();
        pageTypes.setFriendlyId(friendlyId);
        pageTypes.setLayout(layout);
        pageTypes.setStylesheet(stylesheet);
        pageTypes.setSecure("1".equals(isSecure));
        pageTypes.setSiteId(dataToken.getSiteId());
        pageTypes.setLastModifiedBy(dataToken.getUserId());
        pageTypes.setLastModifiedDate(new Timestamp(new Date().getTime()));

        pageTypesRepository.save(pageTypes);

        if (pageTypeId!=null) {
            Pageable pageSpecification = new PageRequest(0, 1000);
            List<Pages> pagesToCopy = pagesRepository.findPagesByLastModifiedByAndSiteIdAndPageTypeId(dataToken.getUserId(), dataToken.getSiteId(), pageTypeId, pageSpecification);
//            User user = userSearchRepository.findOne(dataToken.getUserId());
            for(Pages page : pagesToCopy) {
                Pages newPage = new Pages(page);
                newPage.setPageTypeId(pageTypes.getId());
                newPage.setLastModifiedDate(new Timestamp(new Date().getTime()));
                newPage.setLastModifiedBy(dataToken.getUserId());
                pagesRepository.save(newPage);
            }
        }

        return new ResponseEntity<>(respondMapper.pageTypeToDto(pageTypes), HttpStatus.OK);
    }

    @RequestMapping(value = "/remove",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void add(HttpServletRequest httpRequest
            , @RequestParam String pageTypeId
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        pageTypesRepository.delete(pageTypeId);
    }

    @RequestMapping(value = "/edit",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void edit(HttpServletRequest httpRequest
            , @RequestParam String pageTypeId
            , @RequestParam String typeS
            , @RequestParam String typeP
            , @RequestParam String layout
            , @RequestParam String stylesheet
            , @RequestParam boolean isSecure
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        PageTypes pageType = pageTypesRepository.findOne(pageTypeId);
        pageType.setLayout(layout);
        pageType.setStylesheet(stylesheet);
        pageType.setSecure(isSecure);
        pageType.setLastModifiedDate(new Timestamp(new Date().getTime()));
        pageType.setLastModifiedBy(dataToken.getUserId());
        pageTypesRepository.save(pageType);
    }

    private PageTypesDto buildRootDefaultPageType() {
        PageTypesDto pageTypeDefault = new PageTypesDto();
        pageTypeDefault.setId(null);
        pageTypeDefault.setSiteId("-1");
        pageTypeDefault.setFriendlyId("");
        pageTypeDefault.setStylesheet("content");
        pageTypeDefault.setLayout("content");

        return pageTypeDefault;
    }

}
