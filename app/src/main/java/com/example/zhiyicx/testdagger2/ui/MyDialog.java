package com.example.zhiyicx.testdagger2.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhiyicx.testdagger2.R;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/1
 * @Contact 605626708@qq.com
 */

public class MyDialog extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(DialogFragment.STYLE_NORMAL, R.style.Mdialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_circle));
        linearLayout.setPadding(20, 20, 20, 20);
        TextView textView = new TextView(getContext());
        textView.setText("kankan");
//        textView.setPadding(20, 10, 20, 10);
        textView.setBackgroundColor(Color.WHITE);
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attr = getDialog().getWindow().getAttributes();
        attr.dimAmount = 0.0f;
        attr.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        getDialog().getWindow().setAttributes(attr);

//        getView().
//        ViewCompat.setElevation(getView(), 8);
    }
}
