package longlevan2k.com.example.manageshopclothing.model.object_request;

public class NewItem {
    private String nameOfProduct;
    private int quantity;

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public NewItem(String nameOfProduct, int quantity) {
        this.nameOfProduct = nameOfProduct;
        this.quantity = quantity;
    }
}
