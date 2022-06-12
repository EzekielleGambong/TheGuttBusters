package com.appdet.theguttbusters;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Login extends AppCompatActivity {
    private Button moveBack2MainFLogin,nextToMainApp;
    EditText  User, Password, qone, qtwo;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://theguttbusters-default-rtdb.firebaseio.com/");
    private android.widget.EditText validatePassword, validatePhoneNum;
    private AppCompatCheckBox showpass;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout wone = findViewById(R.id.wone);
        TextInputLayout wtwo = findViewById(R.id.wtwo);
        Button loginbtn = findViewById(R.id.loginbtn);
        TextView signup = findViewById(R.id.signText);
        qone = findViewById(R.id.qone);
        qtwo = findViewById(R.id.qtwo);
        showpass = findViewById(R.id.cbShowpass);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textone = wone.getEditText().getText().toString();
                String textwo = wtwo.getEditText().getText().toString();

                if(textone.isEmpty() || textwo.isEmpty()){
                    Toast.makeText(Login.this, "Enter", Toast.LENGTH_SHORT).show();
                }
                else{
                    reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(textone)){
                                String getPassword = snapshot.child(textone).child("password").getValue(String.class);

                                if(getPassword.equals((textwo))){
                                    Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                                    String nameFromDB = snapshot.child(textone).child("fullname").getValue(String.class);
                                    String usernameFromDB = snapshot.child(textone).child("username").getValue(String.class);
                                    String phoneNoFromDB = snapshot.child(textone).child("phoneNo").getValue(String.class);
                                    String emailFromDB = snapshot.child(textone).child("gender").getValue(String.class);
                                    String calFromDB = snapshot.child(textone).child("cal").getValue(String.class);

                                    Intent intent = new Intent(getApplicationContext(), MainScreen.class);

                                    intent.putExtra("fullname", nameFromDB);
                                    intent.putExtra("username", usernameFromDB);
                                    intent.putExtra("gender", phoneNoFromDB);
                                    intent.putExtra("phoneNo", emailFromDB);
                                    intent.putExtra("cal", calFromDB);

                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this, "wpass", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this, "wpass", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        showpass.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (!isChecked) {
                // show password
                qone.setTransformationMethod(PasswordTransformationMethod.getInstance());

            } else {
                // hide password
                qone.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
    }

    public void btnClick(View view){
        if(qone.getText().length()==0)
        {
            qone.setError("Field cannot be left blank.");
        }
        if (qtwo.getText().length()==0){
            qtwo.setError("Feild cannot be left blank.");
        }
    }
}