package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class editVital extends AppCompatActivity {
    Button vdetails,pdetails,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_vital);

        vdetails=findViewById(R.id.btnDetails);
        pdetails=findViewById(R.id.btnVitalcuz);
        cancel=findViewById(R.id.btnCancel2);

        vdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pd=new Intent(editVital.this,patientDetails.class);
                startActivity(pd);
            }
        });

        pdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vd=new Intent(editVital.this,addvital.class);
                startActivity(vd);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c=new Intent(editVital.this,addvital.class);
                startActivity(c);
            }
        });
    }
}