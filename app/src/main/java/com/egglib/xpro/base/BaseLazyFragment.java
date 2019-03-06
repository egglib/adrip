package com.egglib.xpro.base;

import android.view.View;

/*
 * File: BaseLazyFragment.java
 * Description:
 * Author: XiaoTao
 * Create at 2019/2/19 6:42 PM
 */
public abstract class BaseLazyFragment extends BaseFragment {

    private boolean isPrepared = false;

    private boolean isLazyLoaded = false;

    public boolean isInit = false;//视图是否已经初始化

    public boolean isLoad = false;//视图是否已经加载过

    @Override
    protected void initView(View view) {
        super.initView(view);
        isInit = true;
        isCanLoadData();
    }

    /**
     * 判断是否可以加载数据, 如果可以便进行数据的加载
     */
    protected void isCanLoadData() {
        if (!isInit) {//未初始化
            return;
        }

        if (getUserVisibleHint()) {//用户可见
            onLazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {//用户不可见, 且已经加载过
                stopLoad();
            }
        }
    }


    /**
     * 当该视图对用户不可见并且已经加载过数据的时候, 如果需要在切换到其他页面时停止加载数据, 通过覆写此方法实现
     */
    public void stopLoad() {
    }

    //当前Fragment可见时，setUserVisibleHint()回调，其中isVisibleToUser=true；
    // 当前Fragment由可见到不可见或实例化时，setUserVisibleHint()回调，其中isVisibleToUser=false
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    /**
     * 当视图初始化并且对可见时加载数据
     */
    protected abstract void onLazyLoad();

    /**
     * 视图销毁时将Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

}
