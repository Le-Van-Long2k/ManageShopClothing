package longlevan2k.com.example.manageshopclothing.model.entity;

public class Product {
    private int id;
    private String productName;
    private String category;
    private String size;
    private String price;

    private Supplier supplier;
    private boolean status;
    private int warehouse;
    private String originalPrice;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Product(int id, String productName, String category, String size, String price, Supplier supplier, boolean status, int warehouse, String originalPrice) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.size = size;
        this.price = price;
        this.supplier = supplier;
        this.status = status;
        this.warehouse = warehouse;
        this.originalPrice = originalPrice;
    }

    public Product(){};

    @Override
    public String toString() {
        return "Product{" +
                 productName  +
                "}\n";
    }
}
