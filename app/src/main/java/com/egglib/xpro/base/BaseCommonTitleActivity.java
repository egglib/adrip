package com.egglib.xpro.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.egglib.xpro.R;
import com.egglib.xpro.config.Global;

public abstract class BaseCommonTitleActivity extends BaseActivity {

    protected static final int TYPE_LAYOUT_LINEAR = 0;
    protected static final int TYPE_LAYOUT_FRAME = 1;
    protected View mTopView;
    protected LinearLayout mLeftLayout;
    protected TextView mTitleTv;
    protected LinearLayout mRightLayout;
    protected FrameLayout mTitleLayout;
    private FrameLayout mContainerMain;
    private LinearLayout mTitleContainer;

    @Override
    protected int getLayoutResId() {
        if (getLayoutType() == TYPE_LAYOUT_FRAME) {
            return R.layout.activity_framelayout_base;
        }
        return R.layout.activity_linearlayout_base;
    }

    protected int getLayoutType() {
        return TYPE_LAYOUT_LINEAR;
    }


    private void initBaseView() {
        mTitleContainer = findViewById(R.id.title_container);
        mTopView = findViewById(R.id.topView);
        mContainerMain = findViewById(R.id.main_container);
        mLeftLayout = findViewById(R.id.layout_left);
        mRightLayout = findViewById(R.id.layout_right);

        mTitleTv = findViewById(R.id.tv_title);
        mTitleLayout = findViewById(R.id.layout_title);

        handleTitleView();
        setTitleStr(getTitleText());
        handleMainContainer();
    }

    protected String getTitleText() {
        return "";
    }

    protected void handleTitleView() {
        handleTitleContainer();
        handleTopView();
    }

    private void handleTitleContainer() {
        if (isShowTitle()) {
            mTitleContainer.setVisibility(View.VISIBLE);
            mTitleContainer.setBackgroundColor(getResources().getColor(getTitleBackgroundColor()));
            if (isShowBackIcon()) {
                addLeftBackIcon();
            }
        } else {
            mTitleContainer.setVisibility(View.GONE);
        }
    }

    protected int getTitleBackgroundColor() {
        return R.color.color_f6;
    }

    private void addLeftBackIcon() {
        View view = createActionBarIcon(mLeftLayout, getBackIcon());
        view.setOnClickListener(v -> onBackPressed());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected int getBackIcon() {
        return R.mipmap.ic_back;
    }

    /**
     * @param root
     * @param resImageId
     * @return
     */
    protected View createActionBarIcon(ViewGroup root, int resImageId) {
        View view = getLayoutInflater().inflate(R.layout.common_title_img_item, root);
        ImageView imageView = view.findViewById(R.id.imgView);
        imageView.setImageResource(resImageId);
        return view;
    }


    protected View createActionBarRightText(String textStr) {
        return createActionBarText(mRightLayout, textStr);
    }

    protected View createActionBarRightIcon(int resImageId) {
        return createActionBarIcon(mRightLayout, resImageId);
    }

    /**
     * @param root
     * @param textStr
     * @return
     */
    protected View createActionBarText(ViewGroup root, String textStr) {
        View view = getLayoutInflater().inflate(R.layout.common_title_text_item, root);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(textStr);
        return view;
    }

    private boolean isShowBackIcon() {
        return true;
    }

    /**
     * 设置是否显示title
     *
     * @return
     */
    public boolean isShowTitle() {
        return true;
    }

    protected void handleTopView() {
        mTopView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Global.STUTAS_BAR_HEIGHT));
    }

    protected void handleMainContainer() {
        mContainerMain.setBackgroundColor(getResources().getColor(setMainContainerBackgroundColor()));
        getLayoutInflater().inflate(getLayoutRes(), mContainerMain);
    }

    private int setMainContainerBackgroundColor() {
        return R.color.color_f6;
    }

    /**
     * 设置布局文件
     *
     * @return
     */
    protected abstract int getLayoutRes();


    /**
     * 设置标题栏文字
     *
     * @param title
     */
    private void setTitleStr(String title) {
        this.setTitleStrAndColor(title, getResources().getColor(getTitleTextColor()));
    }

    private void setTitleStrAndColor(String title, int color) {
        mTitleTv.setText(title);
        mTitleTv.setTextColor(color);
    }

    protected int getTitleTextColor() {
        return R.color.color_48;
    }
}
