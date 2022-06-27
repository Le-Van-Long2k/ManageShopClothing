package longlevan2k.com.example.manageshopclothing.model.object_request;

public class ScheduleInformation {
    private String username;
    private String date;
    private char shift;

    public ScheduleInformation(String username, String date, char shift) {
        this.username = username;
        this.date = date;
        this.shift = shift;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public char getShift() {
        return shift;
    }

    public void setShift(char shift) {
        this.shift = shift;
    }
}
