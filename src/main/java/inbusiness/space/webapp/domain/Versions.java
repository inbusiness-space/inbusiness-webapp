package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "Versions")
//@Document(indexName="respond")
public class Versions {
    //@Id
    //@Column(name = "VersionId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;
    private String content;
    private Timestamp created;
    private String pageId;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String versionId) {
        this.id = versionId;
    }

    //@Basic
    //@Column(name = "Content", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //@Basic
    //@Column(name = "Created", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Versions versions = (Versions) o;

        if (id != null ? !id.equals(versions.id) : versions.id != null) return false;
        if (content != null ? !content.equals(versions.content) : versions.content != null) return false;
        if (created != null ? !created.equals(versions.created) : versions.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
