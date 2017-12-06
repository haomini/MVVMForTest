package com.example.zhiyicx.testdagger2;

import com.example.common.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/29
 * @Contact 605626708@qq.com
 */

public class Main2Activity extends BaseActivity<MainFragment> {

    @Override
    protected void component() {

    }

    @Override
    protected MainFragment bindingFragments() {
        return new MainFragment();
    }
}
