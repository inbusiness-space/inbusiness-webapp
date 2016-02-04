package inbusiness.space.webapp.service;


import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.domain.User;
import inbusiness.space.webapp.domain.UserRole;
import inbusiness.space.webapp.dto.StartSite;
import inbusiness.space.webapp.repository.AssetMetaDataSearchRepository;
import inbusiness.space.webapp.repository.AssetSearchRepository;
import inbusiness.space.webapp.repository.SitesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by fer on 06/07/2015.
 */
@Service
@Transactional
public class SiteService {

    private final Logger log = LoggerFactory.getLogger(SiteService.class);

    @Inject
    private SitesRepository sitesRepository;

    @Inject
    private UserService userService;

//    @Inject
//    private RespondPublishService respondPublishService;

//    @Inject
//    private PublishService publishService;

    @Inject
    private MailService mailService;

    @Inject
    private MongoTemplate mongoTemplate;

    @Inject
    private AssetSearchRepository assetSearchRepository;

    @Inject
    private AssetMetaDataSearchRepository assetMetaDataSearchRepository;

    public Optional<Sites> loadSiteById(String id) {
        Sites site = sitesRepository.findOne(id);

        if (site!=null) {
            return Optional.of(site);
        } else {
            return Optional.empty();
        }

    }

    public Sites createSite(Sites site) {
        sitesRepository.save(site);
        return site;
    }

    public Sites update(Sites site) {
        return sitesRepository.save(site);
    }

    public Sites createNewSite(String friendlyId, String name, String email, String password, String passcode, String timeZone
            , String language, String userLanguage, String theme, String firstName, String lastName) throws Exception {
        StartSite startSite = new StartSite(friendlyId, name, email, password, passcode, timeZone, language, userLanguage, theme, firstName, lastName);


        log.debug("REST request to create : " + startSite.getFriendlyId());

        final User user;
        if (startSite.getPasscode()!=null) {
            user = userService.createUserInformationIfNotExist(startSite.getEmail(), startSite.getPassword(), startSite.getFirstName(), startSite.getLastName(), startSite.getEmail(), startSite.getLanguage(), true);
        } else {
            user = userService.loadUserByLogin(startSite.getEmail()).get();
        }

        Sites site = createSite(startSite, user);


        // TODO:
//        respondPublishService.publishDefaultContent(site, user);
//        respondPublishService.PublishMenuJSON(site);

        mailService.sendNewWebsiteEmail(user,
            "inbusiness.space/with/" + site.getFriendlyId(),
            "inbusiness.space/index.html#/login/" +  site.getFriendlyId()
            );

        return site;

    }


    public Sites createSite(StartSite startSite, User user) throws Exception {



        //TODO:
//        final String contentWelcome = respondPublishService.loadFileFromResources(Constants.WELCOME_FILE);
//        final String contentReceipt = respondPublishService.loadFileFromResources(Constants.RECEIPT_FILE);

        //     	    $site = Site::Add($domain, $bucket, $name, $friendlyId, $urlMode, $logoUrl, $theme, $email, $timeZone, $language, $direction, $welcomeEmail, $receiptEmail);
        Sites site = new Sites();
        site.setDomain("/with/"+startSite.getFriendlyId());
        site.setBucket(startSite.getFriendlyId()); // TODO certainement pas bon, mais pour l'instant peu importe
        site.setName(startSite.getName());
        site.setFriendlyId(startSite.getFriendlyId());
        site.setId(startSite.getFriendlyId());
        site.setUrlMode("static");
        site.setLogoUrl("sample-logo.png");
        site.setIconUrl("sample-logo.png"); // too big ... TODO: ADD A real default icon
        site.setIconBg("#FFFFFF");
        site.setUserLimit(100); // Nombre d'utilisateurs qu'on peut ajouter pour gérer un site.

        site.setLanguage(startSite.getLanguage());
        ///////////// TODO: Wil, reset selected theme, patched for tests
        site.setTheme(startSite.getTheme());


        site.setPrimaryEmail(startSite.getEmail());

        // TODO:
//        site.setReceiptEmail(contentReceipt);
//        site.setWelcomeEmail(contentWelcome);
        site.setTimeZone(startSite.getTimeZone());
        site.setFileLimit(50); // Taille maximale en Mo du téléchargement des images.
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(new UserRole(user.getLogin(), "Admin"));
        site.setUserRoleList(userRoleList);
        //site.setTheme(theme);
        createSite(site);

        //TODO:
//        respondPublishService.injectSettings(site);
//        respondPublishService.publishTheme(site);
//        respondPublishService.publishCss(site.getFriendlyId());
//        respondPublishService.publishDefaultSiteContent(site, user);

        return site;
    }


