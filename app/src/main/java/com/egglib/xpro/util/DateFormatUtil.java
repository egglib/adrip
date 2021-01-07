package com.egglib.xpro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatUtil {

    public static String strFormatToYMD(String dateStr) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date;
        String outDateStr = "";
        try {
            date = simpleDateFormat.parse(dateStr);
            outDateStr = simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outDateStr;
    }


    public static String strFormatToMD(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.getDefault());
        Date date;
        String outDateStr = "";
        try {
            date = format.parse(dateStr);
            outDateStr = simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outDateStr;
    }

}
