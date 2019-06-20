package com.egglib.xpro.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.gyf.barlibrary.ImmersionBar;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this).reset().navigationBarColor(R.color.white).statusBarDarkFont(true, 0.2f).init();
        setContentView(setContentViewId());
        afterSetContentView();
        initView();
        pageHandle();
    }

    /**
     * 设置视图之后的操作
     */
    protected void afterSetContentView() {

    }


    protected abstract int setContentViewId();

    /**
     * 初始化工作
     */
    protected void initView() {
    }

    /**
     * 界面处理工作
     */
    protected void pageHandle() {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }
}
