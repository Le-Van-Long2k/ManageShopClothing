package longlevan2k.com.example.manageshopclothing.model.entity;

public class Product {
    private int id;
    private String productName;
    private String category;
    private char size;
    private String price;
    private Supplier supplier;
    private boolean status;

    public Product(int id, String productName, String category, char size, String price, Supplier supplier, boolean status) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.price = price;
        this.supplier = supplier;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", size=" + size +
                ", price='" + price + '\'' +
                ", supplier=" + supplier.toString() +
                ", status=" + status +
                '}';
    }
}
