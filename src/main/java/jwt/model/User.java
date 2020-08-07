package jwt.model;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private String audience;

    public User() {
    }

    public User(String username, String password, String audience) {
        this.username = username;
        this.password = password;
        this.audience = audience;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
