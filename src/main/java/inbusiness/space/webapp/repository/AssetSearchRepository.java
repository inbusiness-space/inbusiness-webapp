package inbusiness.space.webapp.repository;


import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import inbusiness.space.webapp.domain.AssetMetaData;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Spring Data repository for the Asset entity.
 */
@Component
public class AssetSearchRepository {

    @Inject
    private GridFsOperations gridFsOperations;

    @Inject
    private AssetMetaDataSearchRepository assetMetaDataSearchRepository;

    public String save(AssetMetaData asset) {
        final AssetMetaData assetMetaData;
        if (asset.getId() != null) {
            assetMetaData = assetMetaDataSearchRepository.findOne(asset.getId());
        } else {
            assetMetaData = new AssetMetaData(asset);
        }

        try {
            try (InputStream is = new ByteArrayInputStream(asset.getContent())) {

                GridFSFile gridFSFile = gridFsOperations.store(is, asset.getUrl(), asset.getType(), new AssetMetaData(asset));
                String assetId = gridFSFile.getId().toString();
                assetMetaData.setAssetId(assetId);
                AssetMetaData assetMetaDataWithId = assetMetaDataSearchRepository.save(assetMetaData);
                asset.setId(assetMetaDataWithId.getId());
                asset.setAssetId(assetId);

                return assetMetaDataWithId.getId();
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void delete(String assetMetaDataId) {
        AssetMetaData assetMetaData = assetMetaDataSearchRepository.findOne(assetMetaDataId);
        gridFsOperations.delete(new Query().addCriteria(Criteria.where("id").is(assetMetaData.getAssetId())));
        assetMetaDataSearchRepository.delete(assetMetaData.getId());
    }

    public Optional<AssetMetaData> findByUrl(String url) {
        Optional<AssetMetaData> assetMetaData = assetMetaDataSearchRepository.findByUrl(url);
        if (!assetMetaData.isPresent()) {
            return Optional.empty();
        }
        AssetMetaData asset = assetMetaData.get();

        // GridFSDBFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("filename").is(url)));
        GridFSDBFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("_id").is(asset.getAssetId())));

        return loadContentAsset(asset, gridFSFile);
    }

    private Optional<AssetMetaData> loadContentAsset(AssetMetaData asset, GridFSDBFile gridFSFile) {
        try {
            try (ByteArrayOutputStream contentStream = new ByteArrayOutputStream()) {
                gridFSFile.writeTo(contentStream);
                asset.setContent(contentStream.toByteArray());
                return Optional.of(asset);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Optional<AssetMetaData> findOne(String idAssetMetaData) {
        AssetMetaData assetMetaData = assetMetaDataSearchRepository.findOne(idAssetMetaData);
        if (assetMetaData==null) {
            return Optional.empty();
        }
        AssetMetaData asset = assetMetaData;

        GridFSDBFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("filename").is(asset.getUrl())));
        return loadContentAsset(asset, gridFSFile);
    }

    public Optional<AssetMetaData> _findOne_fix(String idAssetMetaData) {
        AssetMetaData assetMetaData = assetMetaDataSearchRepository.findOne(idAssetMetaData);
        if (assetMetaData==null) {
            return Optional.empty();
        }
        AssetMetaData asset = assetMetaData;

        GridFSDBFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("metadata/id").is(asset.getAssetId())));
        return loadContentAsset(asset, gridFSFile);
    }

    public AssetMetaData findOne(AssetMetaData assetMetaData) {

        GridFSDBFile gridFSFile = gridFsOperations.findOne(new Query().addCriteria(Criteria.where("filename").is(assetMetaData.getUrl())));
        try {
            try (ByteArrayOutputStream contentStream = new ByteArrayOutputStream()) {
                gridFSFile.writeTo(contentStream);
                assetMetaData.setContent(contentStream.toByteArray());
                return assetMetaData;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
