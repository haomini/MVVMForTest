package com.example.zhiyicx.testdagger2.modules.Bills;

import com.example.common.base.BaseActivity;

/**
 * Created by LS-PC on 2017/12/13.
 */

class BillsVipActivity extends BaseActivity<BillsVipFragment> {


    @Override
    protected BillsVipFragment bindingFragments() {
        return new BillsVipFragment();
    }
}
