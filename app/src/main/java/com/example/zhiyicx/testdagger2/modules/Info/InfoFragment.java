package com.example.zhiyicx.testdagger2.modules.Info;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.common.base.BaseFragment;
import com.example.common.base.BaseViewModel;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.modules.Bills.BillsViewModel;
import com.example.zhiyicx.testdagger2.modules.home.HomeActivity;

/**
 * Created by LS-PC on 2017/12/13.
 */

public class InfoFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_info;
    }

    @Override
    protected String getTitleLeft() {
        return "订单详情";
    }

    @Override
    protected boolean needLeftIcon() {
        return true;
    }

    @Override
    protected void initDataBindings() {

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
        
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                getContext().startActivity(new Intent(getContext(), HomeActivity.class));
            }
        };
    }

}
