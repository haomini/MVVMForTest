package com.example.zhiyicx.testdagger2.dagger.module;

import com.example.zhiyicx.testdagger2.base.BaseApplication;
import com.example.zhiyicx.testdagger2.greendao.bean.DaoMaster;
import com.example.zhiyicx.testdagger2.greendao.bean.DaoSession;
import com.example.zhiyicx.testdagger2.greendao.bean.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/30
 * @Contact 605626708@qq.com
 */

@Module
public class SingleDaoModule {

    private static final String DB_NAME = "doubi_db";

    @Singleton
    @Provides
    public DaoSession provideDaoSession(BaseApplication baseApplication){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(baseApplication, DB_NAME, null);
        return new DaoMaster(helper.getWritableDatabase()).newSession();
    }

    @Singleton
    @Provides
    public UserDao provideUserDao(DaoSession daoSession){
        return daoSession.getUserDao();
    }
}
