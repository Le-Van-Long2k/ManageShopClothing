package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.Schedule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeManager extends AppCompatActivity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_manager);
        
        btnTest = findViewById(R.id.btn_Test);
        
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
            }
        });
    }

    private void clickCallApi() {
        ApiService.apiService.scheduleTest().enqueue(new Callback<Schedule>() {
            @Override
            public void onResponse(Call<Schedule> call, Response<Schedule> response) {
                Toast.makeText(EmployeeManager.this, "Call Api Success", Toast.LENGTH_SHORT).show();

                Schedule schedule = response.body();
                if (schedule != null){
                    Toast.makeText(EmployeeManager.this, schedule.getId() + " : " + schedule.getUser().getFullName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Schedule> call, Throwable t) {
                Toast.makeText(EmployeeManager.this, "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}