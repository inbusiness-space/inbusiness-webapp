package inbusiness.space.webapp.security.dto;

/**
 * Created by fer on 21/07/2015.
 */
public class DataToken {
    private String siteId;
    private String userId;

    public DataToken() {
        super();
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
