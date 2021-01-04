package com.egglib.xpro.adapter;


import com.egglib.xpro.list.BaseListViewAdapter;
import com.egglib.xpro.list.VHDelegateImpl;

public class RecyclerViewTestAdapter extends BaseListViewAdapter {

    @Override
    protected VHDelegateImpl createVHDelegate(int viewType) {
        return new TestRecyclerVHDelegateImpl();
    }
}
