package com.example.rowastasksprint4;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.Calendar;
import java.util.Random;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


//import java.util.Calendar;
//import java.util.Date;






@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    java.util.Date date=new java.util.Date();

    TextView pcM1, pcM2, pcM3, pcM4,finishedSession, sessionText, DurationText;
    PieChart pieChart, WeekpieChart;
    TextView pcDay1, pcDay2, pcDay3, pcDay4, pcDay5;
    int tday=5, fSession=4, duration=20;
    String durationInString=(duration+" Min");
    String level="Beg";//NEED TO REMOVE


    //Calandar
    EditText edittext;
    Button button;
    Calendar calendar;
    int year,month,day;
    private TextView thedate;
    private Button btngocalendar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        // on below line we are setting up our horizontal calendar view and passing id our calendar view to it.
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                // on below line we are adding a range
                // as start date and end date to our calendar.
                .range(startDate, endDate)
                // on below line we are providing a number of dates
                // which will be visible on the screen at a time.
                .datesNumberOnScreen(5)
                // at last we are calling a build method
                // to build our horizontal recycler view.
                .build();
        // on below line we are setting calendar listener to our calendar view.
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                // on below line we are printing date
                // in the logcat which is selected.
                Log.e("TAG", "CURRENT DATE IS " + date);
            }
        });

        thedate = (TextView) findViewById(R.id.date);
        btngocalendar = (Button) findViewById(R.id.btngocalendar);

        Intent incoming = getIntent();
        String date = incoming.getStringExtra("date");
        thedate.setText(date);

        btngocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,calendarView.class);
                startActivity(intent);
            }
        });







        // Link those objects with their respective
        // id's that we have given in .XML file
        // Pie chart "Today" progress :Minutes
        pcM1 = findViewById(R.id.pcM1);
        pcM2 = findViewById(R.id.pcM2);
        pcM3 = findViewById(R.id.pcM3);
        pcM4 = findViewById(R.id.pcM4);
        pieChart = findViewById(R.id.piechart);
        DurationText=findViewById(R.id.DurationText);

        DurationText.setText(durationInString);
//
//        pcM1.setText(Integer.toString(50));
//        pcM2.setText(Integer.toString(50));
        pcM3.setText(Integer.toString(0));
        pcM4.setText(Integer.toString(0));

        int beginnerDuration, intermediateDuration, advanceDuartion, finalDuartion;



        if(level=="Beg"){
            //Duration 30 Min
            finalDuartion= (int)(duration*100/30);
//            pcM1.setText(Integer.toString(beginnerDuration));
//            pcM2.setText(Integer.toString(1-beginnerDuration));



        }else if (level=="Inter"){
            finalDuartion= (int)(duration*100/45);

////            intermediateDuration= (int)(duration*100/45);
//            pcM1.setText(Integer.toString(intermediateDuration));
//            pcM2.setText(Integer.toString(1-intermediateDuration));


        }else{
//            advanceDuartion= (int)(duration*100/60);
            finalDuartion= (int)(duration*100/60);
//
//            pcM1.setText(Integer.toString(advanceDuartion));
//            pcM2.setText(Integer.toString(1-advanceDuartion));

        }

