package com.egglib.xpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.egglib.xpro.bean.User;
import com.egglib.xpro.db.DaoSession;
import com.egglib.xpro.db.DbOpenHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DaoSession daoSession;
    private TextView mTvNum;
    private Button mBtnQuery;
    private Button mBtnTest;
    private Button mBtnDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initView();
    }

    private void initView() {
        mTvNum = (TextView) findViewById(R.id.tv_num);
        User user = new User(null, "hello", 10);
        daoSession = DbOpenHelper.getInstance().getSession();
        long num = daoSession.getUserDao().insert(user);
        mTvNum.setText("成功插入" + num + "条");
        mBtnQuery = (Button) findViewById(R.id.btn_query);
        mBtnQuery.setOnClickListener(this);

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestRecyclerViewActivity.class));
            }
        });

        mBtnDrawerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestDrawerLayout.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        List<User> userList = daoSession.getUserDao().loadAll();
        for (User user : userList) {
            Log.e("111", "id-->" + user.getId() + ",name==" + user.getName() + ",age==" + user.getAge());
        }
        mTvNum.setText("获取到===" + userList.size());
    }

    private void initViews() {
        mTvNum = findViewById(R.id.tv_num);
        mBtnQuery = findViewById(R.id.btn_query);
        mBtnTest = findViewById(R.id.btn_test);
        mBtnDrawerLayout = findViewById(R.id.btn_drawer_layout);
    }
}
