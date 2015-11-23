package com.shygunsys.mu.sundatepickerexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;
import com.shygunsys.mu.sundatepicker.tool.JDF;

import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private JDF jdf;
    private Activity mActivity;
    private DatePickerDialog.OnDateSetListener listener;
    private Calendar calendar;
    private TextView tvDate;
    private int requestID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;
        tvDate = (TextView) findViewById(R.id.tvDate);

        jdf = new JDF();

        listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(int id, Calendar _calendar, int year, int month, int day) {
                calendar = _calendar;
                jdf.setIranianDate(year, month, day);
                tvDate.setText(jdf.getIranianDate());
            }
        };
    }

    public void pickDate(View view) {
        final DatePickerDialog dp = DatePickerDialog.newInstance(listener, false);

        requestID = new Random().nextInt();


        dp.setVibrate(false);

        dp.setYearRange(jdf.getIranianYear() - 10, jdf.getIranianYear() + 10);


        dp.setInitialDate(jdf.getIranianYear(), jdf.getIranianMonth(), jdf.getIranianDay());
        dp.setRequestID(requestID);
        dp.show(mActivity.getFragmentManager(), "datePicker");
    }
}
