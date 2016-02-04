package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface ProductsRepository extends MongoRepository<Products, String> {
}
