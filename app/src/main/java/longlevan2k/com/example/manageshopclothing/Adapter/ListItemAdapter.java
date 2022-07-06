package longlevan2k.com.example.manageshopclothing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travijuu.numberpicker.library.NumberPicker;

import java.util.List;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>{

    private Context context;
    private List<Item> listItems;

    public ListItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Item> list){
        this.listItems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = listItems.get(position);
        if (item == null){
            return;
        }

        holder.tv_itemName.setText(item.getProduct().getProductName());
        holder.tv_itemSize.setText("Size: " + item.getProduct().getSize());
        holder.tv_itemQuantify.setText("Hiện có: " + item.getQuantity());
        holder.tv_itemPrice.setText("Giá: " + item.getProduct().getPrice() + " VND");
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
        private TextView tv_itemName, tv_itemQuantify, tv_itemSize, tv_itemPrice;
        

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            img_item = itemView.findViewById(R.id.img_itemList);
            tv_itemName = itemView.findViewById(R.id.tv_itemNameList);
            tv_itemQuantify = itemView.findViewById(R.id.tv_itemQuantifyList);
            tv_itemSize = itemView.findViewById(R.id.tv_itemSizeList);
            tv_itemPrice = itemView.findViewById(R.id.tv_itemPriceList);

        }
    }




}
