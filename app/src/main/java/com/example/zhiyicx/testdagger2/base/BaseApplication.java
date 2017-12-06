package com.example.zhiyicx.testdagger2.base;

import android.app.Application;

import com.example.zhiyicx.testdagger2.dagger.component.AppComp;
import com.example.zhiyicx.testdagger2.dagger.component.DaggerAppComp;
import com.example.zhiyicx.testdagger2.dagger.module.AppModule;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;

    private static AppComp mAppComp;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;

        mAppComp = DaggerAppComp.builder().appModule(new AppModule(this)).build();
    }

    public static AppComp getAppComp() {
        return mAppComp;
    }
}
