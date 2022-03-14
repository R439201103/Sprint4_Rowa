package com.example.rowastasksprint4;

import android.os.Bundle;
import android.widget.CalendarView;
import android.util.Log;
import android.content.Intent;





import androidx.appcompat.app.AppCompatActivity;

public class calendarView extends AppCompatActivity {

    private  static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_layout);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/"+ dayOfMonth ;
                Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
                Intent intent = new Intent(calendarView.this,MainActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });
    }
}