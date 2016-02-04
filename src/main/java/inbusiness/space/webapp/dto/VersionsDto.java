package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class VersionsDto {
    private String id;
    private String content;
    private Timestamp created;
    private String pageId;
    private String userId;

    @JsonProperty("VersionId")
    public String getId() {
        return id;
    }

    public void setId(String versionId) {
        this.id = versionId;
    }

    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("Created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @JsonProperty("PageId")
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @JsonProperty("UserId")
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

        VersionsDto versions = (VersionsDto) o;

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
