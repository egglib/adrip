package com.egglib.xpro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.egglib.xpro.bean.User;
import com.egglib.xpro.db.DaoSession;
import com.egglib.xpro.db.DbOpenHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DaoSession daoSession;
    private TextView mTvSqlData;
    private Button mBtnQuerySql;
    private Button mBtnTestRecyclerview;
    private Button mBtnTestDrawerLayout;
    private Button mBtnTestKeyboard;
    private Button mBtnTestSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
    }

    private void initListener() {
        User user = new User(null, "hello", 20);
        daoSession = DbOpenHelper.getInstance().getSession();
        long num = daoSession.getUserDao().insert(user);
//        mTvSqlData.setText(String.format("数据库有%s条数据", String.valueOf(num)));
        mBtnQuerySql.setOnClickListener(this);
        mBtnTestRecyclerview.setOnClickListener(this);
        mBtnTestDrawerLayout.setOnClickListener(this);
        mBtnTestKeyboard.setOnClickListener(this);
        mBtnTestSum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_query_sql) {
            List<User> userList = daoSession.getUserDao().loadAll();
            StringBuilder stringBuffer = new StringBuilder();
            for (User user : userList) {
                stringBuffer.append("id=").append(user.getId());
                stringBuffer.append(",name=").append(user.getName());
                stringBuffer.append(",age=").append(user.getAge());
                stringBuffer.append("\n");
            }
            mTvSqlData.setText(stringBuffer.toString());
        } else if (v.getId() == R.id.btn_test_recyclerview) {
            startActivity(new Intent(MainActivity.this, TestRecyclerViewActivity.class));
        } else if (v.getId() == R.id.btn_test_drawer_layout) {
            startActivity(new Intent(MainActivity.this, TestDrawerLayout.class));
        } else if (v.getId() == R.id.btn_test_keyboard) {
            startActivity(new Intent(MainActivity.this, TestKeyBoard2Activity.class));
        }else if(v.getId() ==R.id.btn_test_sum){
            startActivity(new Intent(MainActivity.this,TestActivity.class));
        }
    }

    private void initViews() {
        mTvSqlData = findViewById(R.id.tv_sql_data);
        mBtnQuerySql = findViewById(R.id.btn_query_sql);
        mBtnTestRecyclerview = findViewById(R.id.btn_test_recyclerview);
        mBtnTestDrawerLayout = findViewById(R.id.btn_test_drawer_layout);
        mBtnTestKeyboard = findViewById(R.id.btn_test_keyboard);
        mBtnTestSum = findViewById(R.id.btn_test_sum);
    }


    private long exitTime = 0;


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitApp();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            exitTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
        } else {
            System.exit(0);
            //退出app
        }
    }
}
