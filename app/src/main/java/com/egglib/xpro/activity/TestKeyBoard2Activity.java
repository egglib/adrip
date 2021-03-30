package com.egglib.xpro.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.egglib.xpro.R;
import com.egglib.xpro.util.SmartKeyboardManager;

public class TestKeyBoard2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private EditText mFaceTextEmotionEditText;

    private ImageView mFaceTextEmotionTrigger;

    private LinearLayout mFaceTextInputLayout;

    private SmartKeyboardManager mSmartKeyboardManager;

    private Button showBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_keyboad_2);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_list);
        mFaceTextEmotionEditText = (EditText) findViewById(R.id.et_face_text_emotion);
        mFaceTextEmotionTrigger = (ImageView) findViewById(R.id.iv_face_text_emotion);
        mFaceTextInputLayout = (LinearLayout) findViewById(R.id.ftil_keyboard);
        showBtn = (Button)findViewById(R.id.btn_show);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new KeyBoardDailog().show(getSupportFragmentManager(), "dialog");
            }
        });

        mSmartKeyboardManager = new SmartKeyboardManager.Builder(this).setContentView(mRecyclerView)
                .setEmotionKeyboard(mFaceTextInputLayout)
                .setEditText(mFaceTextEmotionEditText)
                .setEmotionTrigger(mFaceTextEmotionTrigger)
                .addOnContentViewScrollListener(new SmartKeyboardManager.OnContentViewScrollListener() {
                    @Override
                    public void shouldScroll(int distance) {
                    }
                })
                .create();

    }




    @Override
    public void onBackPressed() {
        if (!mSmartKeyboardManager.interceptBackPressed()) {
            super.onBackPressed();
        }
    }
}
