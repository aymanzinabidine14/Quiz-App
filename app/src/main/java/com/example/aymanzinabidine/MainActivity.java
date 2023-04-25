package com.example.aymanzinabidine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    String login;
    String password;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText etLogin, etPassword;
    Button bLogin;
    TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = (EditText) findViewById(R.id.etMail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4: Traitement
                if (etLogin.getText().toString().equals(login) && etPassword.getText().toString().equals(password)){

                    Intent intent = new Intent(MainActivity.this, quiz_dynamique.class);
                    intent.putExtra("quiz",1);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login or password incorrect !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("register");
        getdata();
    }



    private void getdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                login = snapshot.child("login").getValue(String.class);
                password  = snapshot.child("password").getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



