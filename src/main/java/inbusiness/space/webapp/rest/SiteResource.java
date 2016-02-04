package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;

import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.dto.SitesDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import inbusiness.space.webapp.service.SiteService;
import inbusiness.space.webapp.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Asset.
 */
@RestController
@RequestMapping("/api/site")
public class SiteResource {

    @Resource
    private Environment environment;


    private final Logger log = LoggerFactory.getLogger(SiteResource.class);

    @Inject
    private SiteService siteService;

    @Inject
    private UrlService urlService;

    @Inject
    @Named("respondMapperImpl")
    RespondMapper respondMapper;

    /**
     * POST  /assets -> Create a new asset.
     */
    @RequestMapping(value = "/validate/id",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<?> validateSiteId(@RequestParam("friendlyId") String friendlyId) throws IOException {
        log.debug("REST request to validateSiteId : " + friendlyId);

        Optional<Sites> sites = siteService.loadSiteById(friendlyId);

        if (sites.isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }


    @RequestMapping(value = "create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<?> create(@RequestParam String friendlyId
            , @RequestParam String name
            , @RequestParam String email
            , @RequestParam String password
            , @RequestParam String passcode
            , @RequestParam String timeZone
            , @RequestParam String language
            , @RequestParam String userLanguage
            , @RequestParam String theme
            , @RequestParam String firstName
            , @RequestParam String lastName
            , HttpServletRequest request, HttpServletResponse response) throws Exception {

        Sites site = siteService.createNewSite(friendlyId, name, email, password, passcode, timeZone, language, userLanguage, theme, firstName, lastName);



        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/retrieve",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<SitesDto> retrieveSite(HttpServletRequest httpRequest) throws IOException {
        log.debug("REST request to validateSiteId : " + httpRequest);

        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Optional<Sites> sites = siteService.loadSiteById(dataToken.getSiteId());

        if (sites.isPresent()) {
            final Sites site = sites.get();
            SitesDto sitesDto = respondMapper.sitesToDto(site);
            sitesDto.setImagesUrl(urlService.getBaseDirUrl(site.getFriendlyId()));
            return new ResponseEntity<>(sitesDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void save(@RequestParam String name
            , @RequestParam String domain
            , @RequestParam String primaryEmail
            , @RequestParam String timeZone
            , @RequestParam String language
            , @RequestParam String direction
            , @RequestParam String currency
            , @RequestParam Integer showCart // 1 => true
            , @RequestParam Integer showSettings
            , @RequestParam Integer showLanguages
            , @RequestParam Integer showLogin
            , @RequestParam Integer showSearch
            , @RequestParam String urlMode
            , @RequestParam String weightUnit
            , @RequestParam String shippingCalculation
            , @RequestParam String shippingRate   // not used
            , @RequestParam String shippingTiers  // not used
            , @RequestParam String taxRate
            , @RequestParam String payPalId
            , @RequestParam Integer payPalUseSandbox
            , @RequestParam String welcomeEmail
            , @RequestParam Integer isSMTP
            , @RequestParam String SMTPHost
            , @RequestParam Integer SMTPAuth
            , @RequestParam String SMTPUsername
            , @RequestParam String SMTPPassword
            , @RequestParam String SMTPSecure
            , @RequestParam String formPublicId   // not used
            , @RequestParam String formPrivateId  // not used
            , @RequestParam String embeddedCodeHead
            , @RequestParam String embeddedCodeBottom
            , HttpServletRequest httpRequest) throws IOException {
        log.debug("REST request to validateSiteId : " + httpRequest);

        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Sites sites = siteService.loadSiteById(dataToken.getSiteId()).get();

        sites.setName(name);
        sites.setDomain(domain);
        sites.setPrimaryEmail(primaryEmail);
        sites.setTimeZone(timeZone);
        sites.setLanguage(language);
        sites.setCurrency(currency);
        sites.setDirection(direction);
        sites.setShowCart(showCart);
        sites.setShowSettings(showSettings);
        sites.setShowLanguages(showLanguages);
        sites.setShowLogin(showLogin);
        sites.setUrlMode(urlMode);
        sites.setWeightUnit(weightUnit);
        sites.setShippingCalculation(shippingCalculation);
        sites.setShippingRate(shippingRate);
        sites.setShippingTiers(shippingTiers);
        sites.setTaxRate(taxRate);
        sites.setPayPalId(payPalId);
        sites.setPayPalUseSandbox(payPalUseSandbox);
        sites.setWelcomeEmail(welcomeEmail);
        sites.setIsSmtp(isSMTP);
        sites.setSmtpHost(SMTPHost);
        sites.setSmtpAuth(SMTPAuth);
        sites.setSmtpUsername(SMTPUsername);
        sites.setSmtpPassword(SMTPPassword);
        sites.setSmtpSecure(SMTPSecure);
        sites.setShowSearch(showSearch);
        sites.setEmbeddedCodeHead(embeddedCodeHead);
        sites.setEmbeddedCodeBottom(embeddedCodeBottom);

        siteService.update(sites);
    }

    private boolean convertToBoolean(Integer value) {
        if (value==null) {
            return false;
        }
        return value.intValue()==1;
    }

    @RequestMapping(value = "/list/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<SitesDto> listAll(HttpServletRequest httpRequest) throws IOException {
        log.debug("REST request to listAll : " + httpRequest);
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        List<SitesDto> res = new ArrayList<>();
        siteService.loadSiteByUser(dataToken.getUserId()).forEach(s -> {
            res.add(respondMapper.sitesToDto(s));
        });


        return res;

    }

    @RequestMapping(value = "/publishToRemote",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void publishToRemote(HttpServletRequest httpRequest, @RequestParam String siteId) throws IOException {
        log.debug("REST request to publishToRemote : " + httpRequest + " for site : " + siteId);
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        // TODO ajouter l'appel à la republication
        Sites site = siteService.loadSiteById(siteId).get();

        String targetUrl = site.getDomain();
        if (targetUrl.startsWith("http")) {

            String token = "123454321";
            siteService.todoPublish(site, targetUrl, token);
        }
    }

}
