package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "PageTypes")
//@Document(indexName="respond")
@org.springframework.data.mongodb.core.mapping.Document(collection = "pagesTypes")
public class PageTypes {
    //@Id
    //@Column(name = "PageTypeId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;
    private String friendlyId;
    private String siteId;
    private String layout;
    private String stylesheet;
    private boolean secure;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;


    public String getId() {
        return id;
    }

    public void setId(String pageTypeId) {
        this.id = pageTypeId;
    }

    //@Basic
    //@Column(name = "FriendlyId", nullable = true, insertable = true, updatable = true, length = 50)
    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    //@Basic
    //@Column(name = "FriendlyId", nullable = true, insertable = true, updatable = true, length = 50)
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    //@Basic
    //@Column(name = "Layout", nullable = true, insertable = true, updatable = true, length = 50)
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    //@Basic
    //@Column(name = "Stylesheet", nullable = true, insertable = true, updatable = true, length = 50)
    public String getStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    //@Basic
    //@Column(name = "IsSecure", nullable = false, insertable = true, updatable = true)
    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean isSecure) {
        this.secure = isSecure;
    }

    //@Basic
    //@Column(name = "LastModifiedBy", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    //@Basic
    //@Column(name = "LastModifiedDate", nullable = false, insertable = true, updatable = true)
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

        PageTypes pageTypes = (PageTypes) o;

        if (secure != pageTypes.secure) return false;
        if (id != null ? !id.equals(pageTypes.id) : pageTypes.id != null) return false;
        if (friendlyId != null ? !friendlyId.equals(pageTypes.friendlyId) : pageTypes.friendlyId != null) return false;
        if (layout != null ? !layout.equals(pageTypes.layout) : pageTypes.layout != null) return false;
        if (stylesheet != null ? !stylesheet.equals(pageTypes.stylesheet) : pageTypes.stylesheet != null) return false;
        if (lastModifiedBy != null ? !lastModifiedBy.equals(pageTypes.lastModifiedBy) : pageTypes.lastModifiedBy != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(pageTypes.lastModifiedDate) : pageTypes.lastModifiedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (friendlyId != null ? friendlyId.hashCode() : 0);
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        result = 31 * result + (stylesheet != null ? stylesheet.hashCode() : 0);
        result = 31 * result + (secure?0:1);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }
}
