package com.egglib.xpro.util;

import android.content.Context;
import android.graphics.Color;


public class ColorUtil {

    public int getColor(Context context, int color){
        return context.getResources().getColor(color);
    }

    public static int adjustAlpha(int shadowAlpha, int shadowColor) {
        return Color.argb(shadowAlpha, Color.red(shadowColor), Color.green(shadowColor), Color.blue(shadowColor)
        );
    }

    /**
     * 通过透明度的值得到十六进制字符串
     *
     * @param alpha
     * @return
     */
    public static String getColorHexStr(float alpha) {
        int alphaInt = Math.round(alpha * 255);//四舍五入
        String hexStr = Integer.toHexString(alphaInt).toUpperCase();
        if (hexStr.length() == 1) {
            hexStr = "0" + hexStr;
        }
        return hexStr;
    }


}
