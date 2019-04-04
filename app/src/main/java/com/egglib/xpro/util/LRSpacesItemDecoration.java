package com.qmxs.qianmonr.util;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/*
 * File: SpacesItemDecoration.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/28 12:49 PM
 */
public class LRSpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int mLeft;
    private int mRight;
    private int mCount;

    public LRSpacesItemDecoration(int count, int left, int right) {
        mLeft = left;
        mRight = right;
        mCount = count;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int orientation = layoutManager != null ? layoutManager.getOrientation() : LinearLayoutManager.VERTICAL;

        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.top = 0;
            outRect.bottom = 0;
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.left = mLeft;
            } else {
                outRect.left = 0;
            }

            if (parent.getChildAdapterPosition(view) == mCount - 1) {
                outRect.right = mRight;
            } else {
                outRect.right = 0;
            }
        }
    }

}