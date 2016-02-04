package inbusiness.space.webapp.dto;

/**
 * Created by fer on 06/07/2015.
 */
public class StartSite {
    private String friendlyId;
    private String name;
    private String email;
    private String password;
    private String passcode;
    private String timeZone;
    private String language;
    private String userLanguage;
    private String theme;
    private String firstName;
    private String lastName;

    public StartSite() {
        super();
    }

    public StartSite(String friendlyId, String name, String email, String password, String passcode, String timeZone, String language, String userLanguage, String theme, String firstName, String lastName) {
        this.friendlyId = friendlyId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.passcode = passcode;
        this.timeZone = timeZone;
        this.language = language;
        this.userLanguage = userLanguage;
        this.theme = theme;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFriendlyId() {
        return friendlyId;
    }

    public void setFriendlyId(String friendlyId) {
        this.friendlyId = friendlyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
