package model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
    private int id;
    private String displayName;
    private String userName;
    private String password;
    private String role;

    public User() {
    }

    public User(int id, String displayName, String userName, String password, String role) {
        this.id = id;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setStrRole(String strRole) {
        this.role = role;
    }

    @Override
    public String toString() {
        return
                " , id : " + id
                + " , Display name : " + displayName
                + " , UserName : " + userName
                + " , Role : " + role;


    }
}
