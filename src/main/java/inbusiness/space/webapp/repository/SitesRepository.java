package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Sites;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface SitesRepository extends MongoRepository<Sites, String> {
    List<Sites> findById(String id);
    List<Sites> findByPrimaryEmail(String primaryEmail);
}
