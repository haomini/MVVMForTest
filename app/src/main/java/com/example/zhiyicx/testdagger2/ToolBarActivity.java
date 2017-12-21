package com.example.zhiyicx.testdagger2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhiyicx.testdagger2.databinding.ActivityWithToolbarBinding;
import com.example.zhiyicx.testdagger2.service.DoenloadService;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/20
 * @Contact 605626708@qq.com
 */

public class ToolBarActivity extends AppCompatActivity {

    private ActivityWithToolbarBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_with_toolbar);
        setSupportActionBar(mBinding.toolbar);

        mBinding.toolbar.setNavigationOnClickListener((View v) -> finish());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        startService(new Intent(this, DoenloadService.class));
    }
}
