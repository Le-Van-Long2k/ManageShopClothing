package longlevan2k.com.example.manageshopclothing.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.main.CartItemListener;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;
import longlevan2k.com.example.manageshopclothing.model.object_request.ItemInfo;

//  Item Adapter san pham trong gio hang va can them so luong san pham
public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ItemViewHolder>{

    private Context context;
    private List<ItemInfo> listItems;
    CartItemListener cartItemListener;

    private List<ItemInfo> cartItemsAdd = new ArrayList<>(); // list item sau khi chon so luong san pham

    public CartItemAdapter(Context context, List<ItemInfo> listItems, CartItemListener cartItemListener) {
        this.context = context;
        this.listItems = listItems;
        this.cartItemListener = cartItemListener;
        notifyDataSetChanged();
    }

    public CartItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ItemInfo> list){
        this.listItems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemInfo item = listItems.get(position);
        if (item == null){
            return;
        }

        holder.tv_itemName.setText(item.getProductname());
        holder.tv_itemSize.setText("Size: "+ item.getSize());

        if (listItems != null &&listItems.size()>0){
            holder.btn_increaseItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.increaseQuantity();
                    holder.tv_itemQuantify.setText(""+item.getQuantity());
                    cartItemsAdd.remove(listItems.get(position));
                    cartItemsAdd.add(listItems.get(position));

                    cartItemListener.onCartItemChange(cartItemsAdd);
                }
            });

            holder.btn_decreaseItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.decreaseQuantity();
                    holder.tv_itemQuantify.setText(""+item.getQuantity());
                    cartItemsAdd.remove(listItems.get(position));
                    cartItemsAdd.add(listItems.get(position));

                    cartItemListener.onCartItemChange(cartItemsAdd);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if (listItems != null){
            return listItems.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_item;
        private TextView tv_itemName, tv_itemQuantify, tv_itemSize;
        Button btn_decreaseItem,btn_increaseItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            img_item = itemView.findViewById(R.id.img_item);
            tv_itemName = itemView.findViewById(R.id.tv_itemName);
            tv_itemSize = itemView.findViewById(R.id.tv_itemSize);
            tv_itemQuantify = itemView.findViewById(R.id.tv_quantifyCartItem);
            btn_decreaseItem = itemView.findViewById(R.id.btn_decreaseItem);
            btn_increaseItem = itemView.findViewById(R.id.btn_increaseItem);


        }
    }

}
