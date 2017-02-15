package com.example.audrius.restix.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.audrius.restix.R;

import java.util.Calendar;


public class ReservationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        final EditText nameText = (EditText)findViewById(R.id.nameText);
        final EditText surnameText = (EditText)findViewById(R.id.surnameText);
        EditText attendanceText = (EditText)findViewById(R.id.attendanceText);
        final TextView dateText = (TextView) findViewById(R.id.dateText);
        final TextView timeText = (TextView) findViewById(R.id.timeText);
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        int s=monthOfYear+1;
                        String a = dayOfMonth+"/"+s+"/"+year;
                        dateText.setText(""+a);
                    }
                };

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog d = new DatePickerDialog(ReservationActivity.this, dpd, year ,month, day);
                d.show();
            }
        });

        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        timeText.setText(hour + ":" + min);
                    }
                };
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(ReservationActivity.this, timeSetListener,hour,minute,true);
                timePickerDialog.show();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","audrius.alekna2@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reservation");
                emailIntent.putExtra(Intent.EXTRA_TEXT, nameText.getText().toString() + " " + surnameText.getText().toString() + "\n"
                + timeText.getText().toString() + "\n" + dateText.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    kill_activity();
            }
        });


    }
    void kill_activity()
    {
        finish();
    }


}
