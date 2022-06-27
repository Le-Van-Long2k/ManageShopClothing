package longlevan2k.com.example.manageshopclothing.model.object_request;

public class EditInformation {
    private String newPassword;
    private LoginInformation loginInformation;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public LoginInformation getLoginInformation() {
        return loginInformation;
    }

    public void setLoginInformation(LoginInformation loginInformation) {
        this.loginInformation = loginInformation;
    }

    public EditInformation(String newPassword, LoginInformation loginInformation) {
        this.newPassword = newPassword;
        this.loginInformation = loginInformation;
    }
}
