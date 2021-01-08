package com.egglib.xpro.adapter;

import android.view.View;

import com.egglib.xpro.R;
import com.egglib.xpro.list.VHDelegateImpl;

public class TestRecyclerVHDelegateImpl extends VHDelegateImpl {
    @Override
    protected int getItemLayoutId() {
        return R.layout.item_test_recyclerview;
    }

    @Override
    public void initView(View itemView) {

    }
}
