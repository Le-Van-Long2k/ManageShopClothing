package longlevan2k.com.example.manageshopclothing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpStaff extends AppCompatActivity {

    Button btnSignUpStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_staff);

        btnSignUpStaff = (Button) findViewById(R.id.btnSignUpStaff);

        btnSignUpStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpStaff.this, LoginStaff.class);
                startActivity(intent);
            }
        });
    }
}