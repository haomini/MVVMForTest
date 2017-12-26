package com.example.zhiyicx.testdagger2.modules.detail;

import android.content.Context;
import android.content.Intent;

import com.example.common.base.BaseViewModel;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.service.DownloadService;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/10
 * @Contact 605626708@qq.com
 */

public class ApkDetailViewModel extends BaseViewModel {

    public ApkBean mApkBean;

    public ApkDetailViewModel(Context context) {
        super(context);
    }

    public void onInstallClicked() {
        mContext.startService(new Intent(mContext, DownloadService.class)
                .putExtra(DownloadService.BEAN, mApkBean)
                .putExtra(DownloadService.LOAD, true));
    }
}
