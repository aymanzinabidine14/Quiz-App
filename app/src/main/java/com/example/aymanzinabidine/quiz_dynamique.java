package com.example.aymanzinabidine;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class quiz_dynamique extends AppCompatActivity {

    private TextView courseNameTV,question;
    private RadioButton courseTracksTV, courseBatchTV;
    private ImageView courseIV;
    private ProgressBar loadingPB;
    private LinearLayout courseCV;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ImageView pic;
    TextView titre;

    RadioButton rb1,rb2;


    Button bNext;
    RadioGroup rg;
    RadioButton rb;
    int score,quiz,inc;

    String RepCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_dynamique);

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        question=findViewById(R.id.question);


        firebaseDatabase = FirebaseDatabase.getInstance();



        courseTracksTV = findViewById(R.id.rb2);
        courseBatchTV = findViewById(R.id.rb1);

        Intent intent=getIntent();
        quiz=intent.getIntExtra("quiz",0);
        inc = intent.getIntExtra("inc", 0);

        pic=findViewById(R.id.pic);


        switch(quiz) {
            case 1:

                databaseReference = firebaseDatabase.getReference("/quiz/1");
                getdata("1","2","3","4","5");

                //pic.setImageResource(R.drawable.q1);


                titre=findViewById(R.id.titre);
                titre.setText("quiz1");


                rg = (RadioGroup) findViewById(R.id.rg);
                bNext = (Button) findViewById(R.id.bNext);
                score = intent.getIntExtra("score", 0);
                bNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                        if (rg.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Please choose an answer!", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                            if (rb.getText().toString().equals(RepCorrect)) {
                                score += 1;
                                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                            }
                            Intent intent = new Intent(quiz_dynamique.this, quiz_dynamique.class);
                            intent.putExtra("score", score);
                            intent.putExtra("quiz",2);
                            intent.putExtra("inc",inc);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
                break;

            case 2:

                databaseReference = firebaseDatabase.getReference("quiz/2");
                getdata("1","2","3","4","5");


                titre=findViewById(R.id.titre);
                titre.setText("quiz 2");
                rg = (RadioGroup) findViewById(R.id.rg);
                bNext = (Button) findViewById(R.id.bNext);
                score = intent.getIntExtra("score", 0);
                bNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                        if (rg.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                            if (rb.getText().toString().equals(RepCorrect)) {
                                score += 1;
                                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                            }
                            Intent intent = new Intent(quiz_dynamique.this, quiz_dynamique.class);
                            intent.putExtra("score", score);
                            intent.putExtra("quiz",3);
                            intent.putExtra("inc",inc);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
                break;

            case 3:

                databaseReference = firebaseDatabase.getReference("quiz/3");
                getdata("1","2","3","4","5");

                titre=findViewById(R.id.titre);
                titre.setText("quiz 3");


                rg = (RadioGroup) findViewById(R.id.rg);
                bNext = (Button) findViewById(R.id.bNext);
                score = intent.getIntExtra("score", 0);
                bNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                        if (rg.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                            if (rb.getText().toString().equals(RepCorrect)) {
                                score += 1;
                                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                            }
                            Intent intent = new Intent(quiz_dynamique.this, quiz_dynamique.class);
                            intent.putExtra("score", score);
                            intent.putExtra("quiz",4);
                            intent.putExtra("inc",inc);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
                break;

            case 4:

                databaseReference = firebaseDatabase.getReference("quiz/4");
                getdata("1","2","3","4","5");


                titre=findViewById(R.id.titre);
                titre.setText("quiz4");

                rg = (RadioGroup) findViewById(R.id.rg);
                bNext = (Button) findViewById(R.id.bNext);
                score = intent.getIntExtra("score", 0);
                bNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                        if (rg.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Please choose an answer!", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                            if (rb.getText().toString().equals(RepCorrect)) {
                                score += 1;
                                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                            }
                            Intent intent = new Intent(quiz_dynamique.this, quiz_dynamique.class);
                            intent.putExtra("score", score);
                            intent.putExtra("quiz",5);
                            intent.putExtra("inc",inc);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
                break;



            case 5:

                databaseReference = firebaseDatabase.getReference("quiz/5");
                getdata("1","2","3","4","5");

                titre=findViewById(R.id.titre);
                titre.setText("quiz5");


                rg = (RadioGroup) findViewById(R.id.rg);
                bNext = (Button) findViewById(R.id.bNext);
                score = intent.getIntExtra("score", 0);
                bNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                        if (rg.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Please choose an answer!", Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_SHORT).show();
                            if (rb.getText().toString().equals(RepCorrect)) {
                                score += 1;
                                //Toast.makeText(getApplicationContext(),score+"",Toast.LENGTH_SHORT).show();
                            }
                            Intent intent = new Intent(quiz_dynamique.this, Score.class);
                            intent.putExtra("score", score);
                            intent.putExtra("inc",inc);
                            startActivity(intent);
                            finish();
                        }

                    }
                });

                break;

            default:
                break;

        }
    }


    private void getdata(String qst,String rp1,String rp2,String rpc,String image) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child(rp1).getValue(String.class);
                rb1.setText(value);
                String value2 = snapshot.child(rp2).getValue(String.class);
                rb2.setText(value2);
                String value3 = snapshot.child(rpc).getValue(String.class);
                RepCorrect=value3;
                String value4 = snapshot.child(qst).getValue(String.class);
                question.setText(value4);
                String value5 = snapshot.child(image).getValue(String.class);
                Picasso.get().load(value5).into(pic);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(quiz_dynamique.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
