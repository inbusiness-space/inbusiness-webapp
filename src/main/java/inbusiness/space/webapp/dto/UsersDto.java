package inbusiness.space.webapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
public class UsersDto {
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String photoUrl;
    private String role;
    private String language;
    private String token;
    private int isActive;
    private int siteAdmin;
    private Timestamp created;

    @JsonProperty("UserId")
    public String getId() {
        return id;
    }

    public void setId(String userId) {
        this.id = userId;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("PhotoUrl")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @JsonProperty("Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("Token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("IsActive")
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("SiteAdmin")
    public int getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(int siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @JsonProperty("Created")
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

        UsersDto users = (UsersDto) o;

        if (isActive != users.isActive) return false;
        if (siteAdmin != users.siteAdmin) return false;
        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (photoUrl != null ? !photoUrl.equals(users.photoUrl) : users.photoUrl != null) return false;
        if (role != null ? !role.equals(users.role) : users.role != null) return false;
        if (language != null ? !language.equals(users.language) : users.language != null) return false;
        if (token != null ? !token.equals(users.token) : users.token != null) return false;
        if (created != null ? !created.equals(users.created) : users.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + isActive;
        result = 31 * result + siteAdmin;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }
}
