package inbusiness.space.webapp.domain;

//import org.springframework.data.elasticsearch.annotations.Document;

import java.sql.Timestamp;

/**
 * Created by fer on 05/07/2015.
 */
//@Entity
//@Table(name = "Users")
//@Document(indexName="respond")
public class Users {
    //@Id
    //@Column(name = "UserID", nullable = false, insertable = true, updatable = true, length = 50)
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

    public String getId() {
        return id;
    }

    public void setId(String userId) {
        this.id = userId;
    }

    //@Basic
    //@Column(name = "Email", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@Basic
    //@Column(name = "Password", nullable = false, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //@Basic
    //@Column(name = "FirstName", nullable = false, insertable = true, updatable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@Basic
    //@Column(name = "LastName", nullable = false, insertable = true, updatable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Basic
    //@Column(name = "PhotoUrl", nullable = true, insertable = true, updatable = true, length = 512)
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    //@Basic
    //@Column(name = "Role", nullable = false, insertable = true, updatable = true, length = 16)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //@Basic
    //@Column(name = "Language", nullable = false, insertable = true, updatable = true, length = 10)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //@Basic
    //@Column(name = "Token", nullable = true, insertable = true, updatable = true, length = 255)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    //@Basic
    //@Column(name = "IsActive", nullable = false, insertable = true, updatable = true)
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    //@Basic
    //@Column(name = "SiteAdmin", nullable = false, insertable = true, updatable = true)
    public int getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(int siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    //@Basic
    //@Column(name = "Created", nullable = false, insertable = true, updatable = true)
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

        Users users = (Users) o;

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
