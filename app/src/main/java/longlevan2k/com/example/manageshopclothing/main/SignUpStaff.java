package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.object_request.UserAddingInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpStaff extends AppCompatActivity {

    View viewLogin;
    TextInputEditText edtFullNameStaff, edtUsernameStaff, edtPasswordStaff;
    private final String success = "Added Succesfully";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_staff);

        viewLogin = findViewById(R.id.cardViewLogin);
        edtFullNameStaff =  findViewById(R.id.edtFullNameStaff);
        edtPasswordStaff = findViewById(R.id.edtPasswordStaff);
        edtUsernameStaff =  findViewById(R.id.edtUsernameStaff);
        ProgressButton progressButton = new ProgressButton(SignUpStaff.this, viewLogin);
        progressButton.buttonSetTextSignUp();

        viewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAddingInformation userAddingInformation = new UserAddingInformation(
                        edtFullNameStaff.getText().toString(),
                        edtPasswordStaff.getText().toString(),
                        edtUsernameStaff.getText().toString()
                );

                ProgressButton progressButton = new ProgressButton(SignUpStaff.this, viewLogin);
                progressButton.buttonSetTextSignUp();
                progressButton.buttonActivated();

                ApiService.apiServiceAddUser.addUser(userAddingInformation).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()){
                            if(response.body().equals(success)){
                                progressButton.buttonFinished(1);
                                Intent intent = new Intent(SignUpStaff.this, LoginStaff.class);
                                startActivity(intent);
                            }else{
                                progressButton.buttonFinished(2);
                                Toast.makeText(SignUpStaff.this, "Thất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        progressButton.buttonFinished(2);
                        Toast.makeText(SignUpStaff.this, "Api eror", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
}