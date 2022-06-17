package longlevan2k.com.example.manageshopclothing;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivityManager extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView imgAddProduct, imgWarehouse, imgAddCustomer, imgAddBills, imgBills, imgCustomer, imgProduct, imgProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manager);

        /*-------------- Hooks -----------------------*/
        drawerLayout = findViewById(R.id.drawer_layoutManager);
        navigationView = findViewById(R.id.nav_viewManager);
        toolbar = findViewById(R.id.toolbarManager);
        imgAddProduct = (ImageView) findViewById(R.id.imageViewAddProductManager);
        imgWarehouse = (ImageView) findViewById(R.id.imageViewWarehouseManager);
        imgAddCustomer = (ImageView) findViewById(R.id.imageViewAddCustomerManager);
        imgBills = (ImageView) findViewById(R.id.imageViewBillsManager);
        imgAddBills = (ImageView) findViewById(R.id.imageViewAddBillsManager);
        imgCustomer = (ImageView) findViewById(R.id.imageViewCustomerManager);
        imgProduct = (ImageView) findViewById(R.id.imageViewProductManager);
        imgProvider = (ImageView) findViewById(R.id.imageViewProviderManager);

        /*----------------- Tool bar -----------------*/
        setSupportActionBar(toolbar);

        /*------------------ Navigation drawer menu -------*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        imgAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, AddProduct.class);
                startActivity(intent);
            }
        });

        imgWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, Warehouse.class);
                startActivity(intent);
            }
        });

        imgAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, AddCustomer.class);
                startActivity(intent);
            }
        });

        imgAddBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, AddBills.class);
                startActivity(intent);
            }
        });

        imgBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, Bills.class);
                startActivity(intent);
            }
        });

        imgCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, Customer.class);
                startActivity(intent);
            }
        });

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, Product.class);
                startActivity(intent);
            }
        });

        imgProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityManager.this, Provider.class);
                startActivity(intent);
            }
        });
    }
}