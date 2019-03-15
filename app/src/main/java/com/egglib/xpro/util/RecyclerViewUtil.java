package com.qmxs.qianmonr.util;


import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView 工具类
 * <p>
 */
public class RecyclerViewUtil {

    /**
     * 获取RecyclerView
     *
     * @param layoutManager
     * @param animator
     * @param hasFixedSize
     * @return
     */
    public static RecyclerView getRecyclerView(RecyclerView mRecyclerView, RecyclerView.LayoutManager layoutManager,
                                               RecyclerView.ItemAnimator animator, boolean hasFixedSize) {
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(animator);
        mRecyclerView.setHasFixedSize(hasFixedSize);
        return mRecyclerView;
    }

}
