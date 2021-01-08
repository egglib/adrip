package com.egglib.xpro.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egglib.xpro.R;
import com.egglib.xpro.adapter.RecyclerViewTestAdapter;
import com.egglib.xpro.bean.TestRecyclerViewBean;
import com.egglib.xpro.list.ViewRenderType;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    private RecyclerViewTestAdapter mAdapter;
    private ImageView mImgTest;
    private boolean visible = true;//是否可见

    @Override
    protected void init(Bundle savedInstanceState) {
        initViews();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test_recyclerview;
    }

    private void initViews() {
        mRecyclerview = findViewById(R.id.recyclerView);
        List<TestRecyclerViewBean> testBeans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TestRecyclerViewBean testBean = new TestRecyclerViewBean();
            testBeans.add(testBean);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerViewTestAdapter() {
            @Override
            protected void onItemClick(View view, ViewRenderType data, int position) {
                super.onItemClick(view, data, position);
            }
        };
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.refreshAddItems(testBeans);

        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onImgShow();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    onImgHide();
                } else if (dy < 0) {
                    onImgShow();
                }
            }
        });
        mImgTest = findViewById(R.id.img_test);
    }


    private void onImgShow() {
        if (!visible) {
            visible = true;
            mImgTest.animate().translationY(0).setDuration(350).setInterpolator(new AccelerateDecelerateInterpolator());
        }
    }

    private void onImgHide() {
        if (visible) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mImgTest.getLayoutParams();
            mImgTest.animate().translationY(mImgTest.getHeight() + layoutParams.bottomMargin)
                    .setDuration(350).setInterpolator(new AccelerateInterpolator());
            visible = false;
        }
    }
}
