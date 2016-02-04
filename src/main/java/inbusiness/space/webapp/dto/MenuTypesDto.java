package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class MenuTypesDto {
    private String id;
    private String friendlyId;
    private String name;
    private String siteId;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String menuTypeId) {
        this.id = menuTypeId;
    }

    @JsonProperty("FriendlyId")
    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("SiteId")
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("LastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonProperty("LastModifiedDate")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuTypesDto menuTypes = (MenuTypesDto) o;

        if (lastModifiedBy != menuTypes.lastModifiedBy) return false;
        if (id != null ? !id.equals(menuTypes.id) : menuTypes.id != null) return false;
        if (friendlyId != null ? !friendlyId.equals(menuTypes.friendlyId) : menuTypes.friendlyId != null) return false;
        if (name != null ? !name.equals(menuTypes.name) : menuTypes.name != null) return false;
        if (siteId != null ? !siteId.equals(menuTypes.siteId) : menuTypes.siteId != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(menuTypes.lastModifiedDate) : menuTypes.lastModifiedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (friendlyId != null ? friendlyId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }
}
