package com.example.zhiyicx.testdagger2.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.common.util.download.ProgressResponseBody;
import com.example.zhiyicx.testdagger2.DownloadUtils;
import com.example.zhiyicx.testdagger2.R;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class DoenloadService extends IntentService {

    private int progress = 0;
    private long startPos = 0;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public DoenloadService() {
        super("DoenloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("好贝贝")
                .setContentText("连接中...");
        notificationManager.notify(101, notification.build());
        DownloadUtils.nioDownload(startPos, new ProgressResponseBody.ProgressListener() {
            @Override
            public void onPreExecute(long contentLength) {
                notification.setProgress(100, progress, false);
                notificationManager.notify(101, notification.setContentText("开始下载...").build());
            }

            @Override
            public void update(long totalBytes, long contentLength, boolean done) {
                startPos = totalBytes;
                int currentProgress = (int) (totalBytes * 100 / contentLength);
                if (currentProgress == 100 || currentProgress > progress) {
                    progress = currentProgress;
//                notification.
                    notification.setProgress(100, progress, false);
                    if (progress == 100) {
                        notification.setContentText("下载完成");
                    } else {

                    }
                    notificationManager.notify(101, notification.build());
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
