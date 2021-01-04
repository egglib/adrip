package com.egglib.xpro.util;

import android.content.Context;

public class StringUtil {

    /**
     * 获取到隐藏的电话号码
     *
     * @param phoneNumber
     * @return
     */
    public static String getHidePhoneNumber(String phoneNumber) {
        String newPhoneStr = "";
        if (phoneNumber.length() > 0 && phoneNumber.length() == 11) {
            newPhoneStr = phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(7);
        }
        return newPhoneStr;
    }

    public static String getString(Context context, int string) {
        return context.getResources().getString(string);
    }
}
