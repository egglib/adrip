package com.egglib.xpro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egglib.xpro.R;
import com.egglib.xpro.bean.TestRecyclerViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通RecyclerView Adapter使用
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.TestViewHolder> {

    private List<TestRecyclerViewBean> mTestBeans = new ArrayList<>();

    public TestRecyclerViewAdapter(List<TestRecyclerViewBean> testBeans) {
        mTestBeans.addAll(testBeans);
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_test, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        holder.onBindViewHolder(mTestBeans.get(position), position);
    }


    @Override
    public int getItemCount() {
        return mTestBeans.size();
    }


    class TestViewHolder extends RecyclerView.ViewHolder {

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView textView = itemView.findViewById(R.id.tv_title);
            textView.setText("代码对比代码");
        }

        public void onBindViewHolder(TestRecyclerViewBean bean, int position) {

        }
    }
}
