package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.dto.TransactionsDto;
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
@RequestMapping("/api/translation")
public class TranslationResource {

    @Inject
    SitesRepository sitesRepository;

    @Inject
    AssetSearchRepository assetSearchRepository;

//    @Inject
//    RespondPublishService respondPublishService;

    private final String resourceType = "locales";

    @RequestMapping(value = "/list/locales",
            method = RequestMethod.POST,
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
    public ResponseEntity<String> findStyleNamesBySiteId(HttpServletRequest httpRequest
            ,@RequestParam String locale, @RequestParam(required = false) String siteId
        ) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final String siteIdToUse;
        if (siteId!=null) {
            siteIdToUse = siteId;
        } else {
            final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
            siteIdToUse = dataToken.getSiteId();
        }
        final Sites site = sitesRepository.findOne(siteIdToUse);

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        final String content = new String(assetSearchRepository.findOne(resourceList.get(locale)).get().getContent());

        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void update(HttpServletRequest httpRequest,@RequestParam(required = false) String locale, @RequestParam String content) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);
        if (locale==null) {
            locale = site.getLanguage();
        }

        final String language = resourceList.get(locale);
        if (language!=null) {
            AssetMetaData asset = assetSearchRepository.findOne(language).get();
            if (asset!=null) {
                asset.setContent(content.getBytes());
                assetSearchRepository.save(asset);
            }
        }
    }

    @RequestMapping(value = "/add/locale",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void add(HttpServletRequest httpRequest,@RequestParam String locale) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        // TODO:
        AssetMetaData assetMetaData = new AssetMetaData();
//        AssetMetaData assetMetaData = respondPublishService.publishToAssets("/" + site.getName() + "/" + resourceType
//                , site.getName(), "application/octet-stream", "".getBytes(), locale);

        resourceList.put(locale, assetMetaData.getId());
        sitesRepository.save(site);
    }

    @RequestMapping(value = "/remove/locale",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @Timed
    public void remove(HttpServletRequest httpRequest,@RequestParam String locale) throws IOException, URISyntaxException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        final DataToken dataToken = SecurityUtils.getDataToken(httpRequest);
        final Sites site = sitesRepository.findOne(dataToken.getSiteId());

        final Map<String, String> resourceList = site.getThemeFilesMap().get(resourceType);

        // TODO:
        // respondPublishService.remove(resourceList.get(locale));

        resourceList.remove(locale);
        sitesRepository.save(site);
    }

    @RequestMapping(value = "/retrieve/default",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<List<TransactionsDto>> findBySiteId(HttpServletRequest httpRequest) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        // TODO FEN qu'est ce qu'il faut remonter ? le friendlyId serait-il un identifiant d'un site "pÃ¨re" ?
        // le fichier json remontÃ© : $file = SITES_LOCATION.'/'.$site['FriendlyId'].'/locales/'.$site['Language'].'/translation.json';

        List<TransactionsDto> res = new ArrayList<>();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
