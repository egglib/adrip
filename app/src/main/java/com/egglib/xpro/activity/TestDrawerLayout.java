package com.egglib.xpro.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.egglib.xpro.R;

public class TestDrawerLayout extends BaseActivity {

    private DrawerLayout mDrawerlayout;
    private Button mBtnOpen;

    @Override
    protected void init(Bundle savedInstanceState) {
        initViews();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test_drawer;
    }

    private void initViews() {
        mDrawerlayout = findViewById(R.id.drawerLayout);
        mDrawerlayout.addDrawerListener(mDrawerListener);
        mBtnOpen = findViewById(R.id.btn_open);
        mBtnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerlayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private final DrawerLayout.DrawerListener mDrawerListener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            try {
                //滑动过程中不断回调 slideOffset:0~1
                View content = mDrawerlayout.getChildAt(0);
                float scale = 1 - slideOffset;//1~0
                content.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));//0~width
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}
