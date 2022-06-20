package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import longlevan2k.com.example.manageshopclothing.R;

public class LoginStaff extends AppCompatActivity {


    Button btnLogin, btnSignUpStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUpStaff = (Button) findViewById(R.id.btnSignUpStaff);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginStaff.this, MainActivityStaff.class);
                startActivity(intent);
            }
        });

        btnSignUpStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginStaff.this, SignUpStaff.class);
                startActivity(intent);
            }
        });
    }
}