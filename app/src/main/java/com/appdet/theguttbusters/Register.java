package com.appdet.theguttbusters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity  {
    private Button moveBack2MainFRegis;
    EditText name, contact, dob;
    TextView viss;
    private android.widget.EditText passH, phoneH, userH, nameH, genderH;
    private AppCompatCheckBox checkbox;
    //DBHelper DB;

    TextInputLayout one, two, tri, por, payb;
    FirebaseDatabase rootNode;
    DatabaseReference refrence;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        checkbox = findViewById(R.id.cbShowpassRegis);
        phoneH = findViewById(R.id.oneInputEditText);
        userH = findViewById(R.id.twoInputEditText);
        nameH = findViewById(R.id.triInputEditText);
        genderH = findViewById(R.id.porInputEditText);
        passH = findViewById(R.id.paybInputEditText);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        tri = findViewById(R.id.tri);
        por = findViewById(R.id.por);
        payb = findViewById(R.id.payb);
        viss = findViewById(R.id.viss);

        viss.setVisibility(View.GONE);
        moveBack2MainFRegis = findViewById(R.id.btBack2MainFRegis);
        moveBack2MainFRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (!isChecked) {
                    // show password
                    passH.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    passH.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }
//    private Boolean validateName(){
//        String val = one.getEditText().getText().toString();
//
//        if(val.isEmpty()){
//            one.setError("Field cannot be empty");
//            return false;
//        }
//        else{
//            one.setError(null);
//            return true;
//        }
//    }

    public void registerBtn(View view){

        if(phoneH.getText().length()==0) {
            phoneH.setError("Field cannot be left blank.");
        }
        if(userH.getText().length()==0){
            userH.setError("Field cannot be left blank.");
        }
        if(nameH.getText().length()==0){
            nameH.setError("Field cannot be left blank.");
        }
        if(genderH.getText().length()==0){
            genderH.setError("Field cannot be left blank.");
        }
        if(passH.getText().length()==0){
            passH.setError("Field cannot be left blank.");
        }

        rootNode = FirebaseDatabase.getInstance();
        refrence = rootNode.getReference("users");

        String phoneNo = one.getEditText().getText().toString();
        String username = two.getEditText().getText().toString();
        String fullname = tri.getEditText().getText().toString();
        String gender = por.getEditText().getText().toString();
        String password = payb.getEditText().getText().toString();
        String cal = viss.getText().toString();

        UserHelperClass helperClass = new UserHelperClass(phoneNo, username, fullname,gender, password, cal);

        refrence.child(phoneNo).setValue(helperClass);

    }

}