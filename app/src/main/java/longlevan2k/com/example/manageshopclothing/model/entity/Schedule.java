package longlevan2k.com.example.manageshopclothing.model.entity;

public class Schedule {
    private int id;
    private String date;
    private char shift;
    private User user;

    public Schedule(int id, String date, char shift, User user) {
        this.id = id;
        this.date = date;
        this.shift = shift;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", shift=" + shift +
                '}';
    }
}
