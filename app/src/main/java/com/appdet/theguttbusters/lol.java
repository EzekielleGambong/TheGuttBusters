package com.appdet.theguttbusters;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class lol extends AppCompatActivity {

    Animation l2r, r2l, top, bot;
    ImageView congrats, goal, blue, orange, purple, girl, dots;
    TextView done, timerValue, oof, oofz;
    View donebg;
    private static final long START_TIME_IN_MILLIS = 5000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);;
        setContentView(R.layout.activity_lol);

        //Animations
        l2r = AnimationUtils.loadAnimation(this, R.anim.left2right_animation);
        r2l = AnimationUtils.loadAnimation(this, R.anim.right2left_animation);
        top = AnimationUtils.loadAnimation(this, R.anim.topz_animation);
        bot = AnimationUtils.loadAnimation(this, R.anim.botz_animation);

        congrats = findViewById(R.id.iv_congrats);
        goal = findViewById(R.id.iv_goal);
        blue = findViewById(R.id.iv_blues);
        orange = findViewById(R.id.iv_orange);
        purple = findViewById(R.id.iv_purple);
        girl = findViewById(R.id.iv_girl);
        dots = findViewById(R.id.iv_dots);
        oof = findViewById(R.id.oof);
        oofz = findViewById(R.id.oofz);
        done = findViewById(R.id.done);
        donebg = findViewById(R.id.donebg);
        timerValue = findViewById(R.id.timerValue);
        //Set animation to elements
        congrats.setAnimation(top);
        goal.setAnimation(bot);
        blue.setAnimation(bot);
        orange.setAnimation(bot);
        purple.setAnimation(bot);
        girl.setAnimation(l2r);
        dots.setAnimation(top);

        done.setVisibility(View.GONE);
        donebg.setVisibility(View.GONE);


        String haha6 = getIntent().getStringExtra("try6");
        oof.setText(haha6);
        //


        String hahaz6 = getIntent().getStringExtra("tryzz6");
        oofz.setText(hahaz6);
        //

        startTimer();
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                //copy
                done.setVisibility(View.VISIBLE);
                donebg.setVisibility(View.VISIBLE);


                //

            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds) ;
        timerValue.setText(timeLeft);
    }
}