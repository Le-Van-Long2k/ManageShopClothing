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
import longlevan2k.com.example.manageshopclothing.Adapter.ListItemAdapter;
import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;
import longlevan2k.com.example.manageshopclothing.model.entity.Product;
import longlevan2k.com.example.manageshopclothing.model.entity.Supplier;

public class AddBills extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;
    Toolbar toolbar;
    TextView tv_date;
    Button btn_addListItem;


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

        //*********************************************************/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        cartItemAdapter.setData(getListItem());
        recyclerView.setAdapter(cartItemAdapter);

        //****************************************************************/
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuAddBill:
                        Intent intent = new Intent(AddBills.this, AddBills.class);
                        startActivity(intent);
                        return true;
                    case R.id.menuSaveBill:
                        Toast.makeText(AddBills.this, "Save Bill", Toast.LENGTH_SHORT).show();
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
                openDialogListItem(Gravity.CENTER);

            }
        });
    }


    //*************************** Dialog List Item   ************************/
    private void openDialogListItem(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_item);

        Window window = dialog.getWindow();

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttibutes = window.getAttributes();
        windowAttibutes.gravity = gravity;
        window.setAttributes(windowAttibutes);

        if (Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }

        Button btn_cancelListItem = dialog.findViewById(R.id.btn_cancelListItem);
        Button btn_doneListItem = dialog.findViewById(R.id.btn_doneListItem);
        Button btn_searchItem = dialog.findViewById(R.id.btn_searchItem);

        btn_searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView recyclerView_listItem = dialog.findViewById(R.id.recycler_listItem);
                TextInputEditText edt_searchNameItem = dialog.findViewById(R.id.edt_searchNameItem);

                LinearLayoutManager linearLayoutManagerDialog = new LinearLayoutManager(AddBills.this, RecyclerView.VERTICAL, false);
                recyclerView_listItem.setLayoutManager(linearLayoutManagerDialog);

                ListItemAdapter cartItemAdapter1 = new ListItemAdapter(AddBills.this);
                cartItemAdapter1.setData(getListItem());
                recyclerView_listItem.setAdapter(cartItemAdapter1);
            }
        });

        btn_cancelListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_doneListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddBills.this, "Add success", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }



    private void saveBill() {

    }

    private List<Item> getListItem() {
        Supplier supplier = new Supplier(1, "Nhà cung cấp R", "HN",true);
        Product product = new Product(1, "Quần âu","Quần", 'L', "90000", supplier, true);
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, product, 5));
        list.add(new Item(2, product, 5));
        list.add(new Item(3, product, 5));
        list.add(new Item(4, product, 5));
        list.add(new Item(5, product, 5));
        list.add(new Item(6, product, 5));
        list.add(new Item(7, product, 5));
        list.add(new Item(8, product, 5));

        //Toast.makeText(this, list.get(1).toString(), Toast.LENGTH_LONG).show();

        return list;
    }
}