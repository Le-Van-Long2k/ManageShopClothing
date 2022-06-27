package longlevan2k.com.example.manageshopclothing.model.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private boolean status;

    public User(int id, String fullName, String username, String password, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
