package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;
//
//import javax.persistence.Basic;
//import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "Pages")
//@Document(indexName="respond")
@org.springframework.data.mongodb.core.mapping.Document(collection = "pages")
public class Pages {
    //@Id
    ////@javax.persistence.Column(name = "PageId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String pageId) {
        this.id = pageId;
    }

    private String userId;

    private String siteId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    private String friendlyId;

    //@Basic
    //@javax.persistence.Column(name = "FriendlyId", nullable = true, insertable = true, updatable = true, length = 50)
    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    private String name;

    //@Basic
    //@javax.persistence.Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    //@Basic
    //@javax.persistence.Column(name = "Description", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String keywords;

    //@Basic
    //@javax.persistence.Column(name = "Keywords", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    private String tags;

    //@Basic
    //@javax.persistence.Column(name = "Tags", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private String content;

    //@Basic
    //@javax.persistence.Column(name = "Content", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String draft;

    //@Basic
    //@javax.persistence.Column(name = "Draft", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    private String callout;

    //@Basic
    //@javax.persistence.Column(name = "Callout", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCallout() {
        return callout;
    }

    public void setCallout(String callout) {
        this.callout = callout;
    }

    private Timestamp beginDate;

    //@Basic
    //@javax.persistence.Column(name = "BeginDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    private Timestamp endDate;

    //@Basic
    //@javax.persistence.Column(name = "EndDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    private String location;

    //@Basic
    //@javax.persistence.Column(name = "Location", nullable = true, insertable = true, updatable = true, length = 1024)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Location latLong;

    //@Basic
    //@javax.persistence.Column(name = "LatLong", nullable = true, insertable = true, updatable = true)
    public Location getLatLong() {
        return latLong;
    }

    public void setLatLong(Location latLong) {
        this.latLong = latLong;
    }

    private String layout;

    //@Basic
    //@javax.persistence.Column(name = "Layout", nullable = true, insertable = true, updatable = true, length = 50)
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    private String stylesheet;

    //@Basic
    //@javax.persistence.Column(name = "Stylesheet", nullable = true, insertable = true, updatable = true, length = 50)
    public String getStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    private Boolean active;

    //@javax.persistence.Column(name = "IsActive", nullable = true, insertable = true, updatable = true)
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean isActive) {
        this.active = isActive;
    }

    private String image;

    //@Basic
    //@javax.persistence.Column(name = "Image", nullable = true, insertable = true, updatable = true, length = 256)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private Boolean includeOnly;

    //@Basic
    //@javax.persistence.Column(name = "IncludeOnly", nullable = false, insertable = true, updatable = true)
    public Boolean getIncludeOnly() {
        return includeOnly;
    }

    public void setIncludeOnly(Boolean includeOnly) {
        this.includeOnly = includeOnly;
    }

    private String pageTypeId;

    //@Basic
    //@javax.persistence.Column(name = "PageTypeId", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPageTypeId() {
        return pageTypeId;
    }

    public void setPageTypeId(String pageTypeId) {
        this.pageTypeId = pageTypeId;
    }

    private String pageTypeFriendlyId;
    //@Basic
    //@javax.persistence.Column(name = "PageTypeFriendlyId", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPageTypeFriendlyId() {
        return pageTypeFriendlyId;
    }

    public void setPageTypeFriendlyId(String pageTypeFriendlyId) {
        this.pageTypeFriendlyId = pageTypeFriendlyId;
    }


    private String lastModifiedBy;

    //@Basic
    //@javax.persistence.Column(name = "LastModifiedBy", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    private Timestamp lastModifiedDate;

    //@Basic
    //@javax.persistence.Column(name = "LastModifiedDate", nullable = false, insertable = true, updatable = true)
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private Timestamp created;

    //@Basic
    //@javax.persistence.Column(name = "Created", nullable = false, insertable = true, updatable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Pages() {
        super();
    }

    public Pages(Pages ref) {
//        this.id = ref.id;
        this.userId = ref.userId;
        this.siteId = ref.siteId;
        this.friendlyId = ref.friendlyId;
        this.name = ref.name;
        this.description = ref.description;
        this.keywords = ref.keywords;
        this.tags = ref.tags;
        this.content = ref.content;
        this.draft = ref.draft;
        this.callout = ref.callout;
        this.beginDate = ref.beginDate;
        this.endDate = ref.endDate;
        this.location = ref.location;
        this.latLong = ref.latLong;
        this.layout = ref.layout;
        this.stylesheet = ref.stylesheet;
        this.active = ref.active;
        this.image = ref.image;
        this.includeOnly = ref.includeOnly;
        this.pageTypeId = ref.pageTypeId;
        this.pageTypeFriendlyId = ref.pageTypeFriendlyId;
        this.lastModifiedBy = ref.lastModifiedBy;
        this.created = new Timestamp(new Date().getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pages pages = (Pages) o;

        if (includeOnly != null ? !includeOnly.equals(pages.includeOnly) : pages.includeOnly != null) return false;
        if (id != null ? !id.equals(pages.id) : pages.id != null) return false;
        if (friendlyId != null ? !friendlyId.equals(pages.friendlyId) : pages.friendlyId != null) return false;
        if (name != null ? !name.equals(pages.name) : pages.name != null) return false;
        if (description != null ? !description.equals(pages.description) : pages.description != null) return false;
        if (keywords != null ? !keywords.equals(pages.keywords) : pages.keywords != null) return false;
        if (tags != null ? !tags.equals(pages.tags) : pages.tags != null) return false;
        if (content != null ? !content.equals(pages.content) : pages.content != null) return false;
        if (draft != null ? !draft.equals(pages.draft) : pages.draft != null) return false;
        if (callout != null ? !callout.equals(pages.callout) : pages.callout != null) return false;
        if (beginDate != null ? !beginDate.equals(pages.beginDate) : pages.beginDate != null) return false;
        if (endDate != null ? !endDate.equals(pages.endDate) : pages.endDate != null) return false;
        if (location != null ? !location.equals(pages.location) : pages.location != null) return false;
        if (latLong != null ? !latLong.equals(pages.latLong) : pages.latLong != null) return false;
        if (layout != null ? !layout.equals(pages.layout) : pages.layout != null) return false;
        if (stylesheet != null ? !stylesheet.equals(pages.stylesheet) : pages.stylesheet != null) return false;
        if (active != null ? !active.equals(pages.active) : pages.active != null) return false;
        if (image != null ? !image.equals(pages.image) : pages.image != null) return false;
        if (pageTypeId != null ? !pageTypeId.equals(pages.pageTypeId) : pages.pageTypeId != null) return false;
        if (lastModifiedBy != null ? !lastModifiedBy.equals(pages.lastModifiedBy) : pages.lastModifiedBy != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(pages.lastModifiedDate) : pages.lastModifiedDate != null) return false;
        if (created != null ? !created.equals(pages.created) : pages.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (friendlyId != null ? friendlyId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (draft != null ? draft.hashCode() : 0);
        result = 31 * result + (callout != null ? callout.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (latLong != null ? latLong.hashCode() : 0);
        result = 31 * result + (layout != null ? layout.hashCode() : 0);
        result = 31 * result + (stylesheet != null ? stylesheet.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (includeOnly != null ? includeOnly.hashCode() : 0);
        result = 31 * result + (pageTypeId != null ? pageTypeId.hashCode() : 0);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
