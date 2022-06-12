package com.appdet.theguttbusters;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class endpg extends AppCompatActivity {

    Animation l2r, r2l, top, bot;
    ImageView congrats, goal, blue, orange, purple, girl, dots;
    View btmbox;
    TextView btmtxt, timerValue, oof;
    private static final long START_TIME_IN_MILLIS = 5000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);;
        setContentView(R.layout.activity_endpg);

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
        btmbox = findViewById(R.id.btmbox);
        btmtxt = findViewById(R.id.btmtxt);
        oof = findViewById(R.id.oof);
        timerValue = (TextView) findViewById(R.id.timerValue);
        //Set animation to elements
        congrats.setAnimation(top);
        goal.setAnimation(bot);
        blue.setAnimation(bot);
        orange.setAnimation(bot);
        purple.setAnimation(bot);
        girl.setAnimation(l2r);
        dots.setAnimation(top);

        btmbox.setVisibility(View.GONE);
        btmtxt.setVisibility(View.GONE);
        timerValue.setVisibility(View.GONE);
        startTimer();
        String haha6 = getIntent().getStringExtra("try6");
        oof.setText(haha6);

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
                btmbox.setVisibility(View.VISIBLE);
                btmtxt.setVisibility(View.VISIBLE);
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