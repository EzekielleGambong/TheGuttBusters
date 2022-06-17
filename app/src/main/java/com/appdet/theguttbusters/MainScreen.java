package com.appdet.theguttbusters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainScreen extends AppCompatActivity {

    LinearLayout personalinfo, experience, review;
    TextView personalinfobtn, experiencebtn, reviewbtn, l1, l2, l3, l4, ezbtn, cal, imaginary, legezbtn, shoulderezbtn, hipezbtn, imagine, ini, deletebtn, lname,luser,chesteasy;
    Double imaginarytxt, imaginetxt;
TextView absmid, abshard, hipmid, hiphard, chesthard, chestmid;





    String user_username, user_name, user_gender, user_phoneNo, user_cal;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        personalinfo = findViewById(R.id.personalinfo);
        experience = findViewById(R.id.experience);
        review = findViewById(R.id.review);
        personalinfobtn = findViewById(R.id.personalinfobtn);
        experiencebtn = findViewById(R.id.experiencebtn);
        reviewbtn = findViewById(R.id.reviewbtn);
        lname = findViewById(R.id.lname);
        luser = findViewById(R.id.luser);
        personalinfo.setVisibility(View.VISIBLE);
        experience.setVisibility(View.GONE);
        review.setVisibility(View.GONE);

        reference = FirebaseDatabase.getInstance().getReference("users");

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        cal = findViewById(R.id.cal);
        imaginary = findViewById(R.id.imaginary);
        ini = findViewById(R.id.ini);
        ezbtn = findViewById(R.id.abseasy);
        hipezbtn = findViewById(R.id.hipeasy);
        legezbtn = findViewById(R.id.legseasy);
        shoulderezbtn = findViewById(R.id.shouldereasy);
        showAllUserData();
        deletebtn = findViewById(R.id.deletebtn);
        chesthard= findViewById(R.id.chesthard);
        chestmid = findViewById(R.id.chestmid);
        chesteasy = findViewById(R.id.chesteasy);
        abshard= findViewById(R.id.abshard);
        absmid = findViewById(R.id.absmid);
        hiphard= findViewById(R.id.hiphard);
        hipmid = findViewById(R.id.hipmid);
        imaginary.setVisibility(View.GONE);
        ini.setVisibility(View.GONE);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dltdata = l4.getText().toString();
                reference = FirebaseDatabase.getInstance().getReference("users");
                reference.child(dltdata).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(MainScreen.this,"Successfuly Deleted",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainScreen.this, Login.class);
                            startActivity(intent);

                        }else {

                            Toast.makeText(MainScreen.this,"Failed",Toast.LENGTH_SHORT).show();


                        }

                    }
                });
            }
        });

        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.VISIBLE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.GONE);
                imaginary.setVisibility(View.GONE);
                ini.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.blue));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        experiencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.VISIBLE);
                review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.blue));
                reviewbtn.setTextColor(getResources().getColor(R.color.grey));

            }
        });

        reviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.GONE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.VISIBLE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.grey));
                experiencebtn.setTextColor(getResources().getColor(R.color.grey));
                reviewbtn.setTextColor(getResources().getColor(R.color.blue));

            }
        });

        ezbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 1.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  abswk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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


        absmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 2.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  abswk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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



        abshard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 3.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this, abswk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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


        ////////

        chesteasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 1.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  chwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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


        chestmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 2.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  chwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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



        chesthard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 3.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this, chwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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


        ////////////


        hipezbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 1.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  hpwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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


        hipmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 2.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this,  hpwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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



        hiphard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_builder = new AlertDialog.Builder(MainScreen.this);
                alert_builder.setMessage("You clicked easy mode. Kindly clicked 'Yes' to proceed")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(imaginary.getText().toString().length() > 0)
                                    imaginarytxt = Double.parseDouble(imaginary.getText().toString());

                                imaginarytxt = imaginarytxt + 3.0;
                                imaginary.setText(Double.toString(imaginarytxt));


                                String get = cal.getText().toString();
                                String getz = imaginary.getText().toString();
                                String getzz = l4.getText().toString();
                                String line1 = l1.getText().toString();
                                String line2= l2.getText().toString();
                                String line3 = l3.getText().toString();
                                Intent intent = new Intent(MainScreen.this, hpwk1.class);
                                intent.putExtra("try", get);
                                intent.putExtra("tryz", getz);
                                intent.putExtra("tryzz", getzz);
                                intent.putExtra("le1", line1);
                                intent.putExtra("le2", line2);
                                intent.putExtra("le3", line3);
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
    }

    private void showAllUserData() {
        Intent intent = getIntent();
        user_username = intent.getStringExtra("username");
        user_name = intent.getStringExtra("fullname");
        user_gender = intent.getStringExtra("gender");
        user_phoneNo = intent.getStringExtra("phoneNo");
        user_cal = intent.getStringExtra("cal");

        l1.setText(user_name);
        l2.setText(user_username);
        l4.setText(user_gender);
        l3.setText(user_phoneNo);
        cal.setText(user_cal);
       lname.setText(user_name);
        luser.setText(user_username);
    }

}