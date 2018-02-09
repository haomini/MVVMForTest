package com.example.zhiyicx.testdagger2._test._test_wheel_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.zhiyicx.testdagger2.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/2/6
 * @Contact 605626708@qq.com
 */

public class TestWheelActivity extends RxAppCompatActivity {
    private View cons;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_wheel);
        cons = findViewById(R.id.cons);
    }

    public void scrollTo(View view){
        cons.scrollTo(-60, 60);
    }

    public void scrollBy(View view){
        cons.scrollBy(-60, 60);
    }
}
