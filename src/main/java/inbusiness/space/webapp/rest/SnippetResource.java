package inbusiness.space.webapp.rest;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import inbusiness.space.webapp.domain.AssetMetaData;
import inbusiness.space.webapp.Constants;
import inbusiness.space.webapp.domain.Snippet;
import inbusiness.space.webapp.repository.AssetSearchRepository;
import inbusiness.space.webapp.repository.SnippetRepository;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST controller for managing Asset.
 */
@RestController
public class SnippetResource {

    private final Logger log = LoggerFactory.getLogger(SnippetResource.class);

    @Inject
    private SnippetRepository snippetRepository;

//    @Inject
//    private RespondPublishService respondPublishService;

    @Inject
    private AssetSearchRepository assetSearchRepository;

    @RequestMapping(value = "/api/snippet",
            method = RequestMethod.GET)
    @Timed
    public ResponseEntity<Map<String, Snippet>> snippetList() throws IOException {
        Pageable pageSpecification = new PageRequest(0, 1000);
        final Iterable<Snippet> snippetIter = snippetRepository.findAll(pageSpecification);
        final Map<String, Snippet> snippetMap = new HashMap<>();

        snippetIter.forEach(s -> snippetMap.put(s.getId(), s));

        if (snippetMap.size()==0) {
            publishResourcesSnippetToAsset(snippetMap);
        }

        return new ResponseEntity<>(snippetMap, HttpStatus.OK);
    }

    private void publishResourcesSnippetToAsset(final Map<String, Snippet> snippetMap) throws IOException {
        // Les snippets ne sont pas encore en base
        final String resourceSnippetsDirExt = Constants.RESOURCE_SNIPPETS;
        String snippetFile = "snippets_ext_copy_create.txt";
        final String resourceName = resourceSnippetsDirExt + "/" + snippetFile;
        log.info("Snippets : " + resourceName);
        List<String> items = IOUtils.readLines(this.getClass().getResourceAsStream(resourceName));

        for(String snippetName : items) {
            final String snippetImageResource = resourceSnippetsDirExt + "/" + snippetName + "/screenshot.png";
            final String snippetHtmlResource = resourceSnippetsDirExt + "/" + snippetName + "/snippet.html";
            final String snippetInfoResource = resourceSnippetsDirExt + "/" + snippetName + "/snippet.json";
            try (final InputStream snippetInputStream = this.getClass().getResourceAsStream(snippetInfoResource);
                 final InputStream imageInputStream = this.getClass().getResourceAsStream(snippetImageResource);
                 final InputStream htmlInputStream = this.getClass().getResourceAsStream(snippetHtmlResource)) {
                final ByteArrayOutputStream baosImage = new ByteArrayOutputStream();
                final ByteArrayOutputStream baosHtml = new ByteArrayOutputStream();
                IOUtils.copy(imageInputStream, baosImage);
                IOUtils.copy(htmlInputStream, baosHtml);
                final Snippet snippet = new ObjectMapper().readValue(snippetInputStream, Snippet.class);
                snippet.setId(snippetName);


                // TODO: publish
//                respondPublishService.publishToAssets("/snippets/" + snippetName, "root", "image/png", baosImage.toByteArray(), "screenshot.png");
//                respondPublishService.publishToAssets("/snippets/"+snippetName, "root", "text/html", baosHtml.toByteArray(), "snippet.html");
                snippetRepository.save(snippet);
                snippetMap.put(snippet.getId(), snippet);
            }

        }
    }

    @RequestMapping(value = "/api/snippet/content",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_HTML_VALUE
    )
    @Timed
    public String snippetContent(HttpServletRequest httpRequest // , HttpServletResponse response
            , @RequestParam(required = false) String snippet) throws IOException {
        if (snippet==null) {
            return "";
        }
//        final Snippet snippetResource = snippetRepository.findOne(snippet);
        final String url = "/snippets/" + snippet + "/snippet.html";
        final Optional<AssetMetaData> asset = assetSearchRepository.findByUrl(url);

        if (asset.isPresent()) {
            return new String(asset.get().getContent(), "UTF-8");
        } else {
            return "";
        }
    }

}
