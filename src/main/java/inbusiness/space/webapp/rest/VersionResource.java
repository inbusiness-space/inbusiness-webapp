package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import inbusiness.space.webapp.domain.Versions;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.VersionsRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import inbusiness.space.webapp.security.dto.DataToken;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by fer on 20/07/2015.
 */
@RestController
@RequestMapping("/api/version")
public class VersionResource {

    @Inject
    private VersionsRepository versionsRepository;

    @Inject
    @Named("respondMapperImpl")
    private RespondMapper respondMapper;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public Versions add(HttpServletRequest httpRequest
            , @RequestParam String pageId
            , @RequestParam String content
    ) throws IOException {

        // TODO Mise en place des droits. On a tous les droits pour l'instant.
        DataToken dataToken = SecurityUtils.getDataToken(httpRequest);

        Versions version = new Versions();
        version.setContent(content);
        version.setPageId(pageId);
        version.setUserId(dataToken.getUserId());
        version.setCreated(new Timestamp(System.currentTimeMillis()));

        return versionsRepository.save(version);
    }

}