//        beginnerDuration= ((duration*100/30));
        pcM1.setText(Integer.toString(60));//NEED MODIFY
        int remi=1-finalDuartion;
        pcM2.setText(Integer.toString(40));//NEED MODIFY






        // Set the data and color to the pie chart "Today"

        pieChart.addPieSlice(
                new PieModel(
                        "",
                        Integer.parseInt(pcM1.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "",
                        Integer.parseInt(pcM2.getText().toString()),
                        Color.parseColor("#D3C6B4")));


//        pieChart.addPieSlice(
//                new PieModel(
//                        "C++",
//                        Integer.parseInt(pcM3.getText().toString()),
//                        Color.parseColor("#EF5350")));
//        pieChart.addPieSlice(
//                new PieModel(
//                        "",
//                        Integer.parseInt(pcM4.getText().toString()),
//                        Color.parseColor("#29B6F6")));



        pieChart.startAnimation();














        //Pie chart "This Week progress"
        WeekpieChart = findViewById(R.id.Weekpiechart);
        pcDay1= findViewById(R.id.pcDay1);
        pcDay2=findViewById(R.id.pcDay2);
//        pcDay3=findViewById(R.id.pcDay3);
//        pcDay4=findViewById(R.id.pcDay4);
//        pcDay5=findViewById(R.id.pcDay5);


        finishedSession=findViewById(R.id.FinishDay);
        sessionText=findViewById(R.id.sessionText);

        double tdayInPercentage=  100/tday; //100/4 =25



        if (tday==2){
            pcDay1.setText(Integer.toString(50));
            pcDay2.setText(Integer.toString(50));
//            pcDay1=pcDay2=50;

        }else if (tday==3){
            pcDay1.setText(Integer.toString(33));
            pcDay2.setText(Integer.toString(33));
//            pcDay3.setText(Integer.toString(33));
//            pcDay1=pcDay2=pcDay3=33.33;

        }else if (tday==4){
            pcDay1.setText(Integer.toString(25));
            pcDay2.setText(Integer.toString(25));
//            pcDay3.setText(Integer.toString(25));
//            pcDay4.setText(Integer.toString(25));
//            pcDay1=pcDay2=pcDay3=pcDay4=25;


        }else {
//            pcDay1=pcDay2=pcDay3=pcDay4=pcDay5=20;
            pcDay1.setText(Integer.toString(20));
            pcDay2.setText(Integer.toString(20));
//            pcDay3.setText(Integer.toString(20));
//            pcDay4.setText(Integer.toString(20));
//            pcDay5.setText(Integer.toString(20));

        }










        ///WEEK Pie Chart

//        if (fSession>=1) {//1,2,3,4,5
//
//
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "",
//                            Integer.parseInt(pcDay1.getText().toString()),
//                            Color.parseColor("#FFA726")));
//        }else if (fSession>=2) {//2,3,4,5
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "",
//                            Integer.parseInt(pcDay2.getText().toString()),
//                            Color.parseColor("#66BB6A")));
//
//        }if(tday>2) {
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "",
//                            Integer.parseInt(pcDay3.getText().toString()),
//                            Color.parseColor("#EF5350")));
//
//        }if (tday>3) {
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "",
//                            Integer.parseInt(pcDay4.getText().toString()),
//                            Color.parseColor("#FFFFFFFF")));
//
//        } if (tday>4) {
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "Python",
//                            Integer.parseInt(pcDay5.getText().toString()),
//                            Color.parseColor("#FFA726")));
//
//        }

        String[] COLORS = new String[] { "#00AB78", "#00ab90","#007865","#bffff5", "#80ffeb"  };
        Random r= new Random();

        int rem=tday-fSession; //5-4 =1

        //4 //2
//3 ; 3<4
//        for(int i=rem ; i<tday ;i++){
////            String c= Integer.toString(COLORS[i-1]);
//
//            WeekpieChart.addPieSlice(
//                    new PieModel(
//                            "Python",
//                            Integer.parseInt(pcDay1.getText().toString()),
//                            Color.parseColor("#66BB6A",)));
//
//        }
        int t=0;
        while(t< fSession) {

             String c= COLORS[t];

            WeekpieChart.addPieSlice(
                    new PieModel(
                            "Python",
                            Integer.parseInt(pcDay1.getText().toString()),
                            Color.parseColor(c)));

        t++;

        }
        int i=0;
//        5-5=0
        while(i< rem) {
            WeekpieChart.addPieSlice(
                    new PieModel(
                            "",
                            Integer.parseInt(pcDay1.getText().toString()),
                            Color.parseColor("#D3C6B4")));

            i++;

        }



        WeekpieChart.startAnimation();

        finishedSession.setText(fSession+" of "+tday+" Sessions complated");

        if (fSession==0){ //0 of 4 days 0/2 0/3 0/4 0/5
            String[] zeroText= {"This could be your best week ever.", "New week, new chances. Let's do this!", "Alright, let's make this happen.", "Remember that goal? Let's go get it!"};
            int randnum=r.nextInt(zeroText.length);
            sessionText.setText(zeroText[randnum]);



        }else if (tday==fSession){ // 4 of 4 days 2/2 3/3 4/4 5/5
            String[] complText= {"Yippee! You've finished the session for this week. "};
            int randnum= r.nextInt(complText.length);
            sessionText.setText(complText[randnum]);

        } else if (tday-fSession==1){ // 3 of 4 days 1/2 4/5 2/3 3/4
            String[] oneDayLeftText={"Almost there! You're in it to win it.","You're almost to your goal! Let's do this." };
            int randnum=r.nextInt(oneDayLeftText.length);
            sessionText.setText(oneDayLeftText[randnum]);

        } else if (fSession==1){ // 1/3 1/4 1/5
            String[] oneText= {"One day dowm! So far, so good.", "You're on your way to your goal!", "One day of progress! Looking good.", "You nailed your first day. Nice job!", "Great start! We like what we're seeing."};
            int randnum=r.nextInt(oneText.length);
            sessionText.setText(oneText[randnum]);

        } else if (fSession==2 ){// 2/4 2/5
            String[] secondText={"Second day down! Keep on trucking.", "You're on your way to your goal!"};

        }else if (fSession==3){// 3/5
            sessionText.setText("Almost there! You're in it to win it.");
        }









//
////Calendar
//        /* starts before 1 month from now */
//        Calendar startDate = Calendar.getInstance();
//        startDate.add(Calendar.MONTH, -1);
//
//        /* ends after 1 month from now */
//        Calendar endDate = Calendar.getInstance();
//        endDate.add(Calendar.MONTH, 1);
//
//        // on below line we are setting up our horizontal calendar view and passing id our calendar view to it.
//        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
//                // on below line we are adding a range
//                // as start date and end date to our calendar.
//                .range(startDate, endDate)
//                // on below line we are providing a number of dates
//                // which will be visible on the screen at a time.
//                .datesNumberOnScreen(5)
//                // at last we are calling a build method
//                // to build our horizontal recycler view.
//                .build();
//        // on below line we are setting calendar listener to our calendar view.
//        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
//            @Override
//            public void onDateSelected(Calendar date, int position) {
//                // on below line we are printing date
//                // in the logcat which is selected.
//                Log.e("TAG", "CURRENT DATE IS " + date);
//            }
//        });



//        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
//                .startDate(startDate.getTime())
//                .endDate(endDate.getTime())
//                .datesNumberOnScreen(5)   // Number of Dates cells shown on screen (Recommended 5)
//                .dayNameFormat("EEE")	  // WeekDay text format
//                .dayNumberFormat("dd")    // Date format
//                .monthFormat("MMM") 	  // Month format
//                .showDayName(true)	  // Show or Hide dayName text
//                .showMonthName(true)	  // Show or Hide month text
//                .textColor(Color.LTGRAY, Color.WHITE)    // Text color for none selected Dates, Text color for selected Date.
//                .selectedDateBackground(Color.TRANSPARENT)  // Background color of the selected date cell.
//                .selectorColor(Color.RED)   // Color of the selection indicator bar (default to colorAccent).
//                .build();


//
//        horizontalCalendar.goToday(boolean immediate);
//        horizontalCalendar.isDatesDaysEquals(Date date1, Date date2);
//        horizontalCalendar.contains(Date date);











    }


    // pop up window ( EDIT)


    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_main, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}