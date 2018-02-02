package com.example.zhiyicx.testdagger2._test._nes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.databinding.ActivityWebLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/29
 * @Contact 605626708@qq.com
 */

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWebLayoutBinding mbinding = DataBindingUtil.setContentView(this,
                R.layout.activity_web_layout);


        mbinding.smart.setEnableLoadmore(false);
        mbinding.vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return RecyclerFragment.newInstance(position == 2);
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "看一看";
            }
        });
        mbinding.tabs.setupWithViewPager(mbinding.vp);
    }
}
