package longlevan2k.com.example.manageshopclothing.model.object_request;

public class SupplierAddingInformation {
    private String name;
    private String address;

    public SupplierAddingInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
