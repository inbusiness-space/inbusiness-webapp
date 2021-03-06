package inbusiness.space.webapp.repository;

import inbusiness.space.webapp.domain.Snippet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface SnippetRepository extends MongoRepository<Snippet, String> {
}
