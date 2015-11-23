package com.shygunsys.mu.sundatepicker.year;

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
import com.shygunsys.mu.sundatepicker.tool.Util;


public class YearAdapter extends BaseAdapter {
    int[] years;
    Typeface typeface;
    private Context context;

    public YearAdapter(Context context, int[] years) {
        this.context = context;
        this.years = years;
        typeface = DatePickerDialog.getTypeFace();
    }

    @Override
    public int getCount() {
        return years.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View v, ViewGroup parent) {

        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.years_text_layout, null);
        }

        final TextView tv = (TextView) v.findViewById(R.id.year);

        if (typeface != null)
            tv.setTypeface(typeface);

        tv.setText(String.valueOf(years[position]));

        tv.setBackgroundColor(context.getResources().getColor(
                android.R.color.transparent));
        tv.setTextColor(context.getResources().getColor(R.color.gray));

        if (years[position] == Date.getYear()) {
            Date.setYearText(tv);
            tv.setBackground(DatePickerDialog.getCircle());
            tv.setTextColor(DatePickerDialog.getColor());
        }

        tv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (Date.getYearText() != null) {
                    Date.getYearText().setBackgroundColor(
                            context.getResources().getColor(
                                    android.R.color.transparent));
                    Date.getYearText().setTextColor(
                            context.getResources().getColor(R.color.gray));
                }

                Date.setYear(years[position]);
                Date.setYearText(tv);
                Date.updateUI();

                tv.setBackground(DatePickerDialog.getCircle());
                tv.setTextColor(DatePickerDialog.getColor());
                Util.tryVibrate(context);
                DatePickerDialog.dayMonth.performClick();
            }
        });

        return v;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

}