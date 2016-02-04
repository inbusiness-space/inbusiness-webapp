package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import inbusiness.space.webapp.domain.Location;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class PagesDto {
    private String id;

    @JsonProperty("PageId")
    public String getId() {
        return id;
    }

    public void setId(String pageId) {
        this.id = pageId;
    }

    private String userId;

    private String siteId;

    @JsonProperty("UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("SiteId")
    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    private String friendlyId;

    @JsonProperty("FriendlyId")
    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    private String name;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description;

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String keywords;

    @JsonProperty("Keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    private String tags;

    @JsonProperty("Tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    private String content;

    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String draft;

    @JsonProperty("Draft")
    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    private String callout;

    @JsonProperty("Callout")
    public String getCallout() {
        return callout;
    }

    public void setCallout(String callout) {
        this.callout = callout;
    }

    private Timestamp beginDate;

    @JsonProperty("BeginDate")
    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    private Timestamp endDate;

    @JsonProperty("EndDate")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    private String location;

    @JsonProperty("Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Location latLong;

    @JsonProperty("LatLong")
    public Location getLatLong() {
        return latLong;
    }

    public void setLatLong(Location latLong) {
        this.latLong = latLong;
    }

    private String layout;

    @JsonProperty("Layout")
    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    private String stylesheet;

    @JsonProperty("Stylesheet")
    public String getStylesheet() {
        return stylesheet;
    }

    public void setStylesheet(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    private int active;

    @JsonProperty("IsActive")
    public int isActive() {
        return active;
    }

    public void setActive(int isActive) {
        this.active = isActive;
    }

    private String image;

    @JsonProperty("Image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String thumb;

    @JsonProperty("Thumb")
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    private Boolean includeOnly;

    @JsonProperty("IncludeOnly")
    public Boolean getIncludeOnly() {
        return includeOnly;
    }

    public void setIncludeOnly(Boolean includeOnly) {
        this.includeOnly = includeOnly;
    }



    private String pageTypeId;

    @JsonProperty("PageTypeId")
    public String getPageTypeId() {
        return pageTypeId;
    }

    public void setPageTypeId(String pageTypeId) {
        this.pageTypeId = pageTypeId;
    }

    private String lastModifiedBy;

    @JsonProperty("LastModifiedBy")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    private String lastModifiedDate;

    @JsonProperty("LastModifiedDate")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private Timestamp created;

    @JsonProperty("Created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean edit;
    public boolean publish;
    public boolean remove;
    public String url;
    public boolean hasDraft;
    public String lastModifiedFullName;


    @JsonProperty("LastModifiedFullName")
    public String getLastModifiedFullName() {
        return lastModifiedFullName;
    }

    public void setLastModifiedFullName(String lastModifiedFullName) {
        this.lastModifiedFullName = lastModifiedFullName;
    }

    @JsonProperty("CanEdit")
    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @JsonProperty("CanPublish")
    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    @JsonProperty("CanRemove")
    public boolean isRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    @JsonProperty("IsActive")
    public int getActive() {
        return active;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("HasDraft")
    public boolean isHasDraft() {
        return hasDraft;
    }

    public void setHasDraft(boolean hasDraft) {
        this.hasDraft = hasDraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagesDto pages = (PagesDto) o;

        if (id != null ? !id.equals(pages.id) : pages.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return result;
    }
}
