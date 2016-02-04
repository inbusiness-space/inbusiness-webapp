package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Website;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data ElasticSearch repository for the Website entity.
 */
public interface WebsiteSearchRepository extends MongoRepository<Website, String> {
}
