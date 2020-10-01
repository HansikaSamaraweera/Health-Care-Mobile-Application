package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class patientDetails extends AppCompatActivity {
    Button btnaddVital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        btnaddVital=findViewById(R.id.btnVital56);

        btnaddVital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(patientDetails.this,addvital.class);
                startActivity(intent);
            }
        });
    }
}
