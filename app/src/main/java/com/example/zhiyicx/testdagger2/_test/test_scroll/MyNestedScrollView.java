package com.example.zhiyicx.testdagger2._test.test_scroll;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/30
 * @Contact 605626708@qq.com
 */

public class MyNestedScrollView extends NestedScrollView {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public MyNestedScrollView(@NonNull Context context) {
        super(context);
        setOnScrollChangeListener((View.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {

        });
    }
}
