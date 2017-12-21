package com.example.zhiyicx.testdagger2.app;

import com.example.common.app.BaseApplication;
import com.example.zhiyicx.testdagger2.dagger2.comp.AppComp;
import com.example.zhiyicx.testdagger2.dagger2.comp.DaggerAppComp;
import com.example.zhiyicx.testdagger2.dagger2.module.ClientModule;
import com.example.zhiyicx.testdagger2.dagger2.module.SqlModule;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class AppApplication extends BaseApplication {

    private static AppApplication appApplication;
    private static AppComp appComp;

    @Override
    public void onCreate() {
        super.onCreate();
        appApplication = this;

        appComp = DaggerAppComp.builder()
                .baseComp(getBaseComp())
                .sqlModule(new SqlModule())
                .clientModule(new ClientModule())
                .build();

    }

    public static AppComp getAppComp() {
        return appComp;
    }

    public static AppApplication getAppApplication() {
        return appApplication;
    }
}
