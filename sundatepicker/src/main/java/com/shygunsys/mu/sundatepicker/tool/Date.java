package com.shygunsys.mu.sundatepicker.tool;

import android.widget.TextView;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;
import com.shygunsys.mu.sundatepicker.month.MonthMainFragment;


public class Date {

    static int day;
    static int month;
    static int year;

    static TextView todayText = null;
    static TextView dayText = null;
    static TextView yearText = null;

    public static void setDate(int _year, int _month, int _day, boolean update) {
        year = _year;
        month = _month;
        day = _day;
        if (update)
            updateUI();
    }

    /*
     * Getters
     */
    public static int getDay() {
        return day;
    }

    /*
     * Setters
     */
    public static void setDay(int _day) {
        day = _day;
    }

    public static int getMonth() {
        return month;
    }

    public static void setMonth(int _month) {
        month = _month;
    }

    public static int getYear() {
        return year;
    }

    public static void setYear(int _year) {
        year = _year;
    }

	/*
     * End of Setters
	 */

    public static TextView getDayText() {
        return dayText;
    }

    public static void setDayText(TextView _dayText) {
        dayText = _dayText;
    }

    public static TextView getTodayText() {
        return todayText;
    }

    public static void setTodayText(TextView _todayText) {
        todayText = _todayText;
    }

    public static TextView getYearText() {
        return yearText;
    }

    public static void setYearText(TextView _yearText) {
        yearText = _yearText;
    }

	/*
     * End of Getters
	 */

    public static void updateUI() {

        DatePickerDialog.updateDisplay(year, month, day);

        try {
            MonthMainFragment.title.setText(JDF.monthNames[month - 1] + " "
                    + year);
        } catch (Exception e) {
        }
    }

}
