package com.example.zhiyicx.testdagger2.ui.test_list;

import com.example.common.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/2/9
 * @Contact 605626708@qq.com
 */

public class TestListActivity extends BaseActivity<TestListFragment> {

    @Override
    protected TestListFragment bindingFragments() {
        return new TestListFragment();
    }
}
