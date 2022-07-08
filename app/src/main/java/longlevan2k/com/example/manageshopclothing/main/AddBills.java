package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.Adapter.CartItemAdapter;
import longlevan2k.com.example.manageshopclothing.Adapter.ListProductAdapter;
import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;
import longlevan2k.com.example.manageshopclothing.model.entity.Product;
import longlevan2k.com.example.manageshopclothing.model.object_request.ItemInfo;
import longlevan2k.com.example.manageshopclothing.model.object_request.ProductNameSearching;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBills extends AppCompatActivity implements CartItemListener, ListProductListener {

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;
    Toolbar toolbar;
    TextView tv_date;
    Button btn_addListItem;
    static List<ItemInfo> itemListSearch = new ArrayList<>();
    static List<Product> productListSearch = new ArrayList<>();
    static  List<ItemInfo> itemInfos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bills);

        //**************************************************************/
        recyclerView = findViewById(R.id.recycler_cartItem);
        cartItemAdapter = new CartItemAdapter(this);
        tv_date = findViewById(R.id.tv_date);
        toolbar = findViewById(R.id.toolbarAddBills);
        btn_addListItem = findViewById(R.id.btn_addListItem);


        // set date = current date
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        tv_date.setText(strDate);


        //****************************  toolbar ************************************/
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAddBill:

                        Intent intent = new Intent(AddBills.this, AddBills.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.menuSaveBill:
                       // Toast.makeText(AddBills.this, "Save Bill", Toast.LENGTH_SHORT).show();
                        saveBill();
                        return true;
                    default:
                        return false;
                }
            }
        });

        //*****************  add list item *************************************/
        btn_addListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productListSearch.clear();
                itemListSearch.clear();
                openDialogListItem(Gravity.CENTER);

            }
        });
    }


    //*************************** Dialog List Item   ************************/
    private void openDialogListItem(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_item);

        Window window = dialog.getWindow();

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttibutes = window.getAttributes();
        windowAttibutes.gravity = gravity;
        window.setAttributes(windowAttibutes);

        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        Button btn_cancelListItem = dialog.findViewById(R.id.btn_cancelListItem);
        Button btn_doneListItem = dialog.findViewById(R.id.btn_doneListItem);
        Button btn_searchItem = dialog.findViewById(R.id.btn_searchItem);
        RecyclerView recyclerView_listItem = dialog.findViewById(R.id.recycler_listItem);
        TextInputEditText edt_searchNameItem = dialog.findViewById(R.id.edt_searchNameItem);
        LinearLayoutManager linearLayoutManagerDialog = new LinearLayoutManager(AddBills.this, RecyclerView.VERTICAL, false);
        recyclerView_listItem.setLayoutManager(linearLayoutManagerDialog);

        // Search Item for nameItem
        btn_searchItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ProductNameSearching productNameSearching = new ProductNameSearching(edt_searchNameItem.getText().toString().trim());
                ListProductAdapter listProductAdapter = new ListProductAdapter(AddBills.this, getListProductSearch(productNameSearching), AddBills.this);

                recyclerView_listItem.setAdapter(listProductAdapter);

            }

        });

        // Cancel dialog
        btn_cancelListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // chuyen Item tu dialog sang AddBills
        btn_doneListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // convert Product -> ItemInfo
                for(int i = 0; i < productListSearch.size(); i++){
                    ItemInfo It = new ItemInfo();
                    It.converterProductToItemInfo(productListSearch.get(i));
                    Toast.makeText(AddBills.this, It.toString(), Toast.LENGTH_SHORT).show();
                    itemInfos.add(It);
                }

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddBills.this, RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);

                CartItemAdapter cartItemAdapter = new CartItemAdapter(AddBills.this, itemInfos, AddBills.this);
                cartItemAdapter.setData(itemInfos);
                recyclerView.setAdapter(cartItemAdapter);

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private List<Product> getListProductSearch(ProductNameSearching productNameSearching) {

        ApiService.apiServiceProductNameSearching.productNameSearching(productNameSearching).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()){
                    productListSearch = response.body();
                }else{
                    Toast.makeText(AddBills.this, "Không có sản phẩm này", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(AddBills.this, "Không có sản phẩm này", Toast.LENGTH_SHORT).show();
            }
        });

        return productListSearch;
    }


    private void saveBill() {
        Toast.makeText(this, itemListSearch.toString(), Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onCartItemChange(List<ItemInfo> itemList) {
        itemListSearch.clear();
        itemListSearch.addAll(itemList);
        Toast.makeText(this, itemList.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListProductChange(List<Product> productList) {
        Toast.makeText(this, productList.toString(), Toast.LENGTH_SHORT).show();
        productListSearch.clear();
        productListSearch.addAll(productList);
    }

    @Override
    protected void onStop() {
        super.onStop();
        productListSearch.clear();
        itemListSearch.clear();
        itemInfos.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        productListSearch.clear();

    }
}