package com.example.common.base;

import com.example.common.R;
import com.example.common.bean.BaseBean;
import com.example.common.databinding.BaseListLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public abstract class BaseListFragment<T extends BaseBean> extends BaseFragment<BaseListLayoutBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.base_list_layout;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initDataBindings() {
        mViewBindings.setListVM(getListViewModel());
    }

    protected abstract BaseListViewModel<T> getListViewModel();
}
