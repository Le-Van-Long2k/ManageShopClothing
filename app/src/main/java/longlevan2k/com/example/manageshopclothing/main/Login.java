package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;
import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.object_request.LoginInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Login extends AppCompatActivity {

    TextInputEditText edtUsername, edtPassword;
    View viewLogin;
    private final String success = "Accepted Access";
    private final String wrong = "Something Wrong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        viewLogin = findViewById(R.id.cardViewLogin);

        viewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        LoginInformation loginInformation = new LoginInformation(
                Objects.requireNonNull(edtUsername.getText()).toString(),
                Objects.requireNonNull(edtPassword.getText()).toString()
        );

        ProgressButton progressButton = new ProgressButton(Login.this, viewLogin);
        progressButton.buttonActivated();

        ApiService.apiServiceLogin.login(loginInformation).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals("manager")){
                        progressButton.buttonFinished(1);
                        Intent intent = new Intent(Login.this, MainActivityManager.class);
                        startActivity(intent);
                        finish();
                    }
                    else if(response.body().equals("staff")){
                        progressButton.buttonFinished(1);
                        Intent intent = new Intent(Login.this, MainActivityStaff.class);
                        startActivity(intent);
                        finish();
                    }
                    else if(response.body().equals("admin")){
                        progressButton.buttonFinished(1);
                        Intent intent = new Intent(Login.this, MainActivityAdmin.class);
                        startActivity(intent);
                        finish();
                    }
                   else{
                        progressButton.buttonFinished(0);
                        Toast.makeText(Login.this, "Sai username hoặc password", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    progressButton.buttonFinished(0);
                    Toast.makeText(Login.this, "Sai username hoặc password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressButton.buttonFinished(0);
                Toast.makeText(Login.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}