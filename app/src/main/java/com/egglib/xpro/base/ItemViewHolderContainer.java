package com.egglib.xpro.base;


/*
 * File: ItemViewHolderContainer.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/22 7:49 PM
 */
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
