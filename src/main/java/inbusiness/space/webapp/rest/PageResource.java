package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;

import inbusiness.space.webapp.domain.*;
import inbusiness.space.webapp.dto.PagesDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.PageTypesRepository;
import inbusiness.space.webapp.repository.PagesRepository;
import inbusiness.space.webapp.repository.UserSearchRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import inbusiness.space.webapp.service.SiteService;
import inbusiness.space.webapp.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/page")
public class PageResource {

    @Inject
    private PagesRepository pagesRepository;

    @Inject
    private PageTypesRepository pageTypesRepository;

    @Inject
    private SiteService siteService;

    @Inject
    private UrlService urlService;

    @Inject
    @Named("respondMapperImpl")
    private RespondMapper respondMapper;

//    @Inject
//    private RespondPublishService respondPublishService;

    @Inject
    private UserSearchRepository userSearchRepository;

    private static final Logger log = LoggerFactory.getLogger(PageResource.class);

    @RequestMapping(value = "/list/allowed",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<PagesDto>> findBySiteId(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pageable pageSpecification = new PageRequest(0, 1000);
        final Map<String, User>  userMap = new HashMap<>();
        List<PagesDto> res = pagesRepository.findBySiteId(dataToken.getSiteId(), pageSpecification).stream()
                .map((p) -> {
                    final PagesDto pagesDto = respondMapper.pagesToDto(p);
                    pagesDto.setEdit(true);
                    pagesDto.setPublish(true);
                    pagesDto.setRemove(true);
                    User user = userMap.get(p.getUserId());
                    if (user==null) {
                        user = userSearchRepository.findOne(p.getUserId());
                        userMap.put(p.getUserId(), user);
                    }
                    if (user!=null) {
                        pagesDto.setLastModifiedFullName(user.getFirstName() + " " + user.getLastName());
                    }
                    initUrl(p, pagesDto);
                    return pagesDto;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @RequestMapping(value = "/content/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void contentSave(HttpServletRequest httpRequest
            , @RequestParam String pageId
            , @RequestParam String content
            , @RequestParam String status
            , @RequestParam String image
    ) throws Exception {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pages page = pagesRepository.findOne(pageId);
        if ("publish".equals(status)) {
            page.setContent(content);
            page.setImage(image); // dans le code php, c'est fait uniquement si l'utilisateur a les droits de publication.
        }
        page.setDraft(content);
        page.setLastModifiedBy(dataToken.getUserId());
        page.setLastModifiedDate(new Timestamp(new Date().getTime()));
        pagesRepository.save(page);

        if ("publish".equals(status)) {
            // TODO:
            // respondPublishService.publishPage(dataToken.getSiteId(), page);
        }
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void save(HttpServletRequest httpRequest
            , @RequestParam String pageId
            , @RequestParam String name
            , @RequestParam String friendlyId
            , @RequestParam String description
            , @RequestParam String keywords
            , @RequestParam String callout
            , @RequestParam String layout
            , @RequestParam String stylesheet
            , @RequestParam Boolean includeOnly
            , @RequestParam String beginDate
            , @RequestParam String endDate
            , @RequestParam String location
            , @RequestParam Long latitude
            , @RequestParam Long longitude
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pages page = pagesRepository.findOne(pageId);
        page.setFriendlyId(friendlyId);
        page.setDescription(description);
        page.setKeywords(keywords);
        page.setCallout(callout);
        page.setLayout(layout);
        page.setStylesheet(stylesheet);
        page.setIncludeOnly(includeOnly);
        // TODO FEN Pour l'instant c'est null. On verra lorsque cela sera utilisé.
//        page.setBeginDate(beginDate);
//        page.setEndDate(endDate);
        page.setLocation(location);
        if (latitude!=null && longitude!=null) {
            page.setLatLong(new Location(latitude, longitude));
        }

        page.setLastModifiedBy(dataToken.getUserId());
        page.setLastModifiedDate(new Timestamp(new Date().getTime()));
        pagesRepository.save(page);
    }

    @RequestMapping(value = "/edit/tags",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void updateTags(HttpServletRequest httpRequest, @RequestParam String pageId, @RequestParam String tags) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pages page = pagesRepository.findOne(pageId);
        page.setTags(tags);
        page.setLastModifiedBy(dataToken.getUserId());
        page.setLastModifiedDate(new Timestamp(new Date().getTime()));
        pagesRepository.save(page);
    }

    @RequestMapping(value = "/remove",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void removePage(HttpServletRequest httpRequest, @RequestParam String pageId) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        pagesRepository.delete(pageId);
    }

    @RequestMapping(value = "/content/retrieve",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE)
    @Timed
    public String retrieveContent(HttpServletRequest httpRequest, @RequestParam String pageId) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pages page = pagesRepository.findOne(pageId);

        final String content;

        if (page.getDraft()!=null) {
            content = page.getDraft();
        } else if (page.getContent()!=null) {
            content = page.getContent();
        } else {
            // TODO dans name et description, il faut épurer la chaine des codes HTML : en php -> strip_tags(html_entity_decode($page['Name']))
            content = "<div id=\"block-1\" class=\"block row\"><div class=\"col col-md-12\"><h1>"
                    + page.getName() +
                    "</h1><p>" + page.getDescription() + "</p></div></div>";
        }

        final Set<String> analyseExtension = new TreeSet();
        analyseExtension.add("html");
        analyseExtension.add("htm");
        analyseExtension.add("css");
        analyseExtension.add("js");
        final String res = content.replaceAll("\\{\\{site.ImagesUrl}}", "/sites/"+dataToken.getSiteId()+"/");

        return res;
    }

    @RequestMapping(value = "/retrieve/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<PagesDto> retrievePage(HttpServletRequest httpRequest, @RequestParam String pageId) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Pages page = pagesRepository.findOne(pageId);

        PagesDto res = respondMapper.pagesToDto(page);
        initUrl(page, res);
        res.setHasDraft(page.getDraft() != null);
        res.setEdit(true);
        res.setPublish(true);
        res.setRemove(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    private void initUrl(Pages page, PagesDto res) {
        res.setUrl(page.getFriendlyId());
        if (page.getPageTypeId()!=null) {
            PageTypes pageType = pageTypesRepository.findOne(page.getPageTypeId());
            res.setUrl(pageType.getFriendlyId() + "/" + res.getUrl());
        }
    }

    @RequestMapping(value = "/list/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<PagesDto>> listAll(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Optional<Sites> site = siteService.loadSiteById(dataToken.getSiteId());

        if (site.isPresent()) {
            Pageable pageSpecification = new PageRequest(0, 1000);
            List<PagesDto> res = pagesRepository.findBySiteId(dataToken.getSiteId(), pageSpecification).stream()
                    .map((p) -> {
                        final PagesDto pagesDto = respondMapper.pagesToDto(p);
                        pagesDto.setEdit(true);
                        pagesDto.setPublish(true);
                        pagesDto.setRemove(true);
                        pagesDto.setImage(urlService.getImagesUrl(site.get().getFriendlyId(), p.getImage()));
                        pagesDto.setThumb(urlService.getImagesThumbsUrl(site.get().getFriendlyId(), p.getImage()));
                        initUrl(p, pagesDto);
                        return pagesDto;
                    })
                    .collect(Collectors.toList());

            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<PagesDto>>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/published/count",
        method = RequestMethod.POST
        ,produces = MediaType.APPLICATION_JSON_VALUE
        )
    @Timed
    public Map<String, String> retrievePublioshedCount(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        // DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        // siteId:wil54
        // type:post
        Map<String, String> res = new HashMap<>();

        String type = httpRequest.getParameter("type");
        String siteId = httpRequest.getParameter("siteId");

        Optional<PageTypes> pageType = pageTypesRepository.findByFriendlyIdAndSiteId(type, siteId);
        if (pageType.isPresent()) {

            Pageable pageSpecification = new PageRequest(0, 1000);
            List<Pages> pages = pagesRepository.findByPageTypeIdAndSiteId(pageType.get().getId(), siteId, pageSpecification);
            res.put("count", ""+pages.size());

            System.out.println("Finding pages with pageTypeId: " + pageType.get().getId() );
            for (Pages page: pages) {
                log.info("--> " + page.getFriendlyId());

            }
        }


        return res;
    }

    @RequestMapping(value = "/unpublish",
            method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed
    public void unpublish(HttpServletRequest httpRequest, @RequestParam String pageId) throws Exception {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Optional<Sites> site = siteService.loadSiteById(dataToken.getSiteId());
        if (site.isPresent()) {
            Pages page = pagesRepository.findOne(pageId);
            page.setActive(false);
            page.setLastModifiedBy(dataToken.getUserId());
            page.setLastModifiedDate(new Timestamp(new Date().getTime()));
            pagesRepository.save(page);


            // TODO: unpublish
            //respondPublishService.unpublishPage(site.get(), page, page.getPageTypeFriendlyId());
        }

    }

    @RequestMapping(value = "/publish",
            method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed
    public void publish(HttpServletRequest httpRequest, @RequestParam String pageId) throws Exception {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Optional<Sites> site = siteService.loadSiteById(dataToken.getSiteId());
        if (site.isPresent()) {

            Pages page = pagesRepository.findOne(pageId);
            page.setActive(true);
            page.setLastModifiedBy(dataToken.getUserId());
            page.setLastModifiedDate(new Timestamp(new Date().getTime()));
            pagesRepository.save(page);

            // TODO: unpublish
            // respondPublishService.publishPage(site.get(), page, page.getPageTypeFriendlyId());

        }



    }

    /*

     */
    @RequestMapping(value = "/published/list",
        method = RequestMethod.POST
        ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed
    public List<Map<String, String>> retrievePublishedList(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        // DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        // siteId:wil58
//        type:post
//        pagesize:10
//        current:0
//        orderby:Created
//        tag:
        List<Map<String, String>> res = new ArrayList<>();

        String type = httpRequest.getParameter("type");
        String siteId = httpRequest.getParameter("siteId");

        Optional<PageTypes> pageType = pageTypesRepository.findByFriendlyIdAndSiteId(type, siteId);
        if (pageType.isPresent()) {


            // TODO: Multipage + Sort + Tags
            Pageable pageSpecification = new PageRequest(0, 1000);
            List<Pages> pages = pagesRepository.findByPageTypeIdAndSiteId(pageType.get().getId(), siteId, pageSpecification);


            log.info("Finding pages with pageTypeId: " + pageType.get().getId() );
            for (Pages page: pages) {
                log.info("--> " + page.getFriendlyId());

                String builtUrl = type + "." + page.getFriendlyId();


                Map<String, String> pageInfos = new HashMap<>();
//                $item = array(
//                    'PageId'  => $page['PageId'],
                pageInfos.put("pageId", page.getFriendlyId());
//                    'Name' => $page['Name'],	// get a translation for name, description, and callout
                pageInfos.put("Name", page.getName());
//                    'Description' => $page['Description'],
                pageInfos.put("Description", page.getDescription());
//                    'Callout' => $page['Callout'],
                pageInfos.put("Callout", page.getCallout());

//                    'Location' => $page['Location'],
                pageInfos.put("Location", page.getLocation());
//                    'LatLong' => $page['LatLong'],
                pageInfos.put("LatLong", "");   // TODO: FixIt
//                    'HasCallout' => $hasCallout,
                pageInfos.put("HasCallout", "" + (page.getCallout() == null? false: true));
//                    'Url' => $url,
                pageInfos.put("Url", builtUrl);
//                    'Image' => $imageUrl,
                pageInfos.put("Image", page.getImage());
//                    'Thumb' => $thumbUrl,
                pageInfos.put("Thumb", "");
//                    'HasImage' => $hasImage,
                pageInfos.put("HasImage", "" + (page.getImage() == null? false: true));
//                    'BeginDate' => $beginDate,
                pageInfos.put("BeginDate", "");
//                    'BeginDateReadable' => $beginReadable,
                pageInfos.put("BeginDateReadable", "");
//                    'EndDate' => $endDate,
                pageInfos.put("EndDate", "");
//                    'EndDateReadable' => $endReadable,
                pageInfos.put("EndDateReadable", "");
//                    'LastModified' => $page['LastModifiedDate'],
                pageInfos.put("LastModified", page.getLastModifiedBy());
//                    'Author' => $name,
                pageInfos.put("Author", page.getUserId());   // TODO: FixIt
//                    'FirstName' => $row['FirstName'],
                pageInfos.put("FirstName", page.getUserId());      // TODO: FixIt
//                    'LastName' => $row['LastName'],
                pageInfos.put("LastName", page.getUserId());
//                    'Photo' => $row['PhotoUrl'],
                pageInfos.put("PhotoUrl", "");
//                    'Tags' => $page['Tags']
                pageInfos.put("Tags", "");
//                );
                res.add(pageInfos);

            }
        }


        return res;
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Timed
    public PagesDto add(HttpServletRequest httpRequest
            , @RequestParam String pageTypeId
            , @RequestParam String name
            , @RequestParam String friendlyId
            , @RequestParam String description
            , @RequestParam String pageId
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        final Pages page = new Pages();
        final PageTypes pageType = pageTypesRepository.findOne(pageTypeId);
        if (pageType!=null) {
            page.setLayout(pageType.getLayout());
            page.setStylesheet(pageType.getStylesheet());
            page.setPageTypeId(pageType.getId());
            page.setPageTypeFriendlyId(pageType.getFriendlyId());
        }
        page.setSiteId(dataToken.getSiteId());
        page.setUserId(page.getUserId());
        page.setFriendlyId(friendlyId.replace(" ", "").toLowerCase());
        page.setName(name);
        page.setDescription(description);
        Timestamp dtCour = new Timestamp(new Date().getTime());
        page.setLastModifiedDate(dtCour);
        page.setCreated(dtCour);
        page.setActive(false);

        if (pageId!=null) {
            Pages pageSource = pagesRepository.findOne(pageId);
            if (pageSource!=null) {
                page.setContent(pageSource.getContent());
                page.setLayout(pageSource.getLayout());
                page.setStylesheet(pageSource.getStylesheet());
            }
        }
        if (null == page.getStylesheet()) {
            page.setStylesheet("content"); // default ?
        }
        if (null == page.getLayout()) {
            page.setLayout("content"); // default ?
        }


        page.setUserId(dataToken.getUserId());
        page.setLastModifiedDate(new Timestamp(new Date().getTime()));
        page.setLastModifiedBy(dataToken.getUserId());
        PagesDto pageDto = respondMapper.pagesToDto(pagesRepository.save(page));
        pageDto.setHasDraft(false);
        pageDto.setEdit(true);
        pageDto.setPublish(true);
        pageDto.setRemove(true);

        Sites site = siteService.loadSiteById(dataToken.getSiteId()).get();

        pageDto.setUrl(page.getFriendlyId());
        if (pageType!=null) {
            pageDto.setUrl(pageDto.getFriendlyId()+"/"+pageType.getFriendlyId());
        }
        pageDto.setImage(null);
        pageDto.setThumb(null);

        return pageDto;
    }


}
