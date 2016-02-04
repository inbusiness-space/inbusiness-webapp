package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;
//
//import javax.persistence.Basic;
//import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "sites")
//@Document(indexName="respond")
public class Sites {
    //@Id
    //@javax.persistence.Column(name = "SiteId", nullable = false, insertable = true, updatable = true, length = 50)
    private String id;
    private String altLogoUrl;
    private String payPalLogoUrl;
    private Integer showSearch;
    private String embeddedCodeHead;
    private String embeddedCodeBottom;
    private List<UserRole> userRoleList;

    public String getId() {
        return id;
    }

    public void setId(String siteId) {
        this.id = siteId;
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

    private String domain;

    //@Basic
    //@javax.persistence.Column(name = "Domain", nullable = false, insertable = true, updatable = true, length = 255)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private String bucket;

    //@Basic
    //@javax.persistence.Column(name = "Bucket", nullable = true, insertable = true, updatable = true, length = 255)
    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
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

    private String logoUrl;

    //@Basic
    //@javax.persistence.Column(name = "LogoUrl", nullable = true, insertable = true, updatable = true, length = 512)
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    private String iconUrl;

    //@Basic
    //@javax.persistence.Column(name = "IconUrl", nullable = true, insertable = true, updatable = true, length = 512)
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    private String iconBg;

    //@Basic
    //@javax.persistence.Column(name = "IconBg", nullable = true, insertable = true, updatable = true, length = 10)
    public String getIconBg() {
        return iconBg;
    }

    public void setIconBg(String iconBg) {
        this.iconBg = iconBg;
    }

    private String theme;

    //@Basic
    //@javax.persistence.Column(name = "ThemeDto", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    private Map<String, Map<String, String>> themeFilesMap;

    public Map<String, Map<String, String>> getThemeFilesMap() {
        return themeFilesMap;
    }

    public void setThemeFilesMap(Map<String, Map<String, String>> themeFilesMap) {
        this.themeFilesMap = themeFilesMap;
    }

    private String primaryEmail;

    //@Basic
    //@javax.persistence.Column(name = "PrimaryEmail", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    private String timeZone;

    //@Basic
    //@javax.persistence.Column(name = "TimeZone", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    private String language;

    //@Basic
    //@javax.persistence.Column(name = "Language", nullable = false, insertable = true, updatable = true, length = 10)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String direction;

    //@Basic
    //@javax.persistence.Column(name = "Direction", nullable = false, insertable = true, updatable = true, length = 10)
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private int showCart;

    //@Basic
    //@javax.persistence.Column(name = "ShowCart", nullable = false, insertable = true, updatable = true)
    public int getShowCart() {
        return showCart;
    }

    public void setShowCart(int showCart) {
        this.showCart = showCart;
    }

    private int showSettings;

    //@Basic
    //@javax.persistence.Column(name = "ShowSettings", nullable = false, insertable = true, updatable = true)
    public int getShowSettings() {
        return showSettings;
    }

    public void setShowSettings(int showSettings) {
        this.showSettings = showSettings;
    }

    private int showLanguages;

    //@Basic
    //@javax.persistence.Column(name = "ShowLanguages", nullable = false, insertable = true, updatable = true)
    public int getShowLanguages() {
        return showLanguages;
    }

    public void setShowLanguages(int showLanguages) {
        this.showLanguages = showLanguages;
    }

    private int showLogin;

    //@Basic
    //@javax.persistence.Column(name = "ShowLogin", nullable = false, insertable = true, updatable = true)
    public int getShowLogin() {
        return showLogin;
    }

    public void setShowLogin(int showLogin) {
        this.showLogin = showLogin;
    }

    private String urlMode;

    //@Basic
    //@javax.persistence.Column(name = "UrlMode", nullable = false, insertable = true, updatable = true, length = 10)
    public String getUrlMode() {
        return urlMode;
    }

    public void setUrlMode(String urlMode) {
        this.urlMode = urlMode;
    }

    private String currency;

    //@Basic
    //@javax.persistence.Column(name = "Currency", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String weightUnit;

    //@Basic
    //@javax.persistence.Column(name = "WeightUnit", nullable = false, insertable = true, updatable = true, length = 10)
    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    private String shippingCalculation;

    //@Basic
    //@javax.persistence.Column(name = "ShippingCalculation", nullable = false, insertable = true, updatable = true, length = 10)
    public String getShippingCalculation() {
        return shippingCalculation;
    }

    public void setShippingCalculation(String shippingCalculation) {
        this.shippingCalculation = shippingCalculation;
    }

    private String shippingRate;

    //@Basic
    //@javax.persistence.Column(name = "ShippingRate", nullable = false, insertable = true, updatable = true, precision = 2)
    public String getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
    }

