package com.example.zhiyicx.testdagger2.remote;

import com.example.zhiyicx.testdagger2.bean.ApkBeanDao;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class SqlManager {
    private ApkBeanDao mApkBeanDao;

    @Inject
    public SqlManager(ApkBeanDao apkBeanDao) {
        mApkBeanDao = apkBeanDao;
    }

    public ApkBeanDao provideApkBeanDao() {
        return mApkBeanDao;
    }
}
