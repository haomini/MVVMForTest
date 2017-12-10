package com.example.common.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;

import com.example.common.R;
import com.example.common.databinding.BaseListLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public abstract class BaseListFragment<LVM extends BaseListViewModel, T extends Object> extends BaseFragment<ViewDataBinding, LVM> {

    @Override
    protected int getLayoutId() {
        return R.layout.base_list_layout;
    }

    @Override
    protected void initView() {
        super.initView();
        ((BaseListLayoutBinding) mViewBindings).recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        ((BaseListLayoutBinding) mViewBindings).setListVM(getVM());
    }

}
