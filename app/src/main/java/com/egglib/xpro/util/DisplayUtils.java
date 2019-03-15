package  com.qmxs.qianmonr.util;

import android.content.Context;

/*
 * File: DisplayUtils.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/20 3:16 PM
 */
public class DisplayUtils {

    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
