package com.egglib.xpro.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.egglib.xpro.R;
import com.egglib.xpro.util.CommonUtils;
import com.egglib.xpro.util.HintPopupWindow;
import com.egglib.xpro.util.KeyBoardLayout;
import com.egglib.xpro.util.KeyboardUtils;

public class TestKeyboard1Activity extends AppCompatActivity implements KeyBoardLayout.KeyBoardListener {
    private static final String TAG = "MainActivity";

    private KeyBoardLayout keyBoardLayout;
    private HintPopupWindow hintPopupWindow;
    private EditText editText;
    private ScrollView scrollView;
    private boolean isSoftActive;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_keyboard_1);
        keyBoardLayout = (KeyBoardLayout) findViewById(R.id.key_board_layout);
        keyBoardLayout.setOnKeyBoardShow(this);
        editText = (EditText) findViewById(R.id.comment_edit_text);
        hintPopupWindow = new HintPopupWindow(editText);
        scrollView = (ScrollView) findViewById(R.id.content_scroll_view);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN && !isSoftActive) {
                    scrollView.scrollTo(0, editText.getBottom());
                }
                return false;
            }
        });

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            private int mLastX;
            private int mLastY;
            private int mTouchSlop = ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop();
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getRawX(), y = (int) event.getRawY();
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        mLastX = x;
                        mLastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs(mLastY - y) > mTouchSlop && isSoftActive) {
                            KeyboardUtils.hideSoftInputFromWindow(editText);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }

    public void onKeyBoardShow(final int keyBoardHeight) {
        Log.d(TAG, "onKeyBoardShow(): keyBoardHeight = " + keyBoardHeight);
        final int hintTop = CommonUtils.getScreenHeight() - keyBoardHeight - hintPopupWindow.getHeight();
        hintPopupWindow.setKeyboardHeight(keyBoardHeight);
        hintPopupWindow.show(getWindow().getDecorView(), 0, hintTop);
    }

    @Override
    public void onKeyBoardEvent(boolean active, int keyBoardHeight) {
        isSoftActive = active;
        if (active) {
            onKeyBoardShow(keyBoardHeight);
        } else {
            onKeyBoardHide(keyBoardHeight);
        }
    }

    private void onKeyBoardHide(int keyBoardHeight) {
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                hintPopupWindow.hide();
            }
        }, 100);
    }

    @Override
    public void onBackPressed() {
        if (hintPopupWindow.isVisible()) {
            hintPopupWindow.hide();
            if (!isSoftActive) return;
        }
        super.onBackPressed();
    }
}
