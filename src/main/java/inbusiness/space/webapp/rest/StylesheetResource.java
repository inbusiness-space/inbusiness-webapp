package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.repository.AssetSearchRepository;
import inbusiness.space.webapp.repository.SitesRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/stylesheet")
public class StylesheetResource {

    @Inject
    SitesRepository sitesRepository;

    @Inject
    AssetSearchRepository assetSearchRepository;

//    @Inject
//    RespondPublishService respondPublishService;

    private final String resourceType = "styles";

    @RequestMapping(value = "/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<String>> findStyleNamesBySiteId(HttpServletRequest httpRequest) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        Sites site = sitesRepository.findOne(dataToken.getSiteId());

        Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);
        List<String> fileListName  = new ArrayList<>(resourceList.keySet());

        return new ResponseEntity<>(fileListName, HttpStatus.OK);
    }

    @RequestMapping(value = "/retrieve",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public ResponseEntity<String> findStyleNamesBySiteId(HttpServletRequest httpRequest,@RequestParam String name) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        final String content = new String(assetSearchRepository.findOne(resourceList.get(name)).get().getContent());

        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @RequestMapping(value = "/publish",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void update(HttpServletRequest httpRequest,@RequestParam String name, @RequestParam String content) throws Exception {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        AssetMetaData asset = assetSearchRepository.findOne(resourceList.get(name)).get();
        asset.setContent(content.getBytes());
        assetSearchRepository.save(asset);


        // TODO:
        // respondPublishService.publishCss(site.getFriendlyId());
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void add(HttpServletRequest httpRequest,@RequestParam String name) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        // TODO:
        AssetMetaData assetMetaData = new AssetMetaData();
//        AssetMetaData assetMetaData = respondPublishService.publishToAssets("/" + site.getName() + "/" + site.getTheme() + "/" + resourceType
//                , site.getName(), "application/octet-stream", "".getBytes(), name);

        resourceList.put(name, assetMetaData.getId());
        sitesRepository.save(site);
    }

    @RequestMapping(value = "/remove",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void remove(HttpServletRequest httpRequest,@RequestParam String name) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        // TODO:
        // respondPublishService.remove(resourceList.get(name));

        resourceList.remove(name);
        sitesRepository.save(site);
    }

}
