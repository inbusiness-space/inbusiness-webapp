package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.AssetMetaData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data ElasticSearch repository for the Asset entity.
 */
public interface AssetMetaDataSearchRepository extends MongoRepository<AssetMetaData, String> {
    Optional<AssetMetaData> findByUrl(String url);

    List<AssetMetaData> findBySiteIdAndExtensionInOrderByUrlAsc(String siteName, Collection<String> extensionCollection, Pageable pageable);
    List<AssetMetaData> findBySiteIdOrderByUrlAsc(String siteName, Pageable pageable);
}
