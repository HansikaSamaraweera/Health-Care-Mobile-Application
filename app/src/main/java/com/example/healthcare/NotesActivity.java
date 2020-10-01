package com.example.healthcare;

import android.os.Build;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.database.DBHandler;

import java.sql.Date;


public class NotesActivity extends AppCompatActivity {

    ImageButton back;
    Button add;
    DBHandler ob;
    TextView name,date;
    RadioButton radioButton123;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        back=(ImageButton)findViewById(R.id.bck_notes);
        ob=new DBHandler(this);

        name=findViewById(R.id.note);
        date=findViewById(R.id.notedate);
        add=(Button)findViewById(R.id.buttonAddnotes);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);



    }

    @Override
    protected void onResume() {
        super.onResume();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String note1=name.getText().toString();
               String date1=  date.getText().toString();
                String type1="";

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton123 = (RadioButton) findViewById(selectedId);


                type1=radioButton123.getText().toString();

               int y =  ob.addNotes(note1,type1,date1);

                if(y==1){
                    Toast.makeText(getApplicationContext(), "Successfully Added!",
                            Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });
    }
}
