package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Pages;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface PagesRepository extends MongoRepository<Pages, String> {


    Optional<Pages> findByFriendlyIdAndPageTypeIdAndSiteId(String friendlyId, String pageTypeId, String siteId);

    List<Pages> findBySiteId(String siteId, Pageable pageable);
    List<Pages> findByPageTypeIdAndSiteId(String pageTypeId, String siteId, Pageable pageable);
    List<Pages> findByFriendlyIdAndSiteId(String friendlyId, String siteId);

    List<Pages> findPagesByLastModifiedByAndSiteIdAndPageTypeId(String lastModifiedBy, String siteId, String pageTypeId, Pageable pageable);
}
