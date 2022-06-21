package longlevan2k.com.example.manageshopclothing.model;

public class UserAddingInformation {
    private String fullname;
    private String password;
    private String username;

   public UserAddingInformation(){
        this.fullname = "Le Van Long";
        this.password = "1234";
        this.username = "Long123";
    }

    public UserAddingInformation(String fullname, String password, String username) {
        this.fullname = fullname;
        this.password = password;
        this.username = username;
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
}
