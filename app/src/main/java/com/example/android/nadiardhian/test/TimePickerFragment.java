package com.example.android.nadiardhian.test;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener { //method untuk mendeklarasi datepicker

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker.
        final Calendar c = Calendar.getInstance(); //mendefinisikan calendar,getinstance() akan digunakan untuk mereferensi kelas yang lain
        int year = c.get(Calendar.YEAR);//mendefinisikan tahun dengan tipe data int
        int month = c.get(Calendar.MONTH); //mendefinisikan bulan dengan tipe data int
        int day = c.get(Calendar.DAY_OF_MONTH); //mendefinisikan hari dengan tipe data int

        // Create a new instance of DatePickerDialog and return it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) { //set datepicker di class takeaway
        // Convert the date elements to strings.
        // Set the activity to the Main Activity.
        TakeAwayActivity activity = (TakeAwayActivity) getActivity();
        // Invoke Main Activity's processDatePickerResult() method.
        activity.processDatePickerResult(year, month, day);
    }

}
