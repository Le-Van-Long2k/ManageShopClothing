package longlevan2k.com.example.manageshopclothing.main;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.model.entity.Item;
import longlevan2k.com.example.manageshopclothing.model.object_request.ItemInfo;

public interface CartItemListener {
    void onCartItemChange(List<ItemInfo> itemInfos);
}
