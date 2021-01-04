package com.egglib.xpro.list;

import android.view.View;
import android.view.ViewGroup;

public interface VHDelegate<T> {

    View createItemView(ViewGroup parent);

    void initView(View itemView);

    void onBindVH(T item, int position);
}
