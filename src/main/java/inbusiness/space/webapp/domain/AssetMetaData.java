package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldIndex;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Asset.
 */
////@Document(indexName="respond")
@org.springframework.data.mongodb.core.mapping.Document(collection = "assetMetaData")
public class AssetMetaData implements Serializable {

    //@Id
    private String id;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    ////@Column(name = "name", length = 50, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String name;

    @NotNull
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    ////@Column(name = "uuid", length = 50, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String uuid;

    @NotNull
    @Size(max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    ////@Column(name = "url", length = 200, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String url;

    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    ////@Column(name = "type", length = 50, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String type;

    @NotNull
    @Size(max = 100)
    ////@Column(name = "ownername", length = 100, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String ownername;

    @NotNull
    @Size(max = 100)
    ////@Column(name = "siteid", length = 100, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String siteId;

    @Size(max = 100)
    ////@Column(name = "extension", length = 100, nullable = false)
    //@Field(type= FieldType.String, index = FieldIndex.not_analyzed)
    private String extension;

    //@Field(type= FieldType.Integer, index = FieldIndex.not_analyzed)
    private Integer size;

    //@Field(type= FieldType.Integer, index = FieldIndex.not_analyzed)
    private Integer width;

    //@Field(type= FieldType.Integer, index = FieldIndex.not_analyzed)
    private Integer height;

    private String assetId;
    private byte[] content;

    public AssetMetaData() {
        super();
        content = new byte[0];
    }

    public AssetMetaData(AssetMetaData asset) {
        super();
        this.name = asset.getName();
        this.ownername = asset.getOwnername();
        this.extension = asset.getExtension();
        this.siteId = asset.getSiteId();
        this.type = asset.getType();
        this.uuid = asset.getUuid();
        this.url = asset.getUrl();
        if (asset.getContent()!=null) {
            this.size = asset.getContent().length;
        }
        this.width = asset.getWidth();
        this.height = asset.getHeight();
        this.assetId = asset.getId();
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        if (url!=null) {
            int indexLastDot = url.lastIndexOf('.');
            if (indexLastDot>=0) {
                this.extension = url.substring(indexLastDot+1);
            }
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AssetMetaData asset = (AssetMetaData) o;

        if ( ! Objects.equals(id, asset.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", uuid='" + uuid + "'" +
                ", url='" + url + "'" +
                ", type='" + type + "'" +
                ", ownername='" + ownername + "'" +
                '}';
    }
}
