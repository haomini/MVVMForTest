package com.example.zhiyicx.testdagger2.modules.Bills;

import com.example.common.base.BaseActivity;

/**
 * Created by LS-PC on 2017/12/13.
 */

public class BillsActivity extends BaseActivity<BillsFragment> {


    @Override
    protected BillsFragment bindingFragments() {
        return new BillsFragment();
    }
}
