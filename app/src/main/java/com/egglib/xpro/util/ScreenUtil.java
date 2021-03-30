package com.egglib.xpro.util;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtil {

  private ScreenUtil() {

  }

  public static int getScreenWidth(Context context) {
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    return displayMetrics.widthPixels;
  }

  public static int getScreenHeight(Context context) {
    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    return displayMetrics.heightPixels;
  }
}

