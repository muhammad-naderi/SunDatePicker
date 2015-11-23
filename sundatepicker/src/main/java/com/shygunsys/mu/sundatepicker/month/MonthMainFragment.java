package com.shygunsys.mu.sundatepicker.month;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;
import com.shygunsys.mu.sundatepicker.R;
import com.shygunsys.mu.sundatepicker.tool.Date;


public class MonthMainFragment extends Fragment {

    public static TextView title;
    public static int monthNumber = 0;
    private static ViewPager mPager;
    private MonthPageAdapter mAdapter;

    public MonthMainFragment() {
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frame_layout, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        if (mAdapter == null)
            mAdapter = new MonthPageAdapter(getChildFragmentManager());

        mPager = (ViewPager) view.findViewById(R.id.pager);

        mPager.setAdapter(mAdapter);
        title = (TextView) view.findViewById(R.id.title);

        if (DatePickerDialog.getTypeFace() != null)
            title.setTypeface(DatePickerDialog.getTypeFace());

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int month) {
                title.setText(mAdapter.getPageTitle(month) + " "
                        + Date.getYear());
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        mPager.setCurrentItem(Date.getMonth() - 1);
        Date.updateUI();

        super.onViewCreated(view, savedInstanceState);
    }
}
