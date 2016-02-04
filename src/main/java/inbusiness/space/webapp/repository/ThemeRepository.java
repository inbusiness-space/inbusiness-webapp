package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.domain.Theme;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface ThemeRepository extends MongoRepository<Theme, String> {
    List<Theme> findById(String id);
    List<Theme> findByFriendlyId(String id);
    List<Theme> findByOwnerId(String primaryEmail);
}
