package com.shygunsys.mu.sundatepicker.year;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;


public class YearPageAdapter extends FragmentPagerAdapter {

    int[] years;

    public YearPageAdapter(FragmentManager fm, int[] years) {
        super(fm);
        this.years = years;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "" + years[position];
    }

    public int getYear(int position) {
        return years[position];
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Fragment getItem(int year) {
        YearFragment YearFragment = new YearFragment();
        Bundle b = new Bundle();
        b.putIntArray("years", years);
        YearFragment.setArguments(b);
        return YearFragment;
    }
}