package com.appdet.theguttbusters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    //DBHelper DB;

    TextInputLayout one, two, tri, por, payb;
    FirebaseDatabase rootNode;
    DatabaseReference refrence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



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







    }
    private Boolean validateName(){
        String val = one.getEditText().getText().toString();

        if(val.isEmpty()){
            one.setError("Field cannot be empty");
            return false;
        }
        else{
            one.setError(null);
            return true;
        }
    }

    public void registerBtn(View view){

        if (!validateName()){
            return;
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