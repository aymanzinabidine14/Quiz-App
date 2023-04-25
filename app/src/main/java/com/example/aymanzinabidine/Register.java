package com.example.aymanzinabidine;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText etMail, etPassword, etPassword1;
    Button bRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etMail=(EditText) findViewById(R.id.etMail);
        etPassword=(EditText) findViewById(R.id.etPassword);
        etPassword1=(EditText)findViewById(R.id.etPassword1);
        bRegister=(Button)findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=etMail.getText().toString();
                String password=etPassword.getText().toString();
                String password1=etPassword1.getText().toString();
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Please fill in the required fields",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password1)){
                    Toast.makeText(getApplicationContext(),"Please confirm your password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6){
                    Toast.makeText(getApplicationContext(),"Password must be at least 6 characters",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(password1)){
                    Toast.makeText(getApplicationContext(),"Please enter correct password",Toast.LENGTH_SHORT).show();
                    return;
                }




                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
                String recordPath = "register";
                DatabaseReference recordRef = databaseRef.child(recordPath);
                Map<String, Object> updateData = new HashMap<>();
                updateData.put("login", mail);
                recordRef.updateChildren(updateData);

                updateData.put("password",password);
                recordRef.updateChildren(updateData);



                Toast.makeText(getApplicationContext(),"Registration Successful!  inscription réussi! التسجيل ناجح! 註冊成功  ",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Register.this,MainActivity.class));
                finish();
            }
        });
    }
}
