package com.example.aymanzinabidine;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fire extends AppCompatActivity {

    String value;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    // variable for Text view.
    private TextView retrieveTV;
    private TextView retrieveTV2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("parent");

        retrieveTV = findViewById(R.id.idTVRetrieveData);
        retrieveTV2 = findViewById(R.id.idTVRetrieveData2);

        getdata();
    }

    private void getdata() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child("name1").getValue(String.class);
                retrieveTV.setText(value);
                String value2 = snapshot.child("name2").getValue(String.class);
                retrieveTV2.setText(value2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(fire.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
