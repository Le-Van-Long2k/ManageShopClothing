package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import longlevan2k.com.example.manageshopclothing.R;

public class ChooseUser extends AppCompatActivity {

    Button btnChuShop, btnNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        btnChuShop = (Button) findViewById(R.id.btnChuShop);
        btnNhanVien = (Button) findViewById(R.id.btnNhanVien);

        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseUser.this, LoginStaff.class);
                startActivity(intent);
            }
        });

        btnChuShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseUser.this, LoginManager.class);
                startActivity(intent);
            }
        });
    }
}