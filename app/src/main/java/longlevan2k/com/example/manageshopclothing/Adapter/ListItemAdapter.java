package longlevan2k.com.example.manageshopclothing.Adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.travijuu.numberpicker.library.NumberPicker;

import java.util.ArrayList;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.main.AddBills;
import longlevan2k.com.example.manageshopclothing.main.ListItemListener;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ItemViewHolder>{

    private Context context;
    private List<Item> listItems;
    ListItemListener listItemListener;

    private List<Item> listItemsSearch = new ArrayList<>(); // listItem sau khi click checkbox

    public ListItemAdapter(Context context, List<Item> listItems, ListItemListener listItemListener) {
        this.context = context;
        this.listItems = listItems;
        this.listItemListener = listItemListener;
    }




    public ListItemAdapter(Context context) {
        this.context = context;
    }

    public ListItemAdapter(Context context, List<Item> listItems){
        this.context = context;
        this.listItems = listItems;
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

        if (listItems!=null && listItems.size()>0){
            // holder.checkBox.setText(item.getQuantity());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.checkBox.isChecked()){
                        listItemsSearch.add(listItems.get(position));
                    }else{
                        listItemsSearch.remove(listItems.get(position));
                    }
                    listItemListener.onListItemChange(listItemsSearch);
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


    // 2 - ViewHolder class
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_item;
        private TextView tv_itemName, tv_itemQuantify, tv_itemSize, tv_itemPrice;
        private CheckBox checkBox;
        private boolean isChecked;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item = itemView.findViewById(R.id.img_itemList);
            tv_itemName = itemView.findViewById(R.id.tv_itemNameList);
            tv_itemQuantify = itemView.findViewById(R.id.tv_itemQuantifyList);
            tv_itemSize = itemView.findViewById(R.id.tv_itemSizeList);
            tv_itemPrice = itemView.findViewById(R.id.tv_itemPriceList);
            checkBox = itemView.findViewById(R.id.checkbox_item);

        }

        // Getting the selected items


        // Getting selected when checkbox clicked
//        public List<Item> getSelected(){
//            List<Item> selected = new ArrayList<>();
//            for (int i = 0; i < listItems.size(); i++){
//                if (checkBox.isChecked()){
//                    selected.add(listItems.get(i));
//                }
//            }
//            return selected;
//        }


    }









}
