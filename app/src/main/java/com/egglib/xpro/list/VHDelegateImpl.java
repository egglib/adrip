package com.egglib.xpro.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class VHDelegateImpl<T> implements VHDelegate<T> {

    protected abstract int getItemLayoutId();

    private Context context;

    private View view;

    private T mItem;

    private int mPosition;

    @Override
    public View createItemView(ViewGroup parent) {
        try {
            context = parent.getContext();
            view = LayoutInflater.from(context).inflate(getItemLayoutId(), parent, false);
            return view;
        } catch (Exception e) {
            return null;
        }
    }

    public T getCurItemBean() {
        return mItem;
    }

    public int getCurPosition(){
        return mPosition;
    }

    @Override
    public void onBindVH(T item, int position) {
        mItem = item;
        mPosition = position;
    }

    protected void onItemClick(View view, T item, int position) {
    }

    protected void onItemLongClick(View view, T item, int position) {
    }


    protected Context getContext() {
        return context;
    }

    protected View getItemView() {
        return view;
    }

}
