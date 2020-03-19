package tk.springmvc.model;

public class WebUser {
    private String username;
    private String password;
    private String usergroup;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    @Override
    public String toString() {
        return "WebUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usergroup='" + usergroup + '\'' +
                '}';
    }
}
