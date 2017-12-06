package com.example.common.base;

import android.databinding.ViewDataBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public class BaseListFragment<DB extends ViewDataBinding> extends BaseFragment<DB> {

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
