package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Versions;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface VersionsRepository extends MongoRepository<Versions, String> {
}
