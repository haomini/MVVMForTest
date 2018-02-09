package com.example.common.widget.group;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/2/9
 * @Contact 605626708@qq.com
 */

public class MyGroup extends LinearLayout {

    private Scroller mScroller;
    private boolean s1;

    public MyGroup(Context context) {
        this(context, null);
    }

    public MyGroup(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate();
        }
    }
    public void beginScroll(){
        if (!s1) {
            mScroller.startScroll(0, 0, 0, 0, 1000);
            s1 = true;
        } else {
            mScroller.startScroll(0, 0, -500, 0, 1000);
            s1 = false;
        }
        invalidate();
    }
}
