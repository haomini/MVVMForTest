package com.example.zhiyicx.testdagger2.modules.detail;

import com.example.common.base.BaseActivity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/10
 * @Contact 605626708@qq.com
 */

public class ApkDetailActivity extends BaseActivity<ApkDetailFragment> {

    @Override
    protected ApkDetailFragment bindingFragments() {
        return new ApkDetailFragment();
    }
}
