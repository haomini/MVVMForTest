package com.example.zhiyicx.testdagger2.modules.detail;

import android.view.View;

import com.example.common.base.BaseFragment;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.databinding.ApkDetailLayoutBinding;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/10
 * @Contact 605626708@qq.com
 */

public class ApkDetailFragment extends BaseFragment<ApkDetailLayoutBinding> {

    private ApkDetailViewModel mApkDetailViewModel;

    protected ApkDetailViewModel initViewModel() {
        return mApkDetailViewModel = new ApkDetailViewModel(getContext());
    }

    @Override
    protected void initDataBindings() {
        mViewBindings.setApkVM(initViewModel());
    }

    @Override
    protected void initIntentData() {
        super.initIntentData();
        mApkDetailViewModel.mApkBean = (ApkBean) getActivity().getIntent().getSerializableExtra("bean");
    }

    @Override
    protected ApkDetailLayoutBinding getVM() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.apk_detail_layout;
    }

    @Override
    protected String getTitleLeft() {
        return mApkDetailViewModel.mApkBean.getName();
    }

    @Override
    protected View.OnClickListener getLeftListener() {
        return v -> getActivity().finish();
    }
}
