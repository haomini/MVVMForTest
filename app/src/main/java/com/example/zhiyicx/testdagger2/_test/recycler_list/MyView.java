package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/26
 * @Contact 605626708@qq.com
 */

public class MyView extends View {

    private int angle = 45;
    private int roundingRadius = 20;
    private Result result;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(100, 100);

        result = new Result(150, 150);
        Path path = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(0xffff0000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);

        float tiWidth = (float) (result.getHeight() / Math.tan(Math.toRadians(angle)));
        RectF leftTopRectF = new RectF(tiWidth - roundingRadius * 2, 0, tiWidth, roundingRadius * 2);
        path.arcTo(leftTopRectF, 270 - angle, angle);

        path.lineTo(result.getWidth() - roundingRadius, 0);

        RectF rightTopRectF = new RectF(result.getWidth() - roundingRadius * 2, 0, result.getWidth(), roundingRadius * 2);
        path.arcTo(rightTopRectF, -90, 90);

        path.lineTo(result.getWidth(), result.getHeight() - roundingRadius);

        RectF rightBottomRectF = new RectF(result.getWidth() - roundingRadius * 2, result.getHeight() - roundingRadius * 2, result.getWidth(), result.getHeight());
        path.arcTo(rightBottomRectF, 0, 90);

        RectF leftBottomRectF = new RectF(0, result.getHeight() - roundingRadius * 2, roundingRadius * 2, result.getHeight());
        path.arcTo(leftBottomRectF, 90, 180 - angle);

        path.close();

        canvas.drawPath(path, paint);

    }

    class Result{
        private int mWidth, mHeight;

        public Result(int width, int height) {
            mWidth = width;
            mHeight = height;
        }

        public int getWidth() {
            return mWidth;
        }

        public int getHeight() {
            return mHeight;
        }
    }
}
