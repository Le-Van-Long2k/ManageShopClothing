package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.LoginInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginStaff extends AppCompatActivity {


    Button btnLogin, btnSignUpStaff;
    TextInputEditText edtUsername, edtPassword;
    private final String success = "Accepted Access";
    private final String wrong = "Something Wrong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUpStaff = (Button) findViewById(R.id.btnSignUpStaff);
        edtPassword = findViewById(R.id.edt_passwordStaff);
        edtUsername = findViewById(R.id.edt_usernameStaff);

        btnLogin.setOnClickListener(view -> Login());

        btnSignUpStaff.setOnClickListener(view -> {
            Intent intent = new Intent(LoginStaff.this, SignUpStaff.class);
            startActivity(intent);
        });
    }

    private void Login() {
        LoginInformation loginInformation = new LoginInformation(
                Objects.requireNonNull(edtUsername.getText()).toString(),
                Objects.requireNonNull(edtPassword.getText()).toString()
        );

        ApiService.apiServiceLogin.login(loginInformation).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals(success)){
                        Toast.makeText(LoginStaff.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginStaff.this, MainActivityStaff.class);
                        startActivity(intent);
                    }
                    if(response.body().equals(wrong)){
                        Toast.makeText(LoginStaff.this, "username hoặc password sai", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(LoginStaff.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}