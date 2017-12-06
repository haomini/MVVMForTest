package com.example.common.dagger2.component;

import com.example.common.app.BaseApplication;
import com.example.common.dagger2.module.AppModule;
import com.example.common.dagger2.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComp{

    // 提供全局的单例Application, 先留着..
    BaseApplication provideApp();
}
