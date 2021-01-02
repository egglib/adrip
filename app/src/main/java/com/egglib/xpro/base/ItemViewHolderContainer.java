package com.egglib.xpro.base;


public class ItemViewHolderContainer {

    private int mItemViewId;

    private Class<? extends BaseViewHolder> mViewHolder;

    public ItemViewHolderContainer(int itemViewId, Class<? extends BaseViewHolder> viewHolder) {
        mItemViewId = itemViewId;
        mViewHolder = viewHolder;
    }

    public Class<? extends BaseViewHolder> getViewHolder() {
        return mViewHolder;
    }

    public int getItemViewId() {
        return mItemViewId;
    }
}
