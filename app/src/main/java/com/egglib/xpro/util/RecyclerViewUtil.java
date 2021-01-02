package com.egglib.xpro.util;


import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewUtil {

    public static RecyclerView getRecyclerView(RecyclerView mRecyclerView, RecyclerView.LayoutManager layoutManager,
                                               RecyclerView.ItemAnimator animator, boolean hasFixedSize) {
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(animator);
        mRecyclerView.setHasFixedSize(hasFixedSize);
        return mRecyclerView;
    }

}
