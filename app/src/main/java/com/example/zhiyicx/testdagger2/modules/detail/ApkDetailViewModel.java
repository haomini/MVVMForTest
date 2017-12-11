package com.example.zhiyicx.testdagger2.modules.detail;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.example.common.app.BaseApplication;
import com.example.common.base.BaseViewModel;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.tamic.novate.Throwable;
import com.tamic.novate.download.DownLoadCallBack;

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

    public void onInstallClicked(){

        NotificationManager mNotifyManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext);
        mBuilder.setContentTitle(mApkBean.getName())
                .setContentText("连接中...")
                .setSmallIcon(R.drawable.ic_launcher);
        mNotifyManager.notify(101, mBuilder.build());

        BaseApplication.getNovate().download(mApkBean.getDownload_url(),
                "yyb.exe", new DownLoadCallBack() {
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onSucess(String key, String path, String name, long fileSize) {
                        mBuilder.setContentText("下载完成")
                                .setProgress(0,0,false);
                        mNotifyManager.notify(101, mBuilder.build());
                    }

                    @Override
                    public void onProgress(String key, int progress, long fileSizeDownloaded, long totalSize) {
                        mBuilder.setProgress(100, progress, false);
                        mNotifyManager.notify(101, mBuilder.build());
                    }
                });
    }
}
