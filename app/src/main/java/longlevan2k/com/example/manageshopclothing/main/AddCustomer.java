package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.object_request.NewCustomer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCustomer extends AppCompatActivity {

    TextInputEditText edt_fullNameCustomer, edt_addressCustomer,edt_phoneCustomer;
    Toolbar toolbar;
    private final String success = "Add Successfully";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        edt_fullNameCustomer = findViewById(R.id.edt_fullNameCustomer);
        edt_addressCustomer = findViewById(R.id.edt_addressCustomer);
        edt_phoneCustomer = findViewById(R.id.edt_phoneCustomer);
        toolbar = findViewById(R.id.toolbarAddCustomer);


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSaveCustomer:
                        saveCusomer();
                        return true;
                    case R.id.menuAddCustomer:
                        Intent intent = new Intent(AddCustomer.this, AddCustomer.class);
                        startActivity(intent);
                        finish();
                        return true;
                    default:
                        return false;
                }

            }
        });
    }

    private void saveCusomer() {
        NewCustomer newCustomer = new NewCustomer(
                Objects.requireNonNull(edt_fullNameCustomer.getText()).toString(),
                Objects.requireNonNull(edt_addressCustomer.getText()).toString(),
                Objects.requireNonNull(edt_phoneCustomer.getText()).toString()
        );

        ApiService.apiServiceAddCustomer.addCustomer(newCustomer).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals(success)){
                        Toast.makeText(AddCustomer.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(AddCustomer.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(AddCustomer.this, "Lỗi", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(AddCustomer.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}