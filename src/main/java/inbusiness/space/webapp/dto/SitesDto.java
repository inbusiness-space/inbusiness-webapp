package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class SitesDto {
    private String id;
    private String altLogoUrl;
    private String payPalLogoUrl;
    private String showSearch;
    private String embeddedCodeHead;
    private String embeddedCodeBottom;


    @JsonProperty("SiteId")
    public String getId() {
        return id;
    }

    public void setId(String siteId) {
        this.id = siteId;
    }

    private String friendlyId;

    @JsonProperty("FriendlyId")
    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    private String domain;

    @JsonProperty("Domain")
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private String bucket;

    @JsonProperty("Bucket")
    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    private String name;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String logoUrl;

    @JsonProperty("LogoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    private String iconUrl;

    @JsonProperty("IconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    private String iconBg;

    @JsonProperty("IconBg")
    public String getIconBg() {
        return iconBg;
    }

    public void setIconBg(String iconBg) {
        this.iconBg = iconBg;
    }

    private String theme;

    @JsonProperty("ThemeDto")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    private String primaryEmail;

    @JsonProperty("PrimaryEmail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    private String timeZone;

    @JsonProperty("TimeZone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    private String language;

    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String direction;

    @JsonProperty("Direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private String showCart;

    @JsonProperty("ShowCart")
    public String getShowCart() {
        return showCart;
    }

    public void setShowCart(String showCart) {
        this.showCart = showCart;
    }

    private String showSettings;

    @JsonProperty("ShowSettings")
    public String getShowSettings() {
        return showSettings;
    }

    public void setShowSettings(String showSettings) {
        this.showSettings = showSettings;
    }

    private String showLanguages;

    @JsonProperty("ShowLanguages")
    public String getShowLanguages() {
        return showLanguages;
    }

    public void setShowLanguages(String showLanguages) {
        this.showLanguages = showLanguages;
    }

    private String showLogin;

    @JsonProperty("ShowLogin")
    public String getShowLogin() {
        return showLogin;
    }

    public void setShowLogin(String showLogin) {
        this.showLogin = showLogin;
    }

    private String urlMode;

    @JsonProperty("UrlMode")
    public String getUrlMode() {
        return urlMode;
    }

    public void setUrlMode(String urlMode) {
        this.urlMode = urlMode;
    }

    private String currency;

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String weightUnit;

    @JsonProperty("WeightUnit")
    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    private String shippingCalculation;

    @JsonProperty("ShippingCalculation")
    public String getShippingCalculation() {
        return shippingCalculation;
    }

    public void setShippingCalculation(String shippingCalculation) {
        this.shippingCalculation = shippingCalculation;
    }

    private String shippingRate;

    @JsonProperty("ShippingRate")
    public String getShippingRate() {
        return shippingRate;
    }

    public void setShippingRate(String shippingRate) {
        this.shippingRate = shippingRate;
    }

    private String shippingTiers;

    @JsonProperty("ShippingTiers")
    public String getShippingTiers() {
        return shippingTiers;
    }

    public void setShippingTiers(String shippingTiers) {
        this.shippingTiers = shippingTiers;
    }

    private String taxRate;

    @JsonProperty("TaxRate")
    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    private String payPalId;

    @JsonProperty("PayPalId")
    public String getPayPalId() {
        return payPalId;
    }

    public void setPayPalId(String payPalId) {
        this.payPalId = payPalId;
    }

    private String payPalUseSandbox;

    @JsonProperty("PayPalUseSandbox")
    public String getPayPalUseSandbox() {
        return payPalUseSandbox;
    }

    public void setPayPalUseSandbox(String payPalUseSandbox) {
        this.payPalUseSandbox = payPalUseSandbox;
    }

    private String welcomeEmail;

    @JsonProperty("WelcomeEmail")
    public String getWelcomeEmail() {
        return welcomeEmail;
    }

    public void setWelcomeEmail(String welcomeEmail) {
        this.welcomeEmail = welcomeEmail;
    }

    private String receiptEmail;

    @JsonProperty("ReceiptEmail")
    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    private String isSmtp;

    @JsonProperty("IsSMTP")
    public String getIsSmtp() {
        return isSmtp;
    }

    public void setIsSmtp(String isSmtp) {
        this.isSmtp = isSmtp;
    }

    private String smtpHost;

    @JsonProperty("SMTPHost")
    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    private String smtpAuth;

    @JsonProperty("SMTPAuth")
    public String getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(String smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    private String smtpUsername;

    @JsonProperty("SMTPUsername")
    public String getSmtpUsername() {
        return smtpUsername;
    }

    public void setSmtpUsername(String smtpUsername) {
        this.smtpUsername = smtpUsername;
    }

    private String smtpPassword;

    @JsonProperty("SMTPPassword")
    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    private String smtpPasswordIv;

    @JsonProperty("SMTPPasswordIV")
    public String getSmtpPasswordIv() {
        return smtpPasswordIv;
    }

    public void setSmtpPasswordIv(String smtpPasswordIv) {
        this.smtpPasswordIv = smtpPasswordIv;
    }

    private String smtpSecure;

    @JsonProperty("SMTPSecure")
    public String getSmtpSecure() {
        return smtpSecure;
    }

    public void setSmtpSecure(String smtpSecure) {
        this.smtpSecure = smtpSecure;
    }

    private String formPrivateId;

    @JsonProperty("FormPrivateId")
    public String getFormPrivateId() {
        return formPrivateId;
    }

    public void setFormPrivateId(String formPrivateId) {
        this.formPrivateId = formPrivateId;
    }

    private String formPublicId;

    @JsonProperty("FormPublicId")
    public String getFormPublicId() {
        return formPublicId;
    }

    public void setFormPublicId(String formPublicId) {
        this.formPublicId = formPublicId;
    }

    private String status;

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String plan;

    @JsonProperty("Plan")
    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    private String provider;

    @JsonProperty("Provider")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    private String subscriptionId;

    @JsonProperty("SubscriptionId")
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    private String customerId;

    @JsonProperty("CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private String canDeploy;

    @JsonProperty("CanDeploy")
    public String getCanDeploy() {
        return canDeploy;
    }

    public void setCanDeploy(String canDeploy) {
        this.canDeploy = canDeploy;
    }

    private String userLimit;

    @JsonProperty("UserLimit")
    public String getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(String userLimit) {
        this.userLimit = userLimit;
    }

    private String fileLimit;

    @JsonProperty("FileLimit")
    public String getFileLimit() {
        return fileLimit;
    }

    public void setFileLimit(String fileLimit) {
        this.fileLimit = fileLimit;
    }

    private Timestamp lastLogin;

    @JsonProperty("LastLogin")
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    private Timestamp created;

    @JsonProperty("Created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    private String imagesUrl;

    @JsonProperty("ImagesUrl")
    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    private String offset;

    @JsonProperty("Offset")
    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    @JsonProperty("AltLogoUrl")
    public String getAltLogoUrl() {
        return altLogoUrl;
    }

    public void setAltLogoUrl(String altLogoUrl) {
        this.altLogoUrl = altLogoUrl;
    }

    @JsonProperty("PayPalLogoUrl")
    public String getPayPalLogoUrl() {
        return payPalLogoUrl;
    }

    public void setPayPalLogoUrl(String payPalLogoUrl) {
        this.payPalLogoUrl = payPalLogoUrl;
    }

    @JsonProperty("ShowSearch")
    public String getShowSearch() {
        return showSearch;
    }

    public void setShowSearch(String showSearch) {
        this.showSearch = showSearch;
    }

    @JsonProperty("EmbeddedCodeHead")
    public String getEmbeddedCodeHead() {
        return embeddedCodeHead;
    }

    public void setEmbeddedCodeHead(String embeddedCodeHead) {
        this.embeddedCodeHead = embeddedCodeHead;
    }

    @JsonProperty("EmbeddedCodeBottom")
    public String getEmbeddedCodeBottom() {
        return embeddedCodeBottom;
    }

    public void setEmbeddedCodeBottom(String embeddedCodeBottom) {
        this.embeddedCodeBottom = embeddedCodeBottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SitesDto)) return false;

        SitesDto sitesDto = (SitesDto) o;

        if (id != null ? !id.equals(sitesDto.id) : sitesDto.id != null) return false;
        if (altLogoUrl != null ? !altLogoUrl.equals(sitesDto.altLogoUrl) : sitesDto.altLogoUrl != null) return false;
        if (payPalLogoUrl != null ? !payPalLogoUrl.equals(sitesDto.payPalLogoUrl) : sitesDto.payPalLogoUrl != null) return false;
        if (showSearch != null ? !showSearch.equals(sitesDto.showSearch) : sitesDto.showSearch != null) return false;
        if (embeddedCodeHead != null ? !embeddedCodeHead.equals(sitesDto.embeddedCodeHead) : sitesDto.embeddedCodeHead != null) return false;
        if (embeddedCodeBottom != null ? !embeddedCodeBottom.equals(sitesDto.embeddedCodeBottom) : sitesDto.embeddedCodeBottom != null) return false;
        if (friendlyId != null ? !friendlyId.equals(sitesDto.friendlyId) : sitesDto.friendlyId != null) return false;
        if (domain != null ? !domain.equals(sitesDto.domain) : sitesDto.domain != null) return false;
        if (bucket != null ? !bucket.equals(sitesDto.bucket) : sitesDto.bucket != null) return false;
        if (name != null ? !name.equals(sitesDto.name) : sitesDto.name != null) return false;
        if (logoUrl != null ? !logoUrl.equals(sitesDto.logoUrl) : sitesDto.logoUrl != null) return false;
        if (iconUrl != null ? !iconUrl.equals(sitesDto.iconUrl) : sitesDto.iconUrl != null) return false;
        if (iconBg != null ? !iconBg.equals(sitesDto.iconBg) : sitesDto.iconBg != null) return false;
        if (theme != null ? !theme.equals(sitesDto.theme) : sitesDto.theme != null) return false;
        if (primaryEmail != null ? !primaryEmail.equals(sitesDto.primaryEmail) : sitesDto.primaryEmail != null) return false;
        if (timeZone != null ? !timeZone.equals(sitesDto.timeZone) : sitesDto.timeZone != null) return false;
        if (language != null ? !language.equals(sitesDto.language) : sitesDto.language != null) return false;
        if (direction != null ? !direction.equals(sitesDto.direction) : sitesDto.direction != null) return false;
        if (showCart != null ? !showCart.equals(sitesDto.showCart) : sitesDto.showCart != null) return false;
        if (showSettings != null ? !showSettings.equals(sitesDto.showSettings) : sitesDto.showSettings != null) return false;
        if (showLanguages != null ? !showLanguages.equals(sitesDto.showLanguages) : sitesDto.showLanguages != null) return false;
        if (showLogin != null ? !showLogin.equals(sitesDto.showLogin) : sitesDto.showLogin != null) return false;
        if (urlMode != null ? !urlMode.equals(sitesDto.urlMode) : sitesDto.urlMode != null) return false;
        if (currency != null ? !currency.equals(sitesDto.currency) : sitesDto.currency != null) return false;
        if (weightUnit != null ? !weightUnit.equals(sitesDto.weightUnit) : sitesDto.weightUnit != null) return false;
        if (shippingCalculation != null ? !shippingCalculation.equals(sitesDto.shippingCalculation) : sitesDto.shippingCalculation != null) return false;
        if (shippingRate != null ? !shippingRate.equals(sitesDto.shippingRate) : sitesDto.shippingRate != null) return false;
        if (shippingTiers != null ? !shippingTiers.equals(sitesDto.shippingTiers) : sitesDto.shippingTiers != null) return false;
        if (taxRate != null ? !taxRate.equals(sitesDto.taxRate) : sitesDto.taxRate != null) return false;
        if (payPalId != null ? !payPalId.equals(sitesDto.payPalId) : sitesDto.payPalId != null) return false;
        if (payPalUseSandbox != null ? !payPalUseSandbox.equals(sitesDto.payPalUseSandbox) : sitesDto.payPalUseSandbox != null) return false;
        if (welcomeEmail != null ? !welcomeEmail.equals(sitesDto.welcomeEmail) : sitesDto.welcomeEmail != null) return false;
        if (receiptEmail != null ? !receiptEmail.equals(sitesDto.receiptEmail) : sitesDto.receiptEmail != null) return false;
        if (isSmtp != null ? !isSmtp.equals(sitesDto.isSmtp) : sitesDto.isSmtp != null) return false;
        if (smtpHost != null ? !smtpHost.equals(sitesDto.smtpHost) : sitesDto.smtpHost != null) return false;
        if (smtpAuth != null ? !smtpAuth.equals(sitesDto.smtpAuth) : sitesDto.smtpAuth != null) return false;
        if (smtpUsername != null ? !smtpUsername.equals(sitesDto.smtpUsername) : sitesDto.smtpUsername != null) return false;
        if (smtpPassword != null ? !smtpPassword.equals(sitesDto.smtpPassword) : sitesDto.smtpPassword != null) return false;
        if (smtpPasswordIv != null ? !smtpPasswordIv.equals(sitesDto.smtpPasswordIv) : sitesDto.smtpPasswordIv != null) return false;
        if (smtpSecure != null ? !smtpSecure.equals(sitesDto.smtpSecure) : sitesDto.smtpSecure != null) return false;
        if (formPrivateId != null ? !formPrivateId.equals(sitesDto.formPrivateId) : sitesDto.formPrivateId != null) return false;
        if (formPublicId != null ? !formPublicId.equals(sitesDto.formPublicId) : sitesDto.formPublicId != null) return false;
        if (status != null ? !status.equals(sitesDto.status) : sitesDto.status != null) return false;
        if (plan != null ? !plan.equals(sitesDto.plan) : sitesDto.plan != null) return false;
        if (provider != null ? !provider.equals(sitesDto.provider) : sitesDto.provider != null) return false;
        if (subscriptionId != null ? !subscriptionId.equals(sitesDto.subscriptionId) : sitesDto.subscriptionId != null) return false;
        if (customerId != null ? !customerId.equals(sitesDto.customerId) : sitesDto.customerId != null) return false;
        if (canDeploy != null ? !canDeploy.equals(sitesDto.canDeploy) : sitesDto.canDeploy != null) return false;
        if (userLimit != null ? !userLimit.equals(sitesDto.userLimit) : sitesDto.userLimit != null) return false;
        if (fileLimit != null ? !fileLimit.equals(sitesDto.fileLimit) : sitesDto.fileLimit != null) return false;
        if (lastLogin != null ? !lastLogin.equals(sitesDto.lastLogin) : sitesDto.lastLogin != null) return false;
        if (created != null ? !created.equals(sitesDto.created) : sitesDto.created != null) return false;
        if (imagesUrl != null ? !imagesUrl.equals(sitesDto.imagesUrl) : sitesDto.imagesUrl != null) return false;
        return !(offset != null ? !offset.equals(sitesDto.offset) : sitesDto.offset != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (altLogoUrl != null ? altLogoUrl.hashCode() : 0);
        result = 31 * result + (payPalLogoUrl != null ? payPalLogoUrl.hashCode() : 0);
        result = 31 * result + (showSearch != null ? showSearch.hashCode() : 0);
        result = 31 * result + (embeddedCodeHead != null ? embeddedCodeHead.hashCode() : 0);
        result = 31 * result + (embeddedCodeBottom != null ? embeddedCodeBottom.hashCode() : 0);
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
        result = 31 * result + (showCart != null ? showCart.hashCode() : 0);
        result = 31 * result + (showSettings != null ? showSettings.hashCode() : 0);
        result = 31 * result + (showLanguages != null ? showLanguages.hashCode() : 0);
        result = 31 * result + (showLogin != null ? showLogin.hashCode() : 0);
        result = 31 * result + (urlMode != null ? urlMode.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (weightUnit != null ? weightUnit.hashCode() : 0);
        result = 31 * result + (shippingCalculation != null ? shippingCalculation.hashCode() : 0);
        result = 31 * result + (shippingRate != null ? shippingRate.hashCode() : 0);
        result = 31 * result + (shippingTiers != null ? shippingTiers.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (payPalId != null ? payPalId.hashCode() : 0);
        result = 31 * result + (payPalUseSandbox != null ? payPalUseSandbox.hashCode() : 0);
        result = 31 * result + (welcomeEmail != null ? welcomeEmail.hashCode() : 0);
        result = 31 * result + (receiptEmail != null ? receiptEmail.hashCode() : 0);
        result = 31 * result + (isSmtp != null ? isSmtp.hashCode() : 0);
        result = 31 * result + (smtpHost != null ? smtpHost.hashCode() : 0);
        result = 31 * result + (smtpAuth != null ? smtpAuth.hashCode() : 0);
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
        result = 31 * result + (canDeploy != null ? canDeploy.hashCode() : 0);
        result = 31 * result + (userLimit != null ? userLimit.hashCode() : 0);
        result = 31 * result + (fileLimit != null ? fileLimit.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (imagesUrl != null ? imagesUrl.hashCode() : 0);
        result = 31 * result + (offset != null ? offset.hashCode() : 0);
        return result;
    }
}
