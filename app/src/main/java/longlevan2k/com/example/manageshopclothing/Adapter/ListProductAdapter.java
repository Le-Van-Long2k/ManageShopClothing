package longlevan2k.com.example.manageshopclothing.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.main.ListProductListener;
import longlevan2k.com.example.manageshopclothing.model.entity.Product;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>{

    private Context context;
    private List<Product> listProducts;
    ListProductListener listProductListener;

    final List<Product> listProductSearch = new ArrayList<>(); // list product sau khi search

    public ListProductAdapter(Context context, List<Product> listProducts, ListProductListener listProductListener) {
        this.context = context;
        this.listProducts = listProducts;
        this.listProductListener = listProductListener;
    }

    public ListProductAdapter(Context context, List<Product> listProducts){
        this.context = context;
        this.listProducts = listProducts;
    }

    public void setData(List<Product> list){
        this.listProducts = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product = listProducts.get(holder.getLayoutPosition());
        if (product == null){
            return;
        }

        holder.tv_productNameList.setText(product.getProductName());
        holder.tv_productSizeList.setText("Size: " + product.getSize());
        holder.tv_productPriceList.setText("Giá: "+ product.getPrice() + "VND");
        holder.tv_productwarehouse.setText("Hiện có: "+product.getWarehouse());

        if (listProducts !=null && listProducts.size()>0){
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.checkBox.isChecked()){
                        listProductSearch.add(listProducts.get(holder.getLayoutPosition()));
                    }else {
                        listProductSearch.remove(listProducts.get(holder.getLayoutPosition()));
                    }
                    listProductListener.onListProductChange(listProductSearch);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(listProducts != null){
            return listProducts.size();
        }
        return 0;
    }


    // ViewHolder Class
    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_productList;
        private TextView tv_productNameList, tv_productwarehouse, tv_productSizeList, tv_productPriceList;
        private CheckBox checkBox;
        private boolean isChecked;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            img_productList = itemView.findViewById(R.id.img_productList);
            tv_productNameList = itemView.findViewById(R.id.tv_productNameList);
            tv_productwarehouse = itemView.findViewById(R.id.tv_productwarehouse);
            tv_productSizeList = itemView.findViewById(R.id.tv_productSizeList);
            tv_productPriceList = itemView.findViewById(R.id.tv_productPriceList);
            checkBox = itemView.findViewById(R.id.checkbox_product);
        }
    }

}
