package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.ResponseEntity;
import longlevan2k.com.example.manageshopclothing.model.User;
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
                User userStaff = new User(2001, edtFullNameStaff.getText().toString(),
                        edtUsernameStaff.getText().toString(),
                        edtPasswordStaff.getText().toString(),
                        true);


//                ApiService.apiServiceAddUser.addUser(userStaff).enqueue(new Callback<ResponseEntity>() {
//                    @Override
//                    public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
//                        ResponseEntity responseEntity = response.body();
//                        Toast.makeText(SignUpStaff.this, "Call api success", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(SignUpStaff.this, responseEntity.getHttpStatus().toString(), Toast.LENGTH_SHORT).show();
//
////                        if (userResponse != null) {
////                            Intent intent = new Intent(SignUpStaff.this, LoginStaff.class);
////                            startActivity(intent);
////                        }else
////                            Toast.makeText(SignUpStaff.this, "Đăng kí thất bại\nNhập lại thông tin", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseEntity> call, Throwable t) {
//                        Toast.makeText(SignUpStaff.this, "Call api error", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                Toast.makeText(SignUpStaff.this, edtFullNameStaff.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}