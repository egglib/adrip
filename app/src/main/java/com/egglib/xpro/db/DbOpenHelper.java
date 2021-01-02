package com.egglib.xpro.db;

import android.database.sqlite.SQLiteDatabase;

import com.egglib.xpro.base.BaseApplication;

public class DbOpenHelper {

    private static final String DB_NAME = "TEST_DB";

    private SQLiteDatabase mSqLiteDatabase;

    private DaoMaster mDaoMaster;

    private DaoSession mSession;

    private static volatile DbOpenHelper mInstance;

    private DbOpenHelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getInstance(), DB_NAME, null);
        mSqLiteDatabase = devOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(mSqLiteDatabase);
        mSession = mDaoMaster.newSession();
    }

    public static DbOpenHelper getInstance() {
        if (mInstance == null) {
            synchronized (DbOpenHelper.class) {
                if (mInstance == null) {
                    mInstance = new DbOpenHelper();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mSession;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return mSqLiteDatabase;
    }
}
