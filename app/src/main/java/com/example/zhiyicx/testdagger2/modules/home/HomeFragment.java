package com.example.zhiyicx.testdagger2.modules.home;

import android.support.v7.widget.LinearLayoutManager;

import com.example.common.base.BaseListFragment;
import com.example.common.base.BaseListViewModel;
import com.example.zhiyicx.testdagger2.bean.ApkBean;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class HomeFragment extends BaseListFragment<ApkBean> {

    @Override
    protected String getTitleLeft() {
        return "SystemAPP";
    }

    @Override
    protected boolean needLeftIcon() {
        return false;
    }

    @Override
    protected void initView() {
        mListLayoutBinding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected BaseListViewModel<ApkBean> getListViewModel() {
        return new HomeViewModel(getContext());
    }
}
