package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fer on 05/07/2015.
 */
public class MenuItemsDto {
    private String id;
    private String name;
    private String cssClass;
    private String type;
    private String url;
    private String pageId;
    private Integer priority;
    private String siteId;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;
    private int nested;


    public MenuItemsDto() {
        super();
    }

    public MenuItemsDto(String name, String cssClass, String type, String url, String pageId, Integer priority, String siteId, String lastModifiedBy) {
        this.name = name;
        this.cssClass = cssClass;
        this.type = type;
        this.url = url;
        this.pageId = pageId;
        this.priority = priority;
        this.siteId = siteId;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = new Timestamp(new Date().getTime());
    }

    @JsonProperty("MenuItemId")
    public String getId() {
        return id;
    }

    public void setId(String menuItemId) {
        this.id = menuItemId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("CssClass")
    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("PageId")
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    @JsonProperty("Priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    @JsonProperty("IsNested")
    public int getNested() {
        return nested;
    }

    public void setNested(int nested) {
        this.nested = nested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItemsDto menuItems = (MenuItemsDto) o;

        if (id != null ? !id.equals(menuItems.id) : menuItems.id != null) return false;
        if (name != null ? !name.equals(menuItems.name) : menuItems.name != null) return false;
        if (cssClass != null ? !cssClass.equals(menuItems.cssClass) : menuItems.cssClass != null) return false;
        if (type != null ? !type.equals(menuItems.type) : menuItems.type != null) return false;
        if (url != null ? !url.equals(menuItems.url) : menuItems.url != null) return false;
        if (pageId != null ? !pageId.equals(menuItems.pageId) : menuItems.pageId != null) return false;
        if (priority != null ? !priority.equals(menuItems.priority) : menuItems.priority != null) return false;
        if (siteId != null ? !siteId.equals(menuItems.siteId) : menuItems.siteId != null) return false;
        if (lastModifiedBy != null ? !lastModifiedBy.equals(menuItems.lastModifiedBy) : menuItems.lastModifiedBy != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(menuItems.lastModifiedDate) : menuItems.lastModifiedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cssClass != null ? cssClass.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (pageId != null ? pageId.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (lastModifiedBy != null ? lastModifiedBy.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }
}
