package  com.qmxs.qianmonr.util;

import android.graphics.Color;

/*
 * File: ColorUtil.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/20 3:15 PM
 */
public class ColorUtil {

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
