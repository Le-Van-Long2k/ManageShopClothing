package longlevan2k.com.example.manageshopclothing.model.entity;

public class Supplier {
    private int id;
    private String nameSupplier;
    private String address;
    private boolean status;

    public Supplier(int id, String nameSupplier, String address, boolean status) {
        this.id = id;
        this.nameSupplier = nameSupplier;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", nameSupplier='" + nameSupplier + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
