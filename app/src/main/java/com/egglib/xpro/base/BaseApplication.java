package com.egglib.xpro.base;

import android.app.Application;

import androidx.annotation.Nullable;

import com.egglib.xpro.BuildConfig;
import com.egglib.xpro.config.Global;
import com.egglib.xpro.db.DbOpenHelper;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.qmxs.qianmonr.util.ScreenUtil;
import com.squareup.leakcanary.LeakCanary;

public class BaseApplication extends Application {

    private static BaseApplication mInstance;

    public static BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (mInstance == null) {
            mInstance = this;
        }
        ScreenUtil.initScreenInfo(this);
//        initLeakCanary();
        initLog();
        getStatusHeight();
        DbOpenHelper.getInstance();
    }

    private void getStatusHeight() {
        int height = 0;
        int resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = this.getResources().getDimensionPixelSize(resourceId);
        }
        Global.STUTAS_BAR_HEIGHT = height;
    }

    private void initLog() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
