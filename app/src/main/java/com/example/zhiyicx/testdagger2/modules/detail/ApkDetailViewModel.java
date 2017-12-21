package com.example.zhiyicx.testdagger2.modules.detail;

import android.content.Context;

import com.example.common.base.BaseViewModel;
import com.example.zhiyicx.testdagger2.bean.ApkBean;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/10
 * @Contact 605626708@qq.com
 */

public class ApkDetailViewModel extends BaseViewModel {

    public ApkBean mApkBean;

    public ApkDetailViewModel(Context context, ApkBean apkBean) {
        super(context);
        this.mApkBean = apkBean;
    }

    public void onInstallClicked() {

    }
}
