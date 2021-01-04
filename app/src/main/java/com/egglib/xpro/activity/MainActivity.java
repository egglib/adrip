package com.egglib.xpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.egglib.xpro.db.DaoSession;
import com.egglib.xpro.db.DbOpenHelper;
import com.egglib.xpro.bean.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mNumTv;
    private TextView mQueryBtn;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mNumTv = (TextView) findViewById(R.id.tv_num);
        User user = new User(null, "hello", 10);
        daoSession = DbOpenHelper.getInstance().getSession();
        long num = daoSession.getUserDao().insert(user);
        mNumTv.setText("成功插入" + num + "条");
        mQueryBtn = (TextView) findViewById(R.id.btn_query);
        mQueryBtn.setOnClickListener(this);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestRecyclerViewActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        List<User> userList = daoSession.getUserDao().loadAll();
        for (User user : userList) {
            Log.e("111", "id-->" + user.getId() + ",name==" + user.getName() + ",age==" + user.getAge());
        }
        mNumTv.setText("获取到===" + userList.size());
    }
}
