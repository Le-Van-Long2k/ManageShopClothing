package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.Schedule;
import longlevan2k.com.example.manageshopclothing.model.User;
import longlevan2k.com.example.manageshopclothing.model.UserAddingInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpStaff extends AppCompatActivity {

    Button btnSignUpStaff;
    TextInputEditText edtFullNameStaff, edtUsernameStaff, edtPasswordStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_staff);

        btnSignUpStaff = (Button) findViewById(R.id.btnSignUpStaff);
        edtFullNameStaff = (TextInputEditText) findViewById(R.id.edtFullNameStaff);
        edtPasswordStaff = (TextInputEditText) findViewById(R.id.edtPasswordStaff);
        edtUsernameStaff = (TextInputEditText) findViewById(R.id.edtUsernameStaff);


        btnSignUpStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                UserAddingInformation userAddingInformation = new UserAddingInformation(
//                        edtFullNameStaff.getText().toString(),
//                        edtPasswordStaff.getText().toString(),
//                        edtUsernameStaff.getText().toString()
//                );


//                UserAddingInformation userAddingInformation = new UserAddingInformation();
//
//                ApiService.apiServiceAddUser.addUser(new Gson().toJson(userAddingInformation)).enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, ResponseRequest<String> response) {
//
//                        //String rp = response.body();
//                        if (response.isSuccessful())
//                            Toast.makeText(SignUpStaff.this, "Call api success", Toast.LENGTH_SHORT).show();
//                        else
//                            Toast.makeText(SignUpStaff.this, "Call api error", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        Toast.makeText(SignUpStaff.this, "Call api error", Toast.LENGTH_SHORT).show();
//                    }
//                });


            }
        });

    }
}