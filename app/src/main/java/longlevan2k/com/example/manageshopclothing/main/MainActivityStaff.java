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

public class MainActivityStaff extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView imgAddProduct, imgWarehouse, imgAddCustomer, imgAddBills, imgBills, imgCustomer, imgProduct, imgProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staff);

        /*-------------- Hooks -----------------------*/
        drawerLayout = findViewById(R.id.drawer_layoutStaff);
        navigationView = findViewById(R.id.nav_viewStaff);
        toolbar = findViewById(R.id.toolbarStaff);
        imgAddProduct = (ImageView) findViewById(R.id.imageViewAddProductStaff);
        imgWarehouse = (ImageView) findViewById(R.id.imageViewWarehouseStaff);
        imgAddCustomer = (ImageView) findViewById(R.id.imageViewAddCustomerStaff);
        imgBills = (ImageView) findViewById(R.id.imageViewBillsStaff);
        imgAddBills = (ImageView) findViewById(R.id.imageViewAddBillsStaff);
        imgCustomer = (ImageView) findViewById(R.id.imageViewCustomerStaff);
        imgProduct = (ImageView) findViewById(R.id.imageViewProductStaff);
        imgProvider = (ImageView) findViewById(R.id.imageViewProviderStaff);

        /*----------------- Tool bar -----------------*/
        setSupportActionBar(toolbar);

        /*------------------ Navigation drawer menu -------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivityStaff.this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_EmployeeAccount:
                        Intent intent = new Intent(MainActivityStaff.this, EmployeeAccount.class);
                        startActivity(intent);
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
                Intent intent = new Intent(MainActivityStaff.this, AddProduct.class);
                startActivity(intent);
            }
        });

        imgWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, Warehouse.class);
                startActivity(intent);
            }
        });

        imgAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, AddCustomer.class);
                startActivity(intent);
            }
        });

        imgAddBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, AddBills.class);
                startActivity(intent);
            }
        });

        imgBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, Bills.class);
                startActivity(intent);
            }
        });

        imgCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, Customer.class);
                startActivity(intent);
            }
        });

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, Product.class);
                startActivity(intent);
            }
        });

        imgProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityStaff.this, Provider.class);
                startActivity(intent);
            }
        });
    }

}