package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare.database.DBHandler;

public class EditNotesActivity extends AppCompatActivity {
    ImageButton back1;
    Button add1;
    DBHandler ob1;
    TextView name1,date1;
    RadioButton radioButton1_x,getRadioButton11_x;
    RadioGroup radioGroup1;
    RadioButton radioButton1231;
    String[] s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
        back1=(ImageButton)findViewById(R.id.bck_notes);

        Intent i=getIntent();
        String data=i.getStringExtra("details");

        s = data.split("\\s+");
      /*  for(int x=0;x<3;x++){
            Toast.makeText(getApplicationContext(),s[x],
                    Toast.LENGTH_LONG).show();
        }*/

        ob1=new DBHandler(this);

        name1=findViewById(R.id.note1);
        date1=findViewById(R.id.notedate1);
        add1=(Button)findViewById(R.id.buttonAddnotes1);
        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        radioButton1_x=(RadioButton) findViewById(R.id. radioButton1);
        getRadioButton11_x=(RadioButton) findViewById(R.id. radioButton11);

        name1.setText(s[1]);
        date1.setText(s[3]);

        if(s[2].equals("Important")){
            radioButton1_x.setChecked(false);
            getRadioButton11_x.setChecked(true);
        }else{
            radioButton1_x.setChecked(true);
            getRadioButton11_x.setChecked(false);
        }



    }
    @Override
    protected void onResume() {
        super.onResume();
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        add1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String note2=name1.getText().toString();
                String date2= date1.getText().toString();
                String type2="";

                int selectedId = radioGroup1.getCheckedRadioButtonId();
                radioButton1231 = (RadioButton) findViewById(selectedId);


                type2=radioButton1231.getText().toString();

                int y =  ob1.UpdateNotes(s[0],note2,type2,date2);

                if(y==1){
                    Toast.makeText(getApplicationContext(), "Successfully Updated!",
                            Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });
    }
}