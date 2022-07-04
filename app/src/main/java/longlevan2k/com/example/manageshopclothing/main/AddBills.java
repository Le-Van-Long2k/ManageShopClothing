package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import longlevan2k.com.example.manageshopclothing.Adapter.CartItemAdapter;
import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.model.entity.Item;
import longlevan2k.com.example.manageshopclothing.model.entity.Product;
import longlevan2k.com.example.manageshopclothing.model.entity.Supplier;

public class AddBills extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;

    TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bills);

        recyclerView = findViewById(R.id.recycler_cartItem);
        cartItemAdapter = new CartItemAdapter(this);
        tv_date = findViewById(R.id.tv_date);


        // set date = current date
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        tv_date.setText(strDate);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        cartItemAdapter.setData(getListItem());
        recyclerView.setAdapter(cartItemAdapter);
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