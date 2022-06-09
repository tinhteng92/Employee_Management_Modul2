package model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private String displayName;
    private String userName;
    private String password;
    private String role;

    public User() {
    }

    public User(String displayName, String userName, String password, String role) {
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getrole() {
        return role;
    }

    public void setStrRole(String strRole) {
        this.role = role;
    }
}
