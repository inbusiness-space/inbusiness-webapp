package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.domain.Theme;
import inbusiness.space.webapp.dto.ThemeDto;
import inbusiness.space.webapp.dto.ThemeConfigureControlList;
import inbusiness.space.webapp.repository.*;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import inbusiness.space.webapp.service.SiteService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Asset.
 */
@RestController
@RequestMapping("/api")
public class ThemeResource {

    private final Logger log = LoggerFactory.getLogger(ThemeResource.class);

    @Inject
    Environment environment;

    @Inject
    private AssetSearchRepository assetSearchRepository;

    @Inject
    private SitesRepository sitesRepository;

    @Inject
    private PagesRepository pagesRepository;

//    @Inject
//    private RespondPublishService respondPublishService;

    @Inject
    private MenuItemsRepository menuItemsRepository;

    @Inject
    private MenuTypesRepository menuTypesRepository;

    @Inject
    private PageTypesRepository pageTypesRepository;

    @Inject
    private ThemeRepository themeRepository;

    @Inject
    private SiteService siteService;

    /**
     * POST  /assets -> Create a new asset.
     */
    @RequestMapping(value = "/theme",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Map<String, ThemeDto>> loadAllTheme() throws IOException, URISyntaxException {
        log.debug("REST request to loadAllTheme");
        Map<String, ThemeDto> res = new HashMap<>();

        try {
//            List<String> lines = IOUtils.readLines(this.getClass().getResourceAsStream("/themes_ext/themes_list.txt"));


            List<Theme> themes = themeRepository.findAll();
            for (Theme theme : themes) {
                ThemeDto theme1 = new ThemeDto();
                theme1.setId(theme.getId());
                theme1.setName(theme.getName());
                theme1.setDesc(theme.getName());
                res.put(theme1.getId(), theme1);
            }

        }  catch (Exception e) {
            ThemeDto theme = new ThemeDto();
            String line = "No_themes";
            theme.setId(line);
            theme.setName(line + "_name_tbd");
            theme.setDesc(line + "_desc_tbd");
            res.put(theme.getId(), theme);
        }



        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/theme/configurations/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<ThemeConfigureControlList>> themeConfigurationList(HttpServletRequest httpRequest) throws IOException, URISyntaxException {
        log.debug("REST request to themeConfigurationList");
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final String siteId = dataToken.getSiteId();
        final Sites site = sitesRepository.findOne(siteId);
        final String configureId = site.getThemeFilesMap().get("root").get("configure.json");
        final AssetMetaData optConfigureJson = assetSearchRepository.findOne(configureId).get();
        final String strConfigureJson = new String(optConfigureJson.getContent());

        final ObjectMapper mapper = new ObjectMapper();
//        ThemeConfigure configure = mapper.readValue("{\"configure\":" + strConfigureJson + "}", ThemeConfigure.class);
        final List<ThemeConfigureControlList> res = mapper.readValue(strConfigureJson, new TypeReference<List<ThemeConfigureControlList>>() {
        });


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/theme/configurations/apply",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void saveThemeConfig(HttpServletRequest httpRequest, @RequestParam String configurations) throws Exception {
        log.debug("REST request to saveTheme");
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        final String siteId = dataToken.getSiteId();
        final Sites site = sitesRepository.findOne(siteId);
        final String configureId = site.getThemeFilesMap().get("root").get("configure.json");
        final AssetMetaData optConfigureJson = assetSearchRepository.findOne(configureId).get();

        optConfigureJson.setContent(configurations.getBytes());
        assetSearchRepository.save(optConfigureJson);

        // TODO
        // respondPublishService.publishCss(site.getFriendlyId());
    }


    @RequestMapping(value = "/theme/apply",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void updateTheme(HttpServletRequest httpRequest
            , @RequestParam(required = false) String configurations
            , @RequestParam(required = false) String theme
            , @RequestParam(required = false) Boolean replaceContent
    ) throws Exception {
        log.debug("REST request to saveTheme");
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        final String siteId = dataToken.getSiteId();
        final Sites site = sitesRepository.findOne(siteId);

        if (configurations!=null) {
            site.setName("");
            sitesRepository.save(site);


            // TODO:
//            respondPublishService.publishTheme(site);
//            respondPublishService.publishCss(site.getFriendlyId());
//            respondPublishService.republishAllPages(site);


        } else {
            // Changement de thème
            site.setName("");
            String[] themeSplit = theme.split("_");
            site.setTheme(themeSplit[0]);
            if (replaceContent!=null && replaceContent) {
                sitesRepository.delete(site.getId());
                Pageable pageSpecification = new PageRequest(0, 1000);
                pagesRepository.findBySiteId(site.getId(),pageSpecification).forEach(
                        p -> pagesRepository.delete(p.getId())
                );
                menuItemsRepository.findBySiteIdOrderByPriorityAsc(site.getId(), pageSpecification).forEach(
                        i -> menuItemsRepository.delete(i.getId())
                );
                menuTypesRepository.findBySiteId(site.getId(), pageSpecification).forEach(
                        t ->  menuTypesRepository.delete(t.getId())
                );
                pageTypesRepository.findBySiteId(site.getId(), pageSpecification).forEach(
                        pt -> pageTypesRepository.delete(pt.getId())
                );
                site.setId(null);
                siteService.createNewSite(site.getFriendlyId(), site.getName(), site.getPrimaryEmail(), null, null, null,null,null,site.getTheme(),null,null);

            } else {
                Map<String, Map<String, String>> themeFilesMap = site.getThemeFilesMap();
                final HashMap<String, Map<String, String>> newThemeFilesMap = new HashMap<>();
                newThemeFilesMap.put("js", themeFilesMap.get("js"));
                newThemeFilesMap.put("locales", themeFilesMap.get("locales"));
                site.setThemeFilesMap(newThemeFilesMap);
                sitesRepository.save(site);

                // TODO:
//                respondPublishService.publishTheme(site);
//                respondPublishService.publishCss(site.getFriendlyId());
//                respondPublishService.republishAllPages(site);
            }
        }


    }
}
