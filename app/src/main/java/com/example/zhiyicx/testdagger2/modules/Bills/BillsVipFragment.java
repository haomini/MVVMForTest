package com.example.zhiyicx.testdagger2.modules.Bills;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.example.common.base.BaseFragment;
import com.example.common.base.BaseViewModel;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.databinding.ActivityVipPlayBinding;
import com.example.zhiyicx.testdagger2.modules.Info.InfoActivity;

/**
 * Created by LS-PC on 2017/12/13.
 */

public class BillsVipFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_vip_play;
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
        ((ActivityVipPlayBinding) mViewBindings).btnVipPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "暂无开通", Toast.LENGTH_SHORT).show();
            }
        });
        ((ActivityVipPlayBinding) mViewBindings).textViewJilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), InfoActivity.class));
            }
        });
    }


}
