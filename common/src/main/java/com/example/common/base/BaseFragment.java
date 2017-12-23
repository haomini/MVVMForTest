package com.example.common.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.common.R;
import com.example.common.databinding.BaseTitleLayoutBinding;

import org.greenrobot.eventbus.EventBus;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */

public abstract class BaseFragment<VB extends ViewDataBinding> extends Fragment {

    protected BaseTitleLayoutBinding mTitleBinding;
    protected VB mViewBindings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        if (needTitle()) {
            mTitleBinding = DataBindingUtil.inflate(inflater, R.layout.base_title_layout, container, false);
            linearLayout.addView(mTitleBinding.getRoot());
        }
        if (needDivider()) {
            View divider = new View(getContext());
            divider.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            divider.setBackgroundColor(getResources().getColor(R.color.divider_default_color));
            linearLayout.addView(divider);
        }
        mViewBindings = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        linearLayout.addView(mViewBindings.getRoot());

        initDataBindings();

        if (needEventBus())
            EventBus.getDefault().register(this);

        initIntentData();
        initTitle();
        initView();
        return linearLayout;
    }

    protected abstract void initDataBindings();

    private void initTitle() {
        mTitleBinding.titleCenter.setText(TextUtils.isEmpty(getTitleCenter()) ? "" : getTitleCenter());
        mTitleBinding.titleLeftImg.setVisibility(needLeftIcon() ? View.VISIBLE : View.GONE);
        mTitleBinding.titleLeftText.setText(TextUtils.isEmpty(getTitleLeft()) ? "" : getTitleLeft());
        mTitleBinding.titleLeft.setOnClickListener(getLeftListener());
        mTitleBinding.titleRight.setBackgroundResource(getRightImg());
        mTitleBinding.titleRight1.setBackgroundResource(getRight1Img());
        mTitleBinding.titleRight1.setOnClickListener(getRight1Listener());
        mTitleBinding.titleRight.setOnClickListener(getRightListener());
        mTitleBinding.titleRight1.setVisibility(needRight1Icon() ? View.VISIBLE : View.GONE);
        mTitleBinding.titleRight.setVisibility(needRightIcon() ? View.VISIBLE : View.GONE);
    }

    protected void initIntentData() {

    }

    protected void initView() {

    }
    protected boolean needRight1Icon() {
        return false;
    };

    protected boolean needRightIcon() {
        return true;
    }
    protected abstract VB getVM();



    protected boolean needTitle() {
        return true;
    }

    protected boolean needDivider() {
        return true;
    }

    protected CharSequence getTitleCenter() {
        return null;
    }

    protected boolean needLeftIcon() {
        return true;
    }

    protected String getTitleLeft() {
        return null;
    }

    protected View.OnClickListener getLeftListener() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (needEventBus())
            EventBus.getDefault().unregister(this);
    }

    @LayoutRes
    protected abstract int getLayoutId();
    public int getRight1Img() {
        return 0;
    }

    public int getRightImg() {
        return 0;
    }
    protected boolean needEventBus() {
        return false;
    }

    public View.OnClickListener getRight1Listener() {
        return null;
    }

    public View.OnClickListener getRightListener() {
        return null;
    }
}
