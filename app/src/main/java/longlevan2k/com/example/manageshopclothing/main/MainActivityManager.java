package longlevan2k.com.example.manageshopclothing.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.model.entity.User;

public class MainActivityManager extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView imgAddProduct, imgWarehouse, imgAddCustomer, imgAddBills, imgBills, imgCustomer, imgProduct, imgProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_manager);

        /*-----------receive user from login ----------*/
        Bundle bundleReceive = getIntent().getExtras();
        if( bundleReceive != null){
            User user = (User) bundleReceive.get("object_user");
        }

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
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_Turnover:
                        Intent intent = new Intent(MainActivityManager.this, Turnover.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_EmployeeManager:
                        Intent intent1 = new Intent(MainActivityManager.this, EmployeeManager.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_ManagerAccount:
                        Intent intent2 = new Intent(MainActivityManager.this, ManagerAccount.class);
                        startActivity(intent2);
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        navigationView.setCheckedItem(R.id.nav_home);

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