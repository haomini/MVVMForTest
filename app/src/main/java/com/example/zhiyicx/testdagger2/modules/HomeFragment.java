package com.example.zhiyicx.testdagger2.modules;

import com.example.common.base.BaseListFragment;
import com.example.zhiyicx.testdagger2.bean.ApkBean;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class HomeFragment extends BaseListFragment<HomeViewModel, ApkBean> {

    @Override
    protected HomeViewModel getVM() {
        return new HomeViewModel(getContext());
    }

    @Override
    protected String getTitleLeft() {
        return "SystemAPP";
    }

    @Override
    protected boolean needLeftIcon() {
        return false;
    }
}
