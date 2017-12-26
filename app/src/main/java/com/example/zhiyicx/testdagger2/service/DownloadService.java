package com.example.zhiyicx.testdagger2.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.zhiyicx.testdagger2.DownloadUtils;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.app.AppApplication;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.bean.ApkBeanDao;
import com.example.zhiyicx.testdagger2.remote.SqlManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class DownloadService extends Service implements /*ProgressResponseBody.ProgressListener, */DownloadUtils.DownloadProgreser {

    // 文件放置地址.
    public static final String FILE_PATH = "/haomini_test_files/";

    // 下载/暂停
    public static final String LOAD = "load";

    // 实体对象
    public static final String BEAN = "bean";

    @Inject
    SqlManager mSqlManager;

    ApkBeanDao mApkBeanDao;
    private NotificationManager notificationManager;
    private NotificationCompat.Builder notification;
    private long startPos;
    private int progress;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerDownloadComponent
                .builder()
                .appComp(AppApplication.getAppComp())
                .build()
                .injectMembers(this);

        mApkBeanDao = mSqlManager.provideApkBeanDao();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean load = intent.getBooleanExtra(LOAD, false);
        ApkBean bean = (ApkBean) intent.getSerializableExtra(BEAN);
        bean.setDownload_url(DownloadUtils.urlStr);
        if (load) {
            List<ApkBean> list = mApkBeanDao.queryBuilder()
                    .where(ApkBeanDao.Properties.Id.eq(bean.getId()))
                    .list();

            notification.setContentTitle(bean.getName())
                    .setContentText("连接中...")
                    .setContentIntent(PendingIntent.getService(this, 0,
                            new Intent(this, DownloadService.class)
                                    .putExtra(BEAN, bean)
                                    .putExtra(LOAD, false),
                            PendingIntent.FLAG_UPDATE_CURRENT));
            notificationManager.notify(101, notification.build());

            notification.setProgress(100, progress, false);
            notificationManager.notify(101, notification.setContentText("开始下载...").build());
            DownloadUtils.load = true;

            long breakPos = list.size() == 1 ? list.get(0).getBreakPosition() : 0;
            if (!new File(Environment.getExternalStorageDirectory() + FILE_PATH + bean.getName() + ".apk").exists()) {
                breakPos = 0;
            }
            bean.setBreakPosition(breakPos);
            new Thread() {
                @Override
                public void run() {
                    try {
                        DownloadUtils.classicDownload(bean, bean.getBreakPosition(), DownloadService.this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            if (list.size() == 0) {
                mApkBeanDao.insert(bean);
            }
        } else {
            DownloadUtils.load = false;
            notification.setContentIntent(PendingIntent.getService(this, 0,
                    new Intent(this, DownloadService.class)
                            .putExtra(BEAN, bean)
                            .putExtra(LOAD, true),
                    PendingIntent.FLAG_UPDATE_CURRENT))
                    .setContentText("已暂停,点击继续...");
            notificationManager.notify(101, notification.build());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void update(ApkBean apkBean, long totalPos, long contentLength, boolean done) {
        startPos = totalPos;
        int currentProgress = (int) (totalPos * 100 / contentLength);
        if (currentProgress == 100 || currentProgress > progress) {
            progress = currentProgress;
//                notification.
            notification.setProgress(100, progress, false);
            if (progress == 100) {
                notification.setContentText("下载完成");
            }
            notificationManager.notify(101, notification.build());
        }
    }

    @Override
    public void pause(ApkBean apkBean, long totalPos, long contentLength) {
        apkBean.setBreakPosition(totalPos);
        apkBean.setContentLength(contentLength);
        mApkBeanDao.insertOrReplace(apkBean);
    }
}
