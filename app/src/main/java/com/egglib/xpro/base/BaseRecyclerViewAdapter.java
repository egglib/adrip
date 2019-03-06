package com.egglib.xpro.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egglib.xpro.R;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
 * File: BaseRecyclerViewAdapter.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/22 6:12 PM
 */
public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private LayoutInflater mLayoutInflater;

    private List<RenderTypeModel> objectList = new ArrayList<>();

    private HashMap<Integer, ItemViewHolderContainer> itemHashMap = new HashMap<>();

    private Context mContext;

    //头部
    private static final int TYPE_HEADER_VIEW = -10000;

    //底部
    private static final int TYPE_FOOTER_VIEW = -20000;

    public ViewHolderItemListener mItemListener;

    public void setOnItemClickListener(ViewHolderItemListener itemListener) {
        mItemListener = itemListener;
    }

    public BaseRecyclerViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void register(int type, ItemViewHolderContainer itemViewHolderContainer) {
        itemHashMap.put(type, itemViewHolderContainer);
    }

    public void registerHeader(ItemViewHolderContainer itemViewHolderContainer) {
        itemHashMap.put(TYPE_HEADER_VIEW, itemViewHolderContainer);
    }

    public void registerFooter(ItemViewHolderContainer itemViewHolderContainer) {
        itemHashMap.put(TYPE_FOOTER_VIEW, itemViewHolderContainer);
    }

    public void addData(List<? extends RenderTypeModel> objects) {
        if (objects != null && !objects.isEmpty()) {
            Set<Integer> typeList = itemHashMap.keySet();
            for (int i = objects.size() - 1; i >= 0; i--) {
                int renderType = objects.get(i).getRenderType();
                if (!typeList.contains(renderType)) {
                    objects.remove(i);
                }
            }
            objectList.addAll(objects);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.layout_recyclerview_empty, viewGroup, false);

        try {
            ItemViewHolderContainer itemViewHolderContainer = itemHashMap.get(viewType);
            if (itemViewHolderContainer != null) {

                int itemViewId = itemViewHolderContainer.getItemViewId();

                if (itemViewId > 0) {
                    view = mLayoutInflater.inflate(itemViewId, viewGroup, false);
                }

                Class<? extends BaseViewHolder> viewHolderClass = itemViewHolderContainer.getViewHolder();

                if (viewHolderClass != null) {
                    Constructor constructor = viewHolderClass.getConstructor(Context.class, BaseRecyclerViewAdapter.class, View.class);

                    Object object = constructor.newInstance(mContext, this, view);

                    return viewHolderClass.cast(object);
                } else {
                    return new BaseViewHolder(mContext, this, view);
                }
            } else {
                return new BaseViewHolder(mContext, this, view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseViewHolder(mContext, this, view);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int position) {
        viewHolder.renderView(objectList, position);
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return objectList.get(position).getRenderType();
    }

}
