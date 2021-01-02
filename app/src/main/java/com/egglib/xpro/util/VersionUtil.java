package com.egglib.xpro.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class VersionUtil {

    private static String mVersionStr;

    /**
     * 是否是最新版本
     */
    public static boolean isLatest(Context context,String version) {
        if (TextUtils.isEmpty(version)) {
            return true;
        }
        String curVersion = getVersion(context);
        if (TextUtils.isEmpty(curVersion)) {
            return true;
        }
        return curVersion.equals(version);
    }

    /**
     * 获取版本号
     */
    public static String getVersion(Context context) {
        if (TextUtils.isEmpty(mVersionStr)) {
            try {
                PackageManager manager = context.getPackageManager();
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                mVersionStr = info.versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mVersionStr;
    }

}
