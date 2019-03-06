package com.egglib.xpro.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/*
 * File: BaseViewHolder.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/22 7:00 PM
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    protected Context mContext;
    protected View mItemView;

    public BaseViewHolder(Context context, BaseRecyclerViewAdapter adapter, @NonNull View itemView) {
        super(itemView);
        mContext = context;
        mItemView = itemView;
        itemView.setOnClickListener(v -> {
            if (adapter != null && adapter.mItemListener != null) {
                adapter.mItemListener.onItemClick(v);
            }
        });
    }

    public void renderView(List<? extends RenderTypeModel> objectList, int position) {

    }
}
