package com.example.zhiyicx.testdagger2.dagger2.module;

import android.database.sqlite.SQLiteDatabase;

import com.example.common.app.BaseApplication;
import com.example.zhiyicx.testdagger2.bean.ApkBeanDao;
import com.example.zhiyicx.testdagger2.bean.DaoMaster;
import com.example.zhiyicx.testdagger2.bean.DaoSession;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

@Module
public class SqlModule {

    public static final String DB_NAME = "dao_db";

    @Provides
    public static DaoSession provideDaoSession(BaseApplication application) {
        DaoMaster.DevOpenHelper mDevOpenHelper = new DaoMaster.DevOpenHelper(application, DB_NAME);
        SQLiteDatabase db = mDevOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

    @Provides
    public static ApkBeanDao provideApkBeanDao(DaoSession daoSession){
        return daoSession.getApkBeanDao();
    }
}
