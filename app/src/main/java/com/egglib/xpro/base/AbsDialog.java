package com.egglib.xpro.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public abstract class AbsDialog extends Dialog {

    public AbsDialog(@NonNull Context context) {
        super(context);
    }

    public AbsDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        init();
    }

    protected void init() {
        try {
            setCancelable(getCancelable());
            setCanceledOnTouchOutside(getCanceledOnTouchOutside());
            Window window = getWindow();
            if (window != null) {
                initParams(window);
                initView(window);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void initParams(Window window) {
        if (window.getAttributes() != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = getWindowWidth();
            layoutParams.height = getWindowHeight();
            layoutParams.gravity = getGravity();
            window.setAttributes(layoutParams);
        }
    }

    protected int getGravity() {
        return Gravity.CENTER;
    }

    protected int getWindowHeight() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    protected int getWindowWidth() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    protected abstract int getLayoutResId();

    protected abstract void initView(Window window);

    protected boolean getCancelable() {
        return true;
    }

    protected boolean getCanceledOnTouchOutside() {
        return true;
    }

}
