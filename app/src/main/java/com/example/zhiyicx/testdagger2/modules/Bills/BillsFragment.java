package com.example.zhiyicx.testdagger2.modules.Bills;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.example.common.base.BaseFragment;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.databinding.ActivityNoVipPayBinding;


/**
 * Created by LS-PC on 2017/12/13.
 */


public class BillsFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_no_vip_pay;
    }

    @Override
    protected String getTitleLeft() {
        return "SystemAPP";
    }

    @Override
    protected boolean needLeftIcon() {
        return true;
    }

    @Override
    protected boolean needRight1Icon() {
        return false;
    }

    @Override
    protected boolean needRightIcon() {
        return false;
    }

    @Override
    protected ViewDataBinding getVM() {
        return null;
    }

    @Override
    protected View.OnClickListener getLeftListener() {
        return v -> getActivity().finish();
    }

    @Override
    protected void initDataBindings() {

    }

    @Override
    protected void initView() {
        super.initView();
        ((ActivityNoVipPayBinding) mViewBindings).btnNoVipPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), BillsVipActivity.class));
            }
        });
    }
}
