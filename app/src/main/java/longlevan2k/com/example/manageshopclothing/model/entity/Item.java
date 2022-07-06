package longlevan2k.com.example.manageshopclothing.model.entity;

public class Item {
    private int id;
    private Product product;
    private int quantity;

    public Item(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                 quantity +
                '}' + "\n";
    }
//    public String toString() {
//        return "Item{" +
//                "id=" + id +
//                ", product=" + product.toString() +
//                ", quantity=" + quantity +
//                '}';
//    }
}
