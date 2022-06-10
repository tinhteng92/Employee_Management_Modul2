package modelAccount;

public class SignUp {
    private String displayName;
    private String username;
    private String password;
    private String role;

    public SignUp(String displayName, String username, String password, String role) {
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
