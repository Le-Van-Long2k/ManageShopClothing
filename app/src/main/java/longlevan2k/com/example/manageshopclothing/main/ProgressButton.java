package longlevan2k.com.example.manageshopclothing.main;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import longlevan2k.com.example.manageshopclothing.R;

class ProgressButton {

    final CardView cardView;
    final ConstraintLayout layout;
    final ProgressBar progressBar;
    final TextView textView;

    Animation fade_in;

    ProgressButton(Context ct, View view){
        cardView = view.findViewById(R.id.cardViewLogin);
        layout = view.findViewById(R.id.constraintLayoutLogin);
        progressBar = view.findViewById(R.id.progressBarLogin);
        textView = view.findViewById(R.id.textViewLogin);
    }

    void buttonSetTextSignUp(){
        textView.setText("Đăng kí");
    }

    void buttonActivated(){
        progressBar.setVisibility(View.VISIBLE);
        textView.setText("Đang xử lý...");
    }

    void buttonFinished(int i){
        progressBar.setVisibility(View.GONE);
        if(i==1){
            layout.setBackgroundColor(Color.parseColor("#1AE602"));
            textView.setText("Thành công");
        }
        else if (i==0){
            layout.setBackgroundColor(Color.parseColor("#FF9800"));
            textView.setText("Đăng nhập");
        }
        else if (i==2){
            layout.setBackgroundColor(Color.parseColor("#FF9800"));
            textView.setText("Đăng kí");
        }

    }

}
