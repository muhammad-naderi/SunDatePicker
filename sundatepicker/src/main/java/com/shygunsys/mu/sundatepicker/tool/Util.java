package com.shygunsys.mu.sundatepicker.tool;

import android.content.Context;
import android.os.Vibrator;

import com.shygunsys.mu.sundatepicker.DatePickerDialog;


public class Util {

    private static Vibrator vibrator = null;

    public static void tryVibrate(Context context) {
        if (vibrator == null) {
            vibrator = (Vibrator) context
                    .getSystemService(Context.VIBRATOR_SERVICE);
        }

        if (DatePickerDialog.checkVibrate() && vibrator != null)
            vibrator.vibrate(20);
    }

    public static boolean isLeapYear(int year) {
        double a = 0.025;
        int b = 266;
        double leapDays0;
        double leapDays1;
        if (year > 0) {
            leapDays0 = ((year + 38) % 2820) * 0.24219 + a;
            leapDays1 = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            leapDays0 = ((year + 39) % 2820) * 0.24219 + a;
            leapDays1 = ((year + 40) % 2820) * 0.24219 + a;
        } else
            return false;

        int frac0 = (int) ((leapDays0 - (int) (leapDays0)) * 1000);
        int frac1 = (int) ((leapDays1 - (int) (leapDays1)) * 1000);

        if (frac0 <= b && frac1 > b)
            return true;
        else
            return false;
    }
}
