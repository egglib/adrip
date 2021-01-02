package com.egglib.xpro.util;

import android.text.util.Linkify;
import android.widget.TextView;

public class TextUtil {

    public static void setLinkMask(TextView textView) {
        textView.setAutoLinkMask(Linkify.ALL);
    }

    public static void setLinkMaskColor(TextView textView, int color) {
        setLinkMask(textView);
        textView.setLinkTextColor(color);
    }
}
