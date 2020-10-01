package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalenderActivity extends AppCompatActivity {
    CalendarView calender;
    TextView date_view;
    Button caButton;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        caButton=(Button)findViewById(R.id.callCal);



    }

    @Override
    protected void onResume() {
        super.onResume();
        caButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis()+60*60*1000);
                intent.putExtra("title", "Add Event from android app");
                startActivity(intent);
            }
        });
    }
}
