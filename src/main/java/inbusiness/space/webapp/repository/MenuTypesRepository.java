package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.MenuTypes;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface MenuTypesRepository extends MongoRepository<MenuTypes, String> {
    List<MenuTypes> findBySiteId(String siteId, Pageable pageable);
}
