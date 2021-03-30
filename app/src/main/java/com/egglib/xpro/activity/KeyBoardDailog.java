package com.egglib.xpro.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.egglib.xpro.R;
import com.egglib.xpro.util.SmartKeyboardManager;

public class KeyBoardDailog extends DialogFragment {

    private View mContentView;

    private EditText mFaceTextEmotionEditText;

    private ImageView mFaceTextEmotionTrigger;

    private LinearLayout mFaceTextInputLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_keyboard, getDialog().getWindow().findViewById(Window.ID_ANDROID_CONTENT), false);
        mContentView = (View) view.findViewById(R.id.contentView);
        mFaceTextEmotionEditText = (EditText) view.findViewById(R.id.et_face_text_emotion);
        mFaceTextEmotionTrigger = (ImageView) view.findViewById(R.id.iv_face_text_emotion);
        mFaceTextInputLayout = (LinearLayout) view.findViewById(R.id.ftil_keyboard);

        SmartKeyboardManager mSmartKeyboardManager = new SmartKeyboardManager.Builder(getActivity()).setContentView(mContentView)
                .setEmotionKeyboard(mFaceTextInputLayout)
                .setEditText(mFaceTextEmotionEditText)
                .setEmotionTrigger(mFaceTextEmotionTrigger)
                .create();
        initDialog();
        return view;

    }


    private void initDialog() {
        final Dialog dialog = getDialog();
        final Window window = dialog.getWindow();
        final WindowManager.LayoutParams attributes = window.getAttributes();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        attributes.gravity = Gravity.BOTTOM;
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        window.setAttributes(attributes);
    }
}
