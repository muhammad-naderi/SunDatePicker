package com.shygunsys.mu.sundatepicker.month;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shygunsys.mu.sundatepicker.R;


/*
 * Created by Alireza Afkar - 24/10/14
 */

public class MonthFragment extends Fragment {
    int month;

    public MonthFragment() {
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
        month = getArguments().getInt("month");

        return inflater.inflate(R.layout.days_layout, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        GridView gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setSelector(getResources().getDrawable(R.drawable.transparent));
        gridView.setAdapter(new MonthAdapter(getActivity(), month));
        super.onViewCreated(view, savedInstanceState);
    }
}