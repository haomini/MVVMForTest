package com.example.common.dagger2.component;

import com.example.common.app.BaseApplication;
import com.example.common.dagger2.module.BaseModule;
import com.example.common.dagger2.module.HttpModule;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */
@Component(modules = {BaseModule.class, HttpModule.class})
public interface BaseComp {

    // 提供全局的单例Application, 先留着..
    BaseApplication provideApp();

    Retrofit provideRetrofit();
}
