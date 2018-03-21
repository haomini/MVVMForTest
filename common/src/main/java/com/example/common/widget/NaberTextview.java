package com.example.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * @Describe 让文字和drawableLeft靠在一起居中吧
 * @Author zhouhao
 * @Date 2017/11/14
 * @Contact 605626708@qq.com
 */

public class NaberTextview extends AppCompatTextView {
    public NaberTextview(Context context) {
        super(context);
    }

    public NaberTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NaberTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        int bodyWidth = 0;
        if (drawables[0] != null) {
            Drawable drawableLeft = drawables[0];
            bodyWidth = getCompoundDrawablePadding() + drawableLeft.getIntrinsicWidth();
        }
        float textWidth = getPaint().measureText(getText().toString());
        bodyWidth += textWidth;
        canvas.translate((getWidth() - bodyWidth) / 2, 0);
        super.onDraw(canvas);
    }
}
