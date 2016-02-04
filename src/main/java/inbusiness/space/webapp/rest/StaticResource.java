package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;

import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.repository.AssetSearchRepository;
import inbusiness.space.webapp.service.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * REST controller for managing Asset.
 */
@RestController
public class StaticResource {

    private final Logger log = LoggerFactory.getLogger(StaticResource.class);

    @Inject
    private SiteService siteService;

    @Inject
    private AssetSearchRepository assetSearchRepository;

    /**
     * POST  /assets -> Create a new asset.
     */
    @RequestMapping(value = "/static/{siteId}/**",
            method = RequestMethod.GET)
    @Timed
    public void validateSiteId(@PathVariable("siteId") String siteId, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE) ;
        String url = path.substring(("/static").length()) ;

        Optional<AssetMetaData> optionalAsset = assetSearchRepository.findByUrl(url);

        if (optionalAsset.isPresent()) {
            AssetMetaData asset = optionalAsset.get();
            response.setContentLength(asset.getContent().length);
            response.setContentType(asset.getType());

            response.getOutputStream().write(asset.getContent());
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        }

    }


}
