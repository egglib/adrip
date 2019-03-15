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
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int mLeft;
    private int mRight;
    private int mTop;
    private int mBottom;

    public SpacesItemDecoration(int space) {
        this(space, space);
    }

    public SpacesItemDecoration(int leftRight, int topBottom) {
        this(leftRight, leftRight, topBottom, topBottom);
    }

    public SpacesItemDecoration(int left, int right, int top, int bottom) {
        mLeft = left;
        mRight = right;
        mTop = top;
        mBottom = bottom;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int orientation = layoutManager != null ? layoutManager.getOrientation() : LinearLayoutManager.VERTICAL;

        if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.left = mLeft;
            outRect.right = mRight;
            outRect.bottom = mBottom;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = mTop;
            } else {
                outRect.top = 0;
            }
        } else {
            outRect.top = mTop;
            outRect.right = mRight;
            outRect.bottom = mBottom;
            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.left = mLeft;
            } else {
                outRect.left = 0;
            }
        }
    }

}
