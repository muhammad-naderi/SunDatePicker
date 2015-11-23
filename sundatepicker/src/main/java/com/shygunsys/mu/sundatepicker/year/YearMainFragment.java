package com.shygunsys.mu.sundatepicker.year;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shygunsys.mu.sundatepicker.R;
import com.shygunsys.mu.sundatepicker.tool.Date;



/*
 * Created by Alireza Afkar - 24/10/14
 */

public class YearMainFragment extends Fragment {

    public static int yearNumber = 0;
    private static ViewPager mPager;
    int minYear;
    int maxYear;
    int[] years;
    private YearPageAdapter mAdapter;

    public YearMainFragment(int minYear, int maxYear) {
        setRetainInstance(true);
        this.minYear = minYear;
        this.maxYear = maxYear;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frame_layout, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        years = new int[(maxYear - minYear) + 1];
        int counter = 0;
        for (int i = minYear; i <= maxYear; i++) {
            years[counter++] = i;
        }

        if (mAdapter == null)
            mAdapter = new YearPageAdapter(getChildFragmentManager(), years);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        ((TextView) view.findViewById(R.id.title))
                .setVisibility(View.INVISIBLE);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int year) {
                Date.setYear(mAdapter.getYear(year));
                Date.updateUI();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

}
