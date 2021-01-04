package com.egglib.xpro.list;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class BaseListViewHolder<T> extends RecyclerView.ViewHolder {

    private VHDelegateImpl<T> vhDelegateImpl;

    public BaseListViewHolder(@NonNull View itemView, VHDelegateImpl<T> vhDelegateImpl) {
        super(itemView);
        try {
            this.vhDelegateImpl = vhDelegateImpl;
            this.vhDelegateImpl.initView(itemView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VHDelegateImpl<T> getVhDelegateImpl() {
        return vhDelegateImpl;
    }
}
