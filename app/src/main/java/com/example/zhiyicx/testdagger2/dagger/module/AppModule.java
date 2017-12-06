package com.example.zhiyicx.testdagger2.dagger.module;

import com.example.zhiyicx.testdagger2.base.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/29
 * @Contact 605626708@qq.com
 */

@Module
public class AppModule {
    private static BaseApplication mApplication;

    public AppModule(BaseApplication application) {
        mApplication = application;
    }

    @Provides
    static BaseApplication provideApplication() {
        return mApplication;
    }
}