    public void todoPublish(Sites site, String target, String token) {



        try {

            System.out.println("publishing site: " + site.getFriendlyId() + ", on target: " +target);

            // TODO:
            //publishService.drop(target);  //CLear on on remote site

//            publishService.uploadResource(target, "/site/css/libs.min.css", "/css/libs.min.css");
//            publishService.uploadResource(target, "/site/js/libs.min.js", "/js/libs.min.js");
//            publishService.uploadResource(target, "/site/components/lib/webcomponentsjs/webcomponents-lite.min.js", "/components/lib/webcomponentsjs/webcomponents-lite.min.js");
//            publishService.uploadResource(target, "/site/components/respond-build.html", "/components/respond-build.html");

            Pageable pageSpecification = new PageRequest(0, 1000);
            List<AssetMetaData> assets = assetMetaDataSearchRepository.findBySiteIdOrderByUrlAsc(site.getFriendlyId(), pageSpecification);

            List<String> htmlPaths = new ArrayList<>();

            for (AssetMetaData asset: assets) {
                Optional<AssetMetaData> asset2Opt = assetSearchRepository.findByUrl(asset.getUrl());
                AssetMetaData asset2 = asset2Opt.get();

                log.info("publishing to: " + target + ", url:" + asset.getUrl() + ", id" + asset.getId() + ", assetId: " + asset.getId());
                log.info("publishing to: " + target + ", url2:" + asset2.getUrl() + ", id2" + asset2.getId() + ", assetId2: " + asset2.getId());

                   String path =  asset.getUrl();
                   String sitePrefix = "/" + site.getFriendlyId() + "/";
                   if (path.startsWith(sitePrefix )) {
                       path = path.substring(sitePrefix.length()-1);
                   }

                   try {

                       if (asset.getUrl().contains("respond-build.html")) {
                           byte[] content =  asset2.getContent();
                           String html = new String(content);

                           // TODO ... improve this in the future ...
                           html = html.replace("if (respond.site.settings.custoTemplatePath != null) {", "if (false) {" );

                           // TODO:
                           // publishService.upload(target, path, html.getBytes(), token);
                           htmlPaths.add(path);

                           log.info("####### BODY RESPOND, " + asset.getUrl()+ ":\n" + html + "\n#######");

                       }
                       else if ("text/html".equals(asset.getType()) ) {
                           byte[] content =  asset2.getContent();
                           String html = new String(content);

                           // TODO ... improve this in the future ...
                           html = html.replace("<base href=\"/sites/" + site.getFriendlyId() + "/\"", "<base href=\"/\"" );

                           //TODO:
                           // publishService.upload(target, path, html.getBytes(), token);
                           htmlPaths.add(path);

                           if (asset.getUrl().endsWith("/index"))  {
                               log.info("####### BODY INDEX, " + asset.getUrl()+ ":\n" + html + "\n#######");
                           }


                       }
                       else {
                           // TODO:
                           // publishService.upload(target, path, asset2.getContent(), token);
                       }
                   } catch (Exception e) {
                       log.error("FAILED to publish :"  + asset.getUrl() +  ", on target:" + target, e);
                   }

            }

            //TODO:
//            byte[] robotsBytes = publishService.buildRobots(target);
//            publishService.upload(target, "/robots.txt", robotsBytes, token);
//
//            byte[] sitemapBytes = publishService.buildSiteMap(target, htmlPaths);
//            publishService.upload(target, "/sitemap.xml", sitemapBytes, token);


        } catch (Exception e) {
            log.error("Publishing failed on target: " + target);
        }
    }

    public List<Sites> findBySiteId(String siteId) {
        return sitesRepository.findById(siteId);
    }

    public List<Sites> findByPrimaryEmail(String primaryEmail) {
        return sitesRepository.findByPrimaryEmail(primaryEmail);
    }

    public void saveLinkExistingUser(String siteId, UserRole userRole) {
        Sites site = loadSiteById(siteId).get();
        site.getUserRoleList().add(userRole);
        sitesRepository.save(site);
    }

    public void saveUnLinkExistingUser(String userId, String siteId) {
        Sites site = loadSiteById(siteId).get();
        UserRole userRoleToRemove = null;

        for(UserRole userRole : site.getUserRoleList()) {
            if (userRole.getLogin().equals(userId)) {
                userRoleToRemove = userRole;
                break;
            }
        }
        if (userRoleToRemove!=null) {
            site.getUserRoleList().remove(userRoleToRemove);
        }
        sitesRepository.save(site);
    }

    public List<Sites> loadSiteByUser(String login) {
        Query query = Query.query(Criteria.where("userRoleList").elemMatch(Criteria.where("login").is(login)));

        return mongoTemplate.find(query, Sites.class);
    }


}
