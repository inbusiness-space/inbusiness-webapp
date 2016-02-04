package inbusiness.space.webapp.repository;

import inbusiness.space.webapp.domain.PageTypes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface PageTypesRepository extends MongoRepository<PageTypes, String> {
    Optional<PageTypes> findByFriendlyIdAndSiteId(String friendlyId, String siteId);
    List<PageTypes> findBySiteId(String siteId, Pageable pageable);
}
