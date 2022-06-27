package longlevan2k.com.example.manageshopclothing.model.object_request;

public class NewProduct {

    private String productname;
    private String category;
    private char size;
    private String price;
    private String suppliername;

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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public NewProduct(String productname, String category, char size, String price, String suppliername) {
        this.productname = productname;
        this.category = category;
        this.size = size;
        this.price = price;
        this.suppliername = suppliername;
    }
}
