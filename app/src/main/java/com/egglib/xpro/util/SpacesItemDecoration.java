package com.egglib.xpro.util;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

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
