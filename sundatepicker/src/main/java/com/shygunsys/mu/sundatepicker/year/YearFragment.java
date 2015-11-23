package com.shygunsys.mu.sundatepicker.year;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shygunsys.mu.sundatepicker.R;
import com.shygunsys.mu.sundatepicker.tool.Date;

import java.util.Arrays;


public class YearFragment extends Fragment {
    int[] years;

    public YearFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.years = getArguments().getIntArray("years");

        return inflater.inflate(R.layout.years_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView list = (ListView) view.findViewById(android.R.id.list);
        list.setSelector(getResources().getDrawable(R.drawable.transparent));
        list.setAdapter(new YearAdapter(getActivity(), years));
        int index = Arrays.binarySearch(years, Date.getYear());
        list.setSelection(index);
        super.onViewCreated(view, savedInstanceState);
    }
}