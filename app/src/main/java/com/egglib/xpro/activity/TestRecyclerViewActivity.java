package com.egglib.xpro.activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.egglib.xpro.R;
import com.egglib.xpro.adapter.RecyclerViewTestAdapter;
import com.egglib.xpro.adapter.TestRecyclerViewAdapter;
import com.egglib.xpro.bean.TestRecyclerViewBean;
import com.egglib.xpro.list.ViewRenderType;

import java.util.ArrayList;
import java.util.List;

public class TestRecyclerViewActivity extends BaseActivity {

    private RecyclerView mRecyclerview;
    private RecyclerViewTestAdapter mAdapter;

    @Override
    protected void init(Bundle savedInstanceState) {
        initViews();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test;
    }

    private void initViews() {
        mRecyclerview = findViewById(R.id.recyclerView);
        List<TestRecyclerViewBean> testBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestRecyclerViewBean testBean = new TestRecyclerViewBean();
            testBeans.add(testBean);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mAdapter = new RecyclerViewTestAdapter(){
            @Override
            protected void onItemClick(View view, ViewRenderType data, int position) {
                super.onItemClick(view, data, position);
            }
        };
        mRecyclerview.setAdapter(mAdapter);
    }
}
