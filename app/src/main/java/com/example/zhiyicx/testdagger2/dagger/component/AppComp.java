package com.example.zhiyicx.testdagger2.dagger.component;

import com.example.zhiyicx.testdagger2.base.BaseApplication;
import com.example.zhiyicx.testdagger2.dagger.module.AppModule;
import com.example.zhiyicx.testdagger2.dagger.module.SingleDaoModule;
import com.example.zhiyicx.testdagger2.greendao.bean.UserDao;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/29
 * @Contact 605626708@qq.com
 */

@Singleton
@Component(modules = {AppModule.class, SingleDaoModule.class})
public interface AppComp{

    // 为了让别的component可以拿到BaseApplication对象,
    // 在这里暴露BaseApplication接口.
    BaseApplication provideBaseApplication();

    UserDao provideUserDao();
}
