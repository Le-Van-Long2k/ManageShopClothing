package longlevan2k.com.example.manageshopclothing.main;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.model.entity.Product;

public interface ListProductListener {
    void onListProductChange(List<Product> productList);
}
