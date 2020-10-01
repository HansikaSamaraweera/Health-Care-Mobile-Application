package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addvital extends AppCompatActivity {
    Button customize;
    Button details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvital);

        customize=findViewById(R.id.btnCustomize);
        details=findViewById(R.id.btnDetails12);
        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(addvital.this,editVital.class);
                startActivity(i2);
            }
        });
       details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(addvital.this,patientDetails.class);
                startActivity(i4);
            }
        });
    }
}