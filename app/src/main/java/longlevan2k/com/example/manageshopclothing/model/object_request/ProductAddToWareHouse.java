package longlevan2k.com.example.manageshopclothing.model.object_request;

public class ProductAddToWareHouse {
    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductAddToWareHouse(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
