package inbusiness.space.webapp.rest;


import com.codahale.metrics.annotation.Timed;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.SitesRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import inbusiness.space.webapp.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * REST controller for managing Asset.
 */
@RestController
@RequestMapping("/api/site/branding")
public class BrandingResource {

    @Resource
    private Environment environment;


    private final Logger log = LoggerFactory.getLogger(BrandingResource.class);

    @Inject
    private SiteService siteService;

    @Inject
    private SitesRepository sitesRepository;

    @Inject
    @Named("respondMapperImpl")
    RespondMapper respondMapper;

    @RequestMapping(value = "/icon/background",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void background(HttpServletRequest httpRequest, @RequestParam String color) throws IOException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        final Optional<Sites> optionalSite = siteService.loadSiteById(dataToken.getSiteId());

        if (optionalSite.isPresent()) {
            final Sites site = optionalSite.get();
            site.setIconBg(color);
            sitesRepository.save(site);
        }
    }

    @RequestMapping(value = "/image",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void image(HttpServletRequest httpRequest
            , @RequestParam String url
            , @RequestParam String type
    ) throws IOException {
        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        final Optional<Sites> optionalSite = siteService.loadSiteById(dataToken.getSiteId());

        if (optionalSite.isPresent()) {
            final Sites site = optionalSite.get();
            switch (type) {
                case "logo":
                    site.setLogoUrl(url);
                    break;
                case "alt":
                    site.setAltLogoUrl(url);
                    break;
                case "paypal":
                    site.setPayPalLogoUrl(url);
                    break;
                case "icon":
                    site.setIconUrl(url);

                    // TODO : Il faudra redimensionner l'image et en faire 2 points ico de 32x32 et 64x64

                    break;
            }
            sitesRepository.save(site);
        }
    }

}
