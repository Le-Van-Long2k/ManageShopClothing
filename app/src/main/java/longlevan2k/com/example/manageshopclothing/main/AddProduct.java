package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.Adapter.CartItemAdapter;
import longlevan2k.com.example.manageshopclothing.Adapter.ListProductAdapter;
import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.entity.Product;
import longlevan2k.com.example.manageshopclothing.model.object_request.ProductAddToWareHouse;
import longlevan2k.com.example.manageshopclothing.model.object_request.ProductNameSearching;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


// Them product tu kho len quay (them thuoc tinh quantify -> so luong dua len quay)
public class AddProduct extends AppCompatActivity implements ListProductListener {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMAERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    ImageView imageViewAddProduct;
    String currentPhotoPath;
    Toolbar toolbar;
    Button btn_searchProduct;
    TextInputEditText edt_quantity;
    static List<Product> productListSearch = new ArrayList<>();
    static Product product = new Product();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        imageViewAddProduct = findViewById(R.id.imageViewAddProduct);
        toolbar = findViewById(R.id.toolbarAddQuayHang);
        btn_searchProduct = findViewById(R.id.btn_searchProductQuay);
        edt_quantity = findViewById(R.id.edt_quantity);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuAddQuayHang:
                        Intent intent = new Intent(AddProduct.this, AddProduct.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.menuSaveQuayHang:
                        saveQuayHang();
                        return true;
                    default:
                        return false;
                }
            }
        });


        btn_searchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogListItem(Gravity.CENTER);
            }
        });

    }

    private void saveQuayHang() {
        ProductAddToWareHouse productAddToWareHouse = new ProductAddToWareHouse(
                productListSearch.get(0).getProductName(),
                Integer.parseInt(edt_quantity.getText().toString().trim())
        );

        ApiService.apiServiceAddWarehouse.addWarehouse(productAddToWareHouse).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals("Success")){
                        Toast.makeText(AddProduct.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(AddProduct.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(AddProduct.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

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

        // Search Item for nameItem
        btn_searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView recyclerView_listItem = dialog.findViewById(R.id.recycler_listItem);
                TextInputEditText edt_searchNameItem = dialog.findViewById(R.id.edt_searchNameItem);
                ProductNameSearching productNameSearching = new ProductNameSearching(edt_searchNameItem.getText().toString().trim());

                LinearLayoutManager linearLayoutManagerDialog = new LinearLayoutManager(AddProduct.this, RecyclerView.VERTICAL, false);
                recyclerView_listItem.setLayoutManager(linearLayoutManagerDialog);

                ListProductAdapter listProductAdapter = new ListProductAdapter(AddProduct.this, getListProductSearch(productNameSearching), AddProduct.this);
                listProductAdapter.setData(getListProductSearch(productNameSearching));
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
                    Toast.makeText(AddProduct.this, "Không có sản phẩm này", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(AddProduct.this, "Không có sản phẩm này", Toast.LENGTH_SHORT).show();
            }
        });

        return productListSearch;
    }

    @Override
    public void onListProductChange(List<Product> productList) {
        productListSearch.clear();
        productListSearch.addAll(productList);
        Toast.makeText(this, productList.get(0).toString(), Toast.LENGTH_SHORT).show();
    }
}


