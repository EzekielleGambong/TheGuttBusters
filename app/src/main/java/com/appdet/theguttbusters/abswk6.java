package com.appdet.theguttbusters;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class abswk6 extends AppCompatActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage, bgprogress;
    LinearLayout fitone;
    ImageView imgTimer;
    //copy
    TextView data, dataz;
    TextView datazz;
    Double sum=0.0, add=3.5, addtxt;
    TextView l1,l2, l3;
    Double finz=0.0, finztxt;
    Double initial;
    //
    private static final long START_TIME_IN_MILLIS = 34000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Animation btthree, bttfour, ttbone, ttbtwo, alphago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abswk6);


        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        ttbone = AnimationUtils.loadAnimation(this, R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this, R.anim.ttbtwo);
        alphago = AnimationUtils.loadAnimation(this, R.anim.alphago);

        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        timerValue = (TextView) findViewById(R.id.timerValue);
        btnexercise = (TextView) findViewById(R.id.btnexercise);


        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        fitone = (LinearLayout) findViewById(R.id.fitone);


        imgTimer = (ImageView) findViewById(R.id.imgtimer);


        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        fitone.startAnimation(ttbone);
        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        timerValue.startAnimation(alphago);
        imgTimer.startAnimation(alphago);


        //copy
        data = (TextView) findViewById(R.id.data);
        dataz = (TextView) findViewById(R.id.dataz);




        String haha5 = getIntent().getStringExtra("try5");
        String hahaz5 = getIntent().getStringExtra("tryz5");
        data.setText(haha5);
        dataz.setText(hahaz5);
        //

        datazz = (TextView) findViewById(R.id.datazz);
        String hahazz5 = getIntent().getStringExtra("tryzz5");
        datazz.setText(hahazz5);

        l1 = (TextView) findViewById(R.id.l1);
        String lab = getIntent().getStringExtra("le11");
        l1.setText(lab);

        l2 = (TextView) findViewById(R.id.l2);
        String labe= getIntent().getStringExtra("le21");
        l2.setText(labe);

        l3 = (TextView) findViewById(R.id.l3);
        String label = getIntent().getStringExtra("le31");
        l3.setText(label);


        startTimer();

        data.getText().toString();
        if(data.getText().toString().length() > 0)
            addtxt = Double.parseDouble(data.getText().toString());
        if(dataz.getText().toString().length() > 0)
            finztxt = Double.parseDouble(dataz.getText().toString());

        initial = add * finztxt;
        sum = initial + addtxt;
        l1.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        data.setVisibility(View.GONE);
        dataz.setVisibility(View.GONE);
        datazz.setVisibility(View.GONE);
        btnexercise.setVisibility(View.GONE);
        bgprogress.setVisibility(View.GONE);

        data.setText(Double.toString(sum));
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(abswk6.this);
                alert_builder.setMessage("Do you want to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String get6 = data.getText().toString();
                                String getzz6 = datazz.getText().toString();

                                String getl1 = l1.getText().toString();
                                String getlb1 = l2.getText().toString();
                                String getlbl1 = l3.getText().toString();

                                Intent intent = new Intent(abswk6.this, endpg.class);
                                intent.putExtra("try6", get6);
                                intent.putExtra("tryzz6", getzz6);

                                intent.putExtra("le11", getl1);
                                intent.putExtra("le21", getlb1);
                                intent.putExtra("le31", getlbl1);
                                //
                                startActivity(intent);

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
        ///////
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
                bgprogress.setVisibility(View.VISIBLE);
                btnexercise.setVisibility(View.VISIBLE);


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