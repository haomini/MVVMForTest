package com.example.zhiyicx.testdagger2.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.common.util.download.ProgressResponseBody;
import com.example.zhiyicx.testdagger2.DownloadUtils;
import com.example.zhiyicx.testdagger2.app.AppApplication;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.bean.ApkBeanDao;
import com.example.zhiyicx.testdagger2.remote.SqlManager;

import java.util.List;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class DownloadService extends Service implements ProgressResponseBody.ProgressListener {

    // 文件放置地址.
    public static final String FILE_PATH = "/haomini_test_files/";

    // 实体对象
    public static final String BEAN = "bean";

    @Inject
    SqlManager mSqlManager;

    ApkBeanDao mApkBeanDao;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerDownloadComponent
                .builder()
                .appComp(AppApplication.getAppComp())
                .build()
                .injectMembers(this);

        mApkBeanDao = mSqlManager.provideApkBeanDao();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ApkBean bean = (ApkBean) intent.getSerializableExtra(BEAN);
        List<ApkBean> list = mApkBeanDao.queryBuilder()
                .where(ApkBeanDao.Properties.Id.eq(bean.getId()))
                .list();
        if(list.size() == 1){
            long lastBreakPosition = list.get(0).getBreakPosition();
            DownloadUtils.nioDownload(bean.getDownload_url(), lastBreakPosition, this);
        }

        if(list.size() == 0){
            mApkBeanDao.insert(bean);
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

    // 仅用作更新进度条
    @Override
    public void onPreExecute(long contentLength) {

    }

    @Override
    public void update(long totalBytes, long contentLength, boolean done) {

    }
}
