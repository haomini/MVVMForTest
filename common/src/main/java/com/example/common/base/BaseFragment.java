package com.example.common.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.common.R;
import com.example.common.databinding.BaseTitleLayoutBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public abstract class BaseFragment<VB extends ViewDataBinding> extends RxFragment {

    protected BaseTitleLayoutBinding mTitleBinding;
    protected VB mViewBindings;

    protected RxPermissions mRxPermissions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // set title
        if (needTitle()) {
            mTitleBinding = DataBindingUtil.inflate(inflater, R.layout.base_title_layout, container, false);
            linearLayout.addView(mTitleBinding.getRoot());
        }

        // title bottom divider
        if (needDivider()) {
            View divider = new View(getContext());
            divider.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            divider.setBackgroundColor(getResources().getColor(R.color.divider_default_color));
            linearLayout.addView(divider);
        }

        // content View
        mViewBindings = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        linearLayout.addView(mViewBindings.getRoot());

        // use EventBus
        if (useEventBus())
            EventBus.getDefault().register(this);

        // use RxPermissions
        if (usePermissions())
            mRxPermissions = new RxPermissions(getActivity());

        initIntentData();

        if (needTitle())
            initTitle();

        initView();
        initDataBindings();
        return linearLayout;
    }

    /**
     * 接收IntentData
     */
    protected void initIntentData() {

    }

    /**
     * 初始化View
     */
    protected void initView() {

    }

    /**
     * 初始化Title
     */
    private void initTitle() {
        mTitleBinding.titleCenter.setText(TextUtils.isEmpty(getTitleCenter()) ? "" : getTitleCenter());
    }

    /**
     * 使用Title
     */
    protected boolean needTitle() {
        return true;
    }

    /**
     * 使用TitleDivider
     */
    protected boolean needDivider() {
        return true;
    }

    /**
     * 设置Title名称
     * @return
     */
    protected CharSequence getTitleCenter() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useEventBus())
            EventBus.getDefault().unregister(this);
    }

    /**
     * content View layout id
     * @return
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 使用EventBus
     * @return
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 使用RxPermissions
     * @return
     */
    protected boolean usePermissions() {
        return false;
    }

    /**
     * 初始化ViewModel
     */
    protected abstract void initDataBindings();
}
