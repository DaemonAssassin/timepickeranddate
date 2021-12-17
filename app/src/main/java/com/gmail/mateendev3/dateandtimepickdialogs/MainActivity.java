package com.gmail.mateendev3.dateandtimepickdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        TimePickerDialog.OnTimeSetListener {
    Button btnSetTime, btnSetTimeFrag, btnSetDate, btnSetDateFrag;
    TextView tvTime, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetTime = findViewById(R.id.btn_set_time);
        btnSetTimeFrag = findViewById(R.id.btn_set_time_fragment);
        btnSetDate = findViewById(R.id.btn_set_date);
        btnSetDateFrag = findViewById(R.id.btn_set_date_fragment);
        tvTime = findViewById(R.id.tv_time);
        tvDate = findViewById(R.id.tv_date);


        btnSetTime.setOnClickListener(v -> setTime());
        btnSetTimeFrag.setOnClickListener(v -> setTimeUsingFragment());
        btnSetDate.setOnClickListener(v -> setDateUsingFragment());

    }

    private void setTimeUsingFragment() {
        MyTimePickerDialog dialog = new MyTimePickerDialog();
        dialog.show(getSupportFragmentManager(), "SHOW_TIME_PICKER");
    }
    private void setTime() {

        final Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog dialog = new TimePickerDialog(
                this,
                this,
                hour,
                minutes,
                is24HourFormat
        );

        dialog.show();
    }
    private void setDateUsingFragment() {
        MyDatePickerDialog dialog = new MyDatePickerDialog();
        dialog.show(getSupportFragmentManager(), "SHOW_Date_PICKER");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tvTime.setText("Time :: " + hourOfDay + ":" + minute);
    }
}