package com.shygunsys.mu.sundatepicker.month;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;
import com.shygunsys.mu.sundatepicker.tool.Date;
import com.shygunsys.mu.sundatepicker.tool.JDF;


public class MonthPageAdapter extends FragmentPagerAdapter {
    public MonthPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return JDF.monthNames[position];
    }

    @Override
    public int getCount() {
        if (DatePickerDialog.maxMonth > 0
                && new JDF().getIranianYear() == Date.getYear())
            return DatePickerDialog.maxMonth;
        else
            return JDF.monthNames.length;
    }

    @Override
    public Fragment getItem(int month) {
        MonthFragment monthFragment = new MonthFragment();
        Bundle b = new Bundle();
        b.putInt("month", month);
        monthFragment.setArguments(b);
        return monthFragment;
    }
}