    private String shippingTiers;

    //@Basic
    //@javax.persistence.Column(name = "ShippingTiers", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getShippingTiers() {
        return shippingTiers;
    }

    public void setShippingTiers(String shippingTiers) {
        this.shippingTiers = shippingTiers;
    }

    private String taxRate;

    //@Basic
    //@javax.persistence.Column(name = "TaxRate", nullable = false, insertable = true, updatable = true, precision = 5)
    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    private String payPalId;

    //@Basic
    //@javax.persistence.Column(name = "PayPalId", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPayPalId() {
        return payPalId;
    }

    public void setPayPalId(String payPalId) {
        this.payPalId = payPalId;
    }

    private int payPalUseSandbox;

    //@Basic
    //@javax.persistence.Column(name = "PayPalUseSandbox", nullable = false, insertable = true, updatable = true)
    public int getPayPalUseSandbox() {
        return payPalUseSandbox;
    }

    public void setPayPalUseSandbox(int payPalUseSandbox) {
        this.payPalUseSandbox = payPalUseSandbox;
    }

    private String welcomeEmail;

    //@Basic
    //@javax.persistence.Column(name = "WelcomeEmail", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getWelcomeEmail() {
        return welcomeEmail;
    }

    public void setWelcomeEmail(String welcomeEmail) {
        this.welcomeEmail = welcomeEmail;
    }

    private String receiptEmail;

    //@Basic
    //@javax.persistence.Column(name = "ReceiptEmail", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    private int isSmtp;

    //@Basic
    //@javax.persistence.Column(name = "IsSMTP", nullable = false, insertable = true, updatable = true)
    public int getIsSmtp() {
        return isSmtp;
    }

    public void setIsSmtp(int isSmtp) {
        this.isSmtp = isSmtp;
    }

    private String smtpHost;

    //@Basic
    //@javax.persistence.Column(name = "SMTPHost", nullable = true, insertable = true, updatable = true, length = 512)
    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    private int smtpAuth;

    //@Basic
    //@javax.persistence.Column(name = "SMTPAuth", nullable = false, insertable = true, updatable = true)
    public int getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(int smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    private String smtpUsername;

    //@Basic
    //@javax.persistence.Column(name = "SMTPUsername", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    private String smtpPassword;

    //@Basic
    //@javax.persistence.Column(name = "SMTPPassword", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    private String smtpPasswordIv;

    //@Basic
    //@javax.persistence.Column(name = "SMTPPasswordIV", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSmtpPasswordIv() {
        return smtpPasswordIv;
    }

    public void setSmtpPasswordIv(String smtpPasswordIv) {
        this.smtpPasswordIv = smtpPasswordIv;
    }

    private String smtpSecure;

    //@Basic
    //@javax.persistence.Column(name = "SMTPSecure", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSmtpSecure() {
        return smtpSecure;
    }

    public void setSmtpSecure(String smtpSecure) {
        this.smtpSecure = smtpSecure;
    }

    private String formPrivateId;

    //@Basic
    //@javax.persistence.Column(name = "FormPrivateId", nullable = true, insertable = true, updatable = true, length = 240)
    public String getFormPrivateId() {
        return formPrivateId;
    }

    public void setFormPrivateId(String formPrivateId) {
        this.formPrivateId = formPrivateId;
    }

    private String formPublicId;

    //@Basic
    //@javax.persistence.Column(name = "FormPublicId", nullable = true, insertable = true, updatable = true, length = 240)
    public String getFormPublicId() {
        return formPublicId;
    }

    public void setFormPublicId(String formPublicId) {
        this.formPublicId = formPublicId;
    }

    private String status;

    //@Basic
    //@javax.persistence.Column(name = "Status", nullable = true, insertable = true, updatable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String plan;

    //@Basic
    //@javax.persistence.Column(name = "Plan", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    private String provider;

    //@Basic
    //@javax.persistence.Column(name = "Provider", nullable = true, insertable = true, updatable = true, length = 50)
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    private String subscriptionId;

    //@Basic
    //@javax.persistence.Column(name = "SubscriptionId", nullable = true, insertable = true, updatable = true, length = 256)
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    private String customerId;

    //@Basic
    //@javax.persistence.Column(name = "CustomerId", nullable = true, insertable = true, updatable = true, length = 256)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private int canDeploy;

    //@Basic
    //@javax.persistence.Column(name = "CanDeploy", nullable = false, insertable = true, updatable = true)
    public int getCanDeploy() {
        return canDeploy;
    }

    public void setCanDeploy(int canDeploy) {
        this.canDeploy = canDeploy;
    }

    private int userLimit;

    //@Basic
    //@javax.persistence.Column(name = "UserLimit", nullable = false, insertable = true, updatable = true)
    public int getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(int userLimit) {
        this.userLimit = userLimit;
    }

    private int fileLimit;

    //@Basic
    //@javax.persistence.Column(name = "FileLimit", nullable = false, insertable = true, updatable = true)
    public int getFileLimit() {
        return fileLimit;
    }

    public void setFileLimit(int fileLimit) {
        this.fileLimit = fileLimit;
    }

    private Timestamp lastLogin;

    //@Basic
    //@javax.persistence.Column(name = "LastLogin", nullable = true, insertable = true, updatable = true)
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sites sites = (Sites) o;

        if (showCart != sites.showCart) return false;
        if (showSettings != sites.showSettings) return false;
        if (showLanguages != sites.showLanguages) return false;
        if (showLogin != sites.showLogin) return false;
        if (payPalUseSandbox != sites.payPalUseSandbox) return false;
        if (isSmtp != sites.isSmtp) return false;
        if (smtpAuth != sites.smtpAuth) return false;
        if (canDeploy != sites.canDeploy) return false;
        if (userLimit != sites.userLimit) return false;
        if (fileLimit != sites.fileLimit) return false;
        if (id != null ? !id.equals(sites.id) : sites.id != null) return false;
        if (friendlyId != null ? !friendlyId.equals(sites.friendlyId) : sites.friendlyId != null) return false;
        if (domain != null ? !domain.equals(sites.domain) : sites.domain != null) return false;
        if (bucket != null ? !bucket.equals(sites.bucket) : sites.bucket != null) return false;
        if (name != null ? !name.equals(sites.name) : sites.name != null) return false;
        if (logoUrl != null ? !logoUrl.equals(sites.logoUrl) : sites.logoUrl != null) return false;
        if (iconUrl != null ? !iconUrl.equals(sites.iconUrl) : sites.iconUrl != null) return false;
        if (iconBg != null ? !iconBg.equals(sites.iconBg) : sites.iconBg != null) return false;
        if (theme != null ? !theme.equals(sites.theme) : sites.theme != null) return false;
        if (primaryEmail != null ? !primaryEmail.equals(sites.primaryEmail) : sites.primaryEmail != null) return false;
        if (timeZone != null ? !timeZone.equals(sites.timeZone) : sites.timeZone != null) return false;
        if (language != null ? !language.equals(sites.language) : sites.language != null) return false;
        if (direction != null ? !direction.equals(sites.direction) : sites.direction != null) return false;
        if (urlMode != null ? !urlMode.equals(sites.urlMode) : sites.urlMode != null) return false;
        if (currency != null ? !currency.equals(sites.currency) : sites.currency != null) return false;
        if (weightUnit != null ? !weightUnit.equals(sites.weightUnit) : sites.weightUnit != null) return false;
        if (shippingCalculation != null ? !shippingCalculation.equals(sites.shippingCalculation) : sites.shippingCalculation != null) return false;
        if (shippingRate != null ? !shippingRate.equals(sites.shippingRate) : sites.shippingRate != null) return false;
        if (shippingTiers != null ? !shippingTiers.equals(sites.shippingTiers) : sites.shippingTiers != null) return false;
        if (taxRate != null ? !taxRate.equals(sites.taxRate) : sites.taxRate != null) return false;
        if (payPalId != null ? !payPalId.equals(sites.payPalId) : sites.payPalId != null) return false;
        if (welcomeEmail != null ? !welcomeEmail.equals(sites.welcomeEmail) : sites.welcomeEmail != null) return false;
        if (receiptEmail != null ? !receiptEmail.equals(sites.receiptEmail) : sites.receiptEmail != null) return false;
        if (smtpHost != null ? !smtpHost.equals(sites.smtpHost) : sites.smtpHost != null) return false;
        if (smtpUsername != null ? !smtpUsername.equals(sites.smtpUsername) : sites.smtpUsername != null) return false;
        if (smtpPassword != null ? !smtpPassword.equals(sites.smtpPassword) : sites.smtpPassword != null) return false;
        if (smtpPasswordIv != null ? !smtpPasswordIv.equals(sites.smtpPasswordIv) : sites.smtpPasswordIv != null) return false;
        if (smtpSecure != null ? !smtpSecure.equals(sites.smtpSecure) : sites.smtpSecure != null) return false;
        if (formPrivateId != null ? !formPrivateId.equals(sites.formPrivateId) : sites.formPrivateId != null) return false;
        if (formPublicId != null ? !formPublicId.equals(sites.formPublicId) : sites.formPublicId != null) return false;
        if (status != null ? !status.equals(sites.status) : sites.status != null) return false;
        if (plan != null ? !plan.equals(sites.plan) : sites.plan != null) return false;
        if (provider != null ? !provider.equals(sites.provider) : sites.provider != null) return false;
        if (subscriptionId != null ? !subscriptionId.equals(sites.subscriptionId) : sites.subscriptionId != null) return false;
        if (customerId != null ? !customerId.equals(sites.customerId) : sites.customerId != null) return false;
        if (lastLogin != null ? !lastLogin.equals(sites.lastLogin) : sites.lastLogin != null) return false;
        if (created != null ? !created.equals(sites.created) : sites.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (friendlyId != null ? friendlyId.hashCode() : 0);
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (bucket != null ? bucket.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (logoUrl != null ? logoUrl.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (iconBg != null ? iconBg.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (primaryEmail != null ? primaryEmail.hashCode() : 0);
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + showCart;
        result = 31 * result + showSettings;
        result = 31 * result + showLanguages;
        result = 31 * result + showLogin;
        result = 31 * result + (urlMode != null ? urlMode.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (weightUnit != null ? weightUnit.hashCode() : 0);
        result = 31 * result + (shippingCalculation != null ? shippingCalculation.hashCode() : 0);
        result = 31 * result + (shippingRate != null ? shippingRate.hashCode() : 0);
        result = 31 * result + (shippingTiers != null ? shippingTiers.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (payPalId != null ? payPalId.hashCode() : 0);
        result = 31 * result + payPalUseSandbox;
        result = 31 * result + (welcomeEmail != null ? welcomeEmail.hashCode() : 0);
        result = 31 * result + (receiptEmail != null ? receiptEmail.hashCode() : 0);
        result = 31 * result + isSmtp;
        result = 31 * result + (smtpHost != null ? smtpHost.hashCode() : 0);
        result = 31 * result + smtpAuth;
        result = 31 * result + (smtpUsername != null ? smtpUsername.hashCode() : 0);
        result = 31 * result + (smtpPassword != null ? smtpPassword.hashCode() : 0);
        result = 31 * result + (smtpPasswordIv != null ? smtpPasswordIv.hashCode() : 0);
        result = 31 * result + (smtpSecure != null ? smtpSecure.hashCode() : 0);
        result = 31 * result + (formPrivateId != null ? formPrivateId.hashCode() : 0);
        result = 31 * result + (formPublicId != null ? formPublicId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (subscriptionId != null ? subscriptionId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + canDeploy;
        result = 31 * result + userLimit;
        result = 31 * result + fileLimit;
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }


    public void setAltLogoUrl(String altLogoUrl) {
        this.altLogoUrl = altLogoUrl;
    }

    public String getAltLogoUrl() {
        return altLogoUrl;
    }

    public void setPayPalLogoUrl(String payPalLogoUrl) {
        this.payPalLogoUrl = payPalLogoUrl;
    }

    public String getPayPalLogoUrl() {
        return payPalLogoUrl;
    }

    public void setShowSearch(Integer showSearch) {
        this.showSearch = showSearch;
    }

    public Integer getShowSearch() {
        return showSearch;
    }

    public void setEmbeddedCodeHead(String embeddedCodeHead) {
        this.embeddedCodeHead = embeddedCodeHead;
    }

    public String getEmbeddedCodeHead() {
        return embeddedCodeHead;
    }

    public void setEmbeddedCodeBottom(String embeddedCodeBottom) {
        this.embeddedCodeBottom = embeddedCodeBottom;
    }

    public String getEmbeddedCodeBottom() {
        return embeddedCodeBottom;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
