package longlevan2k.com.example.manageshopclothing.model.object_request;

import longlevan2k.com.example.manageshopclothing.model.entity.Product;

public class ItemInfo {

    private String productname;
    private String size;
    private int quantity;

    public ItemInfo(){};

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemInfo(String productname, String size, int quantity) {
        this.productname = productname;
        this.size = size;
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        this.quantity ++;
    }

    public void decreaseQuantity(){
        this.quantity --;
        if (this.quantity <=0) this.quantity = 0;
    }


    public void converterProductToItemInfo(Product product){
        this.productname = product.getProductName();
        this.size = product.getSize();
        this.quantity = 1;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                productname + '\'' +
                 size + '\'' +
                 quantity +
                "}\n";
    }
}
