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

public class ApkDetailFragment extends BaseFragment<ApkDetailLayoutBinding, ApkDetailViewModel> {

    private ApkBean mApkBean;

    @Override
    protected ApkDetailViewModel getVM() {
        return new ApkDetailViewModel(getContext(), mApkBean);
    }

    @Override
    protected void initIntentData() {
        super.initIntentData();
        mApkBean = (ApkBean) getActivity().getIntent().getSerializableExtra("bean");
        mViewBindings.setApkVM(getVM());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.apk_detail_layout;
    }

    @Override
    protected String getTitleLeft() {
        return mApkBean.getName();
    }

    @Override
    protected View.OnClickListener getLeftListener() {
        return v -> getActivity().finish();
    }
}
