package longlevan2k.com.example.manageshopclothing.model.object_request;

public class UserAddingInformation {
    private String fullname;
    private String password;
    private String username;
    private String role;

    public UserAddingInformation(String fullname, String password, String username, String role) {
        this.fullname = fullname;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserAddingInformation{" +
                "fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
