package com.gmail.mateendev3.dateandtimepickdialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class MyDatePickerDialog extends DialogFragment
implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return new DatePickerDialog(
                requireActivity(),
                this,
                year,
                month,
                day
        );
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        DateFormat mDateFormat = DateFormat.getDateInstance();

        String timeRightNow = mDateFormat.format(calendar.getTime());
        String timeRightNowFull = DateFormat.getTimeInstance().format(Calendar.getInstance().getTime());

        TextView tvTime = requireActivity().findViewById(R.id.tv_time);
        tvTime.setText(timeRightNowFull);



    }
}
