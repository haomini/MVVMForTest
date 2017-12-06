package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.common.R;
import com.example.common.app.ActivityStack;
import com.example.common.util.DeviceUtils;
import com.example.common.util.StatusBarUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import static com.example.common.util.StatusBarUtils.STATUS_TYPE_ANDROID_M;

/**
 * @Describe BaseActivity
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */

public abstract class BaseActivity<T extends Fragment> extends RxAppCompatActivity {

    protected T mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        setContentView(linearLayout);

        if (needPlaceStatusHolder()) {
            StatusBarUtils.setStatusBarColor(this, R.color.white);
            if (needPlaceStatusHolder()) {
                View view = new View(this);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        DeviceUtils.getStatusBarHeight(this)));
                linearLayout.addView(view);
            }
        }

        ActivityStack.getInstance().addActivity(this);

        FrameLayout fm = new FrameLayout(this);
        fm.setId(R.id.fragment_container);
        linearLayout.addView(fm, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        mFragment = bindingFragments();
        checkFragmentNull();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragment).commit();
        component();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.getInstance().removeActivity(this);
    }

    /**
     * 是否需要透明状态栏
     *
     * @return
     */
    protected boolean needTransportStatus() {
        return true;
    }

    /**
     * 判断透明状态栏变色的方式是否需要添加view来替代statusBar背景
     *
     * @return
     */
    private boolean needPlaceStatusHolder() {
        return StatusBarUtils.statusBarLightMode(this) == STATUS_TYPE_ANDROID_M;
    }

    private void checkFragmentNull() {
        if (mFragment == null) throw new NullPointerException(
                getClass().getSimpleName() + " mFragment not set!");
    }

    /**
     * 将dagger2的注入从fragment提前到Activity,
     */
    protected abstract void component();

    /**
     * 绑定fragment到Activity.
     *
     * @return fragment
     */
    protected abstract T bindingFragments();
}
