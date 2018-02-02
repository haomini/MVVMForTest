package com.example.zhiyicx.testdagger2._test._translation_anim;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.ImageView;

import com.example.zhiyicx.testdagger2.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/1/22
 * @Contact 605626708@qq.com
 */

public class SmallImgActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.small_img);

        ImageView img = findViewById(R.id.small_img);
        img.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // 单个共享的View
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SmallImgActivity.this, img, "translationName");

                startActivity(new Intent(SmallImgActivity.this, BigImgActivity.class), options.toBundle());
            }
        });
    }
}
