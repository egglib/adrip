package com.egglib.xpro.list;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseListViewAdapter<T extends ViewRenderType> extends RecyclerView.Adapter<BaseListViewHolder<T>> {

    protected abstract VHDelegateImpl<T> createVHDelegate(int viewType);

    private List<T> mList = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        try {
            return mList.get(position).getViewRenderType();
        } catch (Exception e) {
            return -1;
        }
    }

    @NonNull
    @Override
    public BaseListViewHolder<T> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        try {
            VHDelegateImpl<T> vhDelegateImpl = createVHDelegate(viewType);
            View view = vhDelegateImpl.createItemView(viewGroup);
            return new BaseListViewHolder<>(view, vhDelegateImpl);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseListViewHolder<T> viewHolder, int position) {
        VHDelegateImpl<T> vhDelegateImpl = viewHolder.getVhDelegateImpl();
        T item = getItem(position);
        vhDelegateImpl.onBindVH(item, position);

        viewHolder.itemView.setOnClickListener(v -> {
            onItemClick(v, getItem(position), position);
            vhDelegateImpl.onItemClick(v, getItem(position), position);
        });
        viewHolder.itemView.setOnLongClickListener(v -> {
            onItemLongClick(v, getItem(position), position);
            vhDelegateImpl.onItemLongClick(v, getItem(position), position);
            return false;
        });
    }


    public T getItem(int position) {
        try {
            int size = mList.size();
            return position < size ? mList.get(position) : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getItemCount() {
        try {
            return mList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void addItems(List<T> list) {
        try {
            int start = mList != null && !mList.isEmpty() ? mList.size() - 1 : 0;
            int count = list != null && !list.isEmpty() ? list.size() : 0;
            if (mList == null)
                mList = new ArrayList<>();
            if (count > 0) {
                mList.addAll(list);
                notifyItemRangeChanged(start, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addItems(int index, List<T> list) {
        try {
            int count = list != null && !list.isEmpty() ? list.size() : 0;
            if (mList == null)
                mList = new ArrayList<>();
            if (count > 0) {
                mList.addAll(index, list);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItemsNotifyAll(List<T> list) {
        try {
            int count = list != null && !list.isEmpty() ? list.size() : 0;
            if (mList == null)
                mList = new ArrayList<>();
            if (count > 0) {
                mList.addAll(list);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeItem(T item) {
        if (!mList.isEmpty())
            mList.remove(item);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        if (!mList.isEmpty() && position < mList.size())
            mList.remove(position);
        notifyDataSetChanged();
    }

    public void removeItems(List<T> list) {
        if (mList != null && !mList.isEmpty()) {
            mList.removeAll(list);
            notifyDataSetChanged();
        }
    }

    public void addItem(T value) {
        if (mList != null) {
            mList.add(value);
            notifyDataSetChanged();
        }
    }


    public void setItem(int index, T value) {
        try {
            if (mList != null) {
                mList.set(index, value);
                notifyItemChanged(index);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setItemWithoutNotify(int index, T value) {
        try {
            if (mList != null) {
                mList.set(index, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItem(int index, T value) {
        try {
            if (mList != null) {
                mList.add(index, value);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<T> getItems() {
        return mList;
    }

    public void refreshAddItems(List<T> list) {
        try {
            if (mList != null && !mList.isEmpty()) {
                mList.clear();
            }
            int count = list != null && !list.isEmpty() ? list.size() : 0;
            if (mList == null)
                mList = new ArrayList<>();
            if (count > 0) {
                mList.addAll(list);
                notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshClearItems() {
        if (mList != null && !mList.isEmpty()) {
            mList.clear();
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (mList != null && !mList.isEmpty()) {
            mList.clear();
            notifyDataSetChanged();
        }
    }

    public void clearItems() {
        if (mList != null && !mList.isEmpty()) {
            mList.clear();
        }
    }


    protected void onItemClick(View view, T data, int position) {

    }

    protected void onItemLongClick(View view, T data, int position) {

    }

}
