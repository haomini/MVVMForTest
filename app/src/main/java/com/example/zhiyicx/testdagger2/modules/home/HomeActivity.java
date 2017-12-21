package com.example.zhiyicx.testdagger2.modules.home;

import com.example.common.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class HomeActivity extends BaseActivity<HomeFragment> {

    @Override
    protected HomeFragment bindingFragments() {
        return new HomeFragment();
    }
}
