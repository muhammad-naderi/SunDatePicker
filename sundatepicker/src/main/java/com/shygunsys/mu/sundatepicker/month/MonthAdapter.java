package com.shygunsys.mu.sundatepicker.month;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;
import com.shygunsys.mu.sundatepicker.R;
import com.shygunsys.mu.sundatepicker.tool.Date;
import com.shygunsys.mu.sundatepicker.tool.JDF;
import com.shygunsys.mu.sundatepicker.tool.Util;

import java.text.ParseException;


public class MonthAdapter extends BaseAdapter {
    int month;
    JDF today;
    int startDay;
    Typeface typeface;
    private Context context;

    public MonthAdapter(Context context, int month) {
        this.context = context;
        this.month = month;
        today = new JDF();
        typeface = DatePickerDialog.getTypeFace();

        try {
            startDay = new JDF().getIranianDay(Date.getYear(), month + 1, 1);
        } catch (ParseException e) {
        }

    }

    @Override
    public int getCount() {
        int days = 30;
        if (month < 6)
            days = 31;
        if (month == 11 && !Util.isLeapYear(Date.getYear()))
            days = 29;

        if (DatePickerDialog.maxMonth == month + 1)
            days = today.getIranianDay();

        return days + 7 + startDay;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressWarnings("deprecation")
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        position -= 7;

        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.days_text_layout, null);
        }

        final TextView tv = (TextView) v.findViewById(R.id.day);

        if (typeface != null)
            tv.setTypeface(typeface);

        tv.setBackgroundColor(context.getResources().getColor(
                android.R.color.transparent));
        tv.setTextColor(context.getResources().getColor(R.color.gray));

        if (position >= 0 && position - startDay >= 0) {
            position -= startDay;

            tv.setText(String.valueOf(position + 1));

            if (month + 1 == today.getIranianMonth()
                    && position + 1 == today.getIranianDay()
                    && Date.getYear() == today.getIranianYear()) {
                tv.setBackgroundColor(context.getResources().getColor(
                        android.R.color.transparent));
                tv.setTextColor(DatePickerDialog.getColor());
                Date.setTodayText(tv);
            }

            if (Date.getMonth() == month + 1 && Date.getDay() == position + 1) {
                Date.setDayText(tv);
                tv.setBackgroundDrawable(DatePickerDialog.getCircle());
                tv.setTextColor(DatePickerDialog.getColor());
            }

            final int day = position + 1;
            tv.setOnClickListener(new OnClickListener() {

                @SuppressWarnings("deprecation")
                @Override
                public void onClick(View arg0) {

                    if (Date.getDayText() != null) {
                        Date.getDayText().setBackgroundColor(
                                context.getResources().getColor(
                                        android.R.color.transparent));
                        Date.getDayText().setTextColor(
                                context.getResources().getColor(R.color.gray));
                    }

                    if (Date.getTodayText() != null) {
                        Date.getTodayText().setBackgroundColor(
                                context.getResources().getColor(
                                        android.R.color.transparent));
                        Date.getTodayText().setTextColor(
                                DatePickerDialog.getColor());
                    }

                    Date.setDay(day);
                    Date.setMonth(month + 1);
                    Date.setDayText(tv);
                    Date.updateUI();

                    tv.setBackgroundDrawable(DatePickerDialog.getCircle());
                    tv.setTextColor(DatePickerDialog.getColor());

                    Util.tryVibrate(context);
                }
            });
        } else if (position < 0) {
            tv.setText(JDF.iranianDayNames[position + 7].substring(0, 1));
        }

        return v;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

}