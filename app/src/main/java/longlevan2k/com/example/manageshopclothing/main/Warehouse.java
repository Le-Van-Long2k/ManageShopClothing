package longlevan2k.com.example.manageshopclothing.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import longlevan2k.com.example.manageshopclothing.R;
import longlevan2k.com.example.manageshopclothing.api.ApiService;
import longlevan2k.com.example.manageshopclothing.model.object_request.NewProduct;
import longlevan2k.com.example.manageshopclothing.model.object_request.SupplierAddingInformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


// Them mot san pham moi vao kho hang Product
public class Warehouse extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMAERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    Button btnCamera, btnGallery;
    ImageView imageViewAddWarehouse;
    String currentPhotoPath;
    Spinner spiner_size, spiner_category;
    Toolbar toolbar;
    TextInputEditText edt_nameSupplier, edt_addressSupplier,edt_productname,edt_price, edt_originalprice, edt_warehouse;
    final String successProduct = "Added Successfully";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);



        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        imageViewAddWarehouse = findViewById(R.id.imageViewAddWarehouse);
        spiner_size = findViewById(R.id.spiner_size);
        spiner_category = findViewById(R.id.spiner_category);
        toolbar = findViewById(R.id.toolbarWarehouse);
        edt_nameSupplier = findViewById(R.id.edt_nameSupplier);
        edt_addressSupplier = findViewById(R.id.edt_addressSupplier);
        edt_productname = findViewById(R.id.edt_productname);
        edt_price = findViewById(R.id.edt_price);
        edt_originalprice  = findViewById(R.id.edt_originalprice);
        edt_warehouse = findViewById(R.id.edt_warehouse);



        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.category));
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_category.setAdapter(adapterCategory);

        ArrayAdapter<String> adapterSize = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.size));
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_size.setAdapter(adapterSize);


        // ************** camera ***************************/
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askCameraPermissions();
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });

        // ******************* save *************************/
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSaveProduct:
                        addSupplier();
                        return true;
                    case R.id.menuAddProduct:
                        Intent intent = new Intent(Warehouse.this, Warehouse.class);
                        startActivity(intent);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void addProduct() {
        NewProduct newProduct = new NewProduct(
                edt_productname.getText().toString(),
                spiner_category.getSelectedItem().toString(),
                spiner_size.getSelectedItem().toString(),
                edt_price.getText().toString(),
                edt_nameSupplier.getText().toString(),
                Integer.parseInt(edt_warehouse.getText().toString()),
                edt_originalprice.getText().toString()
        );

        ApiService.apiServiceAddProduct.addProduct(newProduct).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    if(response.body().equals(successProduct)){
                        Toast.makeText(Warehouse.this, "Thêm thành công sản phẩm", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(Warehouse.this, "Lỗi sản phẩm", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Warehouse.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addSupplier() {
        SupplierAddingInformation supplierAddingInformation = new SupplierAddingInformation(
                Objects.requireNonNull(edt_nameSupplier.getText()).toString(),
                Objects.requireNonNull(edt_addressSupplier.getText()).toString()
        );

        ApiService.apiServiceAddSupplier.addSupplier(supplierAddingInformation).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(Warehouse.this, "Thêm thành công nhà cung cấp", Toast.LENGTH_SHORT).show();
                addProduct();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Warehouse.this, "Api Error", Toast.LENGTH_SHORT).show();
            }
        });

    }


    //************* camera *********************************/
    private void askCameraPermissions() {
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) && ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED))) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERM_CODE);
        } else {
            dispatchTakePictureIntent();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent();
            } else {
                Toast.makeText(this, "Cần cấp quyền sử dụng camera", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == CAMAERA_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                File f = new File(currentPhotoPath);
                imageViewAddWarehouse.setImageURI(Uri.fromFile(f));
                Log.d("tag", "Url image is " + Uri.fromFile(f));

                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(f);
                mediaScanIntent.setData(contentUri);
                this.sendBroadcast(mediaScanIntent);
            }
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri contentUri = data.getData();
                String timeStap = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "JPEG_" + timeStap + "." + getFileExt(contentUri);
                Log.d("tag", "onActivityResult: Gallery Image Uri: " + imageFileName);
                imageViewAddWarehouse.setImageURI(contentUri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String getFileExt(Uri contentUri) {
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(c.getType(contentUri));
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "longlevan2k.com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, CAMAERA_REQUEST_CODE);
            }
        }
    }

}
