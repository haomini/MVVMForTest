package com.example.zhiyicx.testdagger2.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.zhiyicx.testdagger2.bean.ApkBean;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class DownloadService extends Service {

    // 文件放置地址.
    public static final String FILE_PATH = "/haomini_test_files/";

    // 实体对象
    public static final String BEAN = "bean";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ApkBean bean = (ApkBean) intent.getSerializableExtra(BEAN);

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

}
