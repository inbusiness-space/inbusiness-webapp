package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.MenuItems;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface MenuItemsRepository extends MongoRepository<MenuItems, String> {

    List<MenuItems> findBySiteIdAndTypeOrderByPriorityAsc(String siteId, String type, Pageable pageable);

    List<MenuItems> findBySiteIdOrderByPriorityAsc(String siteId, Pageable pageable);
}
