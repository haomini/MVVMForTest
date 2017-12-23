package com.example.zhiyicx.testdagger2.modules.Info;

import android.support.v4.app.Fragment;

import com.example.common.base.BaseActivity;

/**
 * Created by LS-PC on 2017/12/13.
 */

public class InfoActivity extends BaseActivity {

    @Override
    protected Fragment bindingFragments() {
        return new InfoFragment();
    }
}
