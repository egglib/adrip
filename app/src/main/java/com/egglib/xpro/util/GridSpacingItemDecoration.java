package  com.qmxs.qianmonr.util;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * <p>
 * 九宫格的间隔处理类
 */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 每行的个数
     */
    private int numPerRow;

    /**
     * 间距
     */
    private int spacing;

    /**
     * 是否包括边界
     */
    private boolean isIncludeEdge;

    /**
     * 偏移量
     */
    private int mOffSet;

    /**
     * 是否显示上边距
     */
    private boolean mIsShowTopEdge = true;

    private boolean mIsShowBottomEdge = true;

    public GridSpacingItemDecoration(int numPerRow, int spacing, boolean isIncludeEdge, boolean isShowTopEdge, boolean isShowBottomEdge) {
        this(0, numPerRow, spacing, isIncludeEdge, isShowTopEdge, isShowBottomEdge);
    }

    public GridSpacingItemDecoration(int offset, int numPerRow, int spacing, boolean isIncludeEdge, boolean isShowTopEdge, boolean isShowBottomEdge) {
        this.numPerRow = numPerRow;
        this.spacing = spacing;
        this.isIncludeEdge = isIncludeEdge;
        mOffSet = offset;
        mIsShowTopEdge = isShowTopEdge;
        mIsShowBottomEdge = isShowBottomEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int count = parent.getChildCount();//总个数

        if (position - mOffSet < 0) {
            return;
        } else {
            position = position - mOffSet;
        }

        //列数
        int column = position % numPerRow;

        if (isIncludeEdge) {

            outRect.left = spacing - column * spacing / numPerRow; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / numPerRow; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < numPerRow && mIsShowTopEdge) { // top edge
                outRect.top = spacing;
            }

            if (mIsShowBottomEdge) {
                outRect.bottom = spacing; // item bottom
            } else {
                if (count - position <= numPerRow) {
                    outRect.bottom = 0; // item bottom
                } else {
                    outRect.bottom = spacing; // item bottom
                }
            }

        } else {
            outRect.left = column * spacing / numPerRow; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / numPerRow; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= numPerRow && mIsShowTopEdge) {
                outRect.top = spacing; // item top
            }
        }
    }
}
