package com.egglib.xpro.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.gyf.immersionbar.ImmersionBar;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setStatusBar();
            setContentView(getLayoutResId());
            init(savedInstanceState);
            pageHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutResId();

    protected void setStatusBar() {
        ImmersionBar.with(this).reset()
                .fitsSystemWindows(true, R.color.white)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.white)
                .init();
    }


    /**
     * 界面处理工作
     */
    protected void pageHandle() {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
