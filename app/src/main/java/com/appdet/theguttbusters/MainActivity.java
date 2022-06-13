package com.appdet.theguttbusters;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    Animation topAnim, bottomAnim;
    ImageView logo, text, footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bot_animation);

        logo = findViewById(R.id.ivpage_logo);
        text = findViewById(R.id.ivguttbusters);
        footer = findViewById(R.id.ivpage_footer);

        //Set animation to elements
        logo.setAnimation(bottomAnim);
        text.setAnimation(topAnim);
        footer.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Tuts1.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}