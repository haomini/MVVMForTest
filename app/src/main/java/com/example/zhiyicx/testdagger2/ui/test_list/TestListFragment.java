package com.example.zhiyicx.testdagger2.ui.test_list;

import com.example.common.base.BaseListFragment;
import com.example.common.databinding.BaseListLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/2/9
 * @Contact 605626708@qq.com
 */

public class TestListFragment extends BaseListFragment {

    @Override
    protected void initDataBindings() {
        ((BaseListLayoutBinding) mViewBindings).setListVM(new TestListViewModel(getContext()));
    }
}
