package longlevan2k.com.example.manageshopclothing.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import longlevan2k.com.example.manageshopclothing.R;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;


    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView title1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // full man hinh
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = (ImageView) findViewById(R.id.imageView);
        title1 = (TextView) findViewById(R.id.textViewTitle1);

        image.startAnimation(topAnim);
        title1.startAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);//Login.class
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}