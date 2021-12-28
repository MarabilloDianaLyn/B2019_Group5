package com.example.financewise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private UiModeManager uiModeManager;
    private static int SPLASH = 3000;
    Animation animation;
    private ImageView imageView;
    private TextView appname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        imageView = findViewById(R.id.imageView);
        appname = findViewById(R.id.appname);

        imageView.setAnimation(animation);
        appname.setAnimation(animation);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(SplashScreenActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }

        }, SPLASH);

    }
}