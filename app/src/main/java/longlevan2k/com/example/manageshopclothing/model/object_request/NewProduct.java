package longlevan2k.com.example.manageshopclothing.model.object_request;

public class NewProduct {

    private String productname;
    private String category;
    private String size;
    private String price;
    private String suppliername;
    private int quantity;
    private int warehouse;
    private String originalprice;

    public NewProduct(String productname, String category, String size, String price, String suppliername,  int warehouse, String originalprice) {
        this.productname = productname;
        this.category = category;
        this.size = size;
        this.price = price;
        this.suppliername = suppliername;
        this.quantity = 0;
        this.warehouse = warehouse;
        this.originalprice = originalprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }
}
