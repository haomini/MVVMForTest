package com.example.common.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public class EmptyLayout extends FrameLayout {
    public EmptyLayout(@NonNull Context context) {
        this(context, null);
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
