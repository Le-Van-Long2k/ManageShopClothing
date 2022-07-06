package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.object_request.UserAddingInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    TextInputEditText edt_usernameUser,edt_passwordUser, edt_fullNameUser;
    Spinner spinner_role;
    View viewSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        edt_fullNameUser = findViewById(R.id.edt_fullNameUser);
        edt_passwordUser = findViewById(R.id.edt_passwordUser);
        edt_usernameUser = findViewById(R.id.edt_usernameUser);
        spinner_role = findViewById(R.id.spiner_role);
        viewSignUp = findViewById(R.id.cardViewLogin);
        ProgressButton progressButton = new ProgressButton(SignUp.this, viewSignUp);
        progressButton.buttonSetTextSignUp();


        ArrayAdapter<String> adapterRole = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.role));
        adapterRole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_role.setAdapter(adapterRole);

        viewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

    }

    private void signUp() {
        UserAddingInformation userAddingInformation = new UserAddingInformation(
                edt_fullNameUser.getText().toString(),
                edt_passwordUser.getText().toString(),
                edt_usernameUser.getText().toString(),
                spinner_role.getSelectedItem().toString()
        );

        ProgressButton progressButton = new ProgressButton(SignUp.this, viewSignUp);
        progressButton.buttonSetTextSignUp();
        progressButton.buttonActivated();

        ApiService.apiServiceAddUser.addUser(userAddingInformation).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals("Added Succesfully")){
                        progressButton.buttonFinished(1);
                        Intent intent = new Intent(SignUp.this, MainActivityAdmin.class);
                        startActivity(intent);
                    }else{
                        progressButton.buttonFinished(2);
                        Toast.makeText(SignUp.this, "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressButton.buttonFinished(2);
                Toast.makeText(SignUp.this, "Api eror", Toast.LENGTH_SHORT).show();
            }
        });
    }
}