package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;

import longlevan2k.com.example.manageshopclothing.R;

public class AddProduct extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMAERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    ImageView imageViewAddProduct;
    String currentPhotoPath;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        imageViewAddProduct = findViewById(R.id.imageViewAddProduct);
        toolbar = findViewById(R.id.toolbarAddItem);

    }

}


