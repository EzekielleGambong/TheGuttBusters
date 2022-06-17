package com.appdet.theguttbusters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class otp extends AppCompatActivity {
    Button donebtn;
    EditText otptxt;
    ProgressBar pgBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        donebtn = findViewById(R.id.donebtn);
        otptxt = findViewById(R.id.otptxt);
        pgBar = findViewById(R.id.pgBar);

        String phoneNo  = getIntent().getStringExtra("phoneNo");
        
        sendVerificationCodeToUser(phoneNo);
    }

    private void sendVerificationCodeToUser(String phoneNo) {

    }
}