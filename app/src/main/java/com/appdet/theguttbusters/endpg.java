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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class endpg extends AppCompatActivity {

    Animation l2r, r2l, top, bot;
    ImageView congrats, goal, blue, orange, purple, girl, dots;
    View btmbox;
    TextView l1,l2, l3;
    TextView btmtxt, timerValue, oof, oofz;
    private static final long START_TIME_IN_MILLIS = 5000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);;
        setContentView(R.layout.activity_endpg);
        reference = FirebaseDatabase.getInstance().getReference("users");
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
        oofz = (TextView) findViewById(R.id.datazz);
        girl = findViewById(R.id.iv_girl);
        dots = findViewById(R.id.iv_dots);
        btmbox = findViewById(R.id.btmbox);
        btmtxt = findViewById(R.id.btmtxt);
        oof = findViewById(R.id.oof);
        oofz = findViewById(R.id.oofz);
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
        //


        String hahaz6 = getIntent().getStringExtra("tryzz6");
        oofz.setText(hahaz6);
        //

        l1 = (TextView) findViewById(R.id.l1);
        String lab = getIntent().getStringExtra("le11");
        l1.setText(lab);

        l2 = (TextView) findViewById(R.id.l2);
        String labe= getIntent().getStringExtra("le21");
        l2.setText(labe);

        l3 = (TextView) findViewById(R.id.l3);
        String label = getIntent().getStringExtra("le31");
        l3.setText(label);

        l1.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        oof.setVisibility(View.GONE);
        oofz.setVisibility(View.GONE);


        btmtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(endpg.this);
                alert_builder.setMessage("Do you want to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(isPasswordChanged()){



                                    String calo = oof.getText().toString();
                                    String getzz6 = oofz.getText().toString();

                                    String getl1 = l1.getText().toString();
                                    String getlb1 = l2.getText().toString();
                                    String getlbl1 = l3.getText().toString();

                                    Intent intent = new Intent(endpg.this, MainScreen.class);
                                    intent.putExtra("phoneNo", getzz6);
                                    intent.putExtra("cal", calo);
                                    intent.putExtra("fullname", getl1);
                                    intent.putExtra("username", getlb1);
                                    intent.putExtra("gender", getlbl1 );


                                    startActivity(intent);


                                }
                                else{
                                    Toast.makeText(endpg.this, "Data is sae and can not", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(endpg.this, MainScreen.class);

                                    startActivity(intent);
                                }


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alert_builder.create();
                alertDialog.setTitle("WARNING");
                alertDialog.show();
            }
        });




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




    private boolean isPasswordChanged() {
        String haha6 = getIntent().getStringExtra("try6");
        oof.setText(haha6);
        String hahazz6 = getIntent().getStringExtra("tryzz6");
        oofz.setText(hahazz6);







        if(!hahazz6.equals(oof.getText().toString())){
            reference.child(hahazz6).child("cal").setValue(oof.getText().toString());

            return true;
        }
        else{
            return false;
        }
    }






}