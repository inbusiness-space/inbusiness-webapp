package inbusiness.space.webapp.domain;

/**
 * Created by fer on 08/12/2015.
 */
public class UserRole {
    private String login;
    private String role;

    public UserRole() {
        super();
    }

    public UserRole(String login, String role) {
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
