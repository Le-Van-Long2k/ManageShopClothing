package longlevan2k.com.example.manageshopclothing.main;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.model.entity.Item;

public interface CartItemListener {
    void onCartItemChange(List<Item> itemList);
}
