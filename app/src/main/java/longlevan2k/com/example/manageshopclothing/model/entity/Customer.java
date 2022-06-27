package longlevan2k.com.example.manageshopclothing.model.entity;


public class Customer {
    private int id;
    private String fullName;
    private String address;
    private String phone;
    private boolean status;

    public Customer(int id, String fullName, String address, String phone, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
