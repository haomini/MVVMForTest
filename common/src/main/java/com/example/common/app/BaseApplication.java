package com.example.common.app;

import android.app.Application;

import com.example.common.dagger2.component.AppComp;
import com.example.common.dagger2.component.DaggerAppComp;
import com.example.common.dagger2.module.AppModule;
import com.example.common.dagger2.module.HttpModule;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tamic.novate.Novate;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */

public class BaseApplication extends Application {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater((context, layout) -> {
            layout.setPrimaryColorsId(android.R.color.white);//全局设置主题颜色
            return new ClassicsHeader(context);
            //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context).setDrawableSize(20);
        });
    }

    private static BaseApplication mBaseApplication;
    private static AppComp appComp;
    private static Novate novate;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;

        appComp = DaggerAppComp.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();

        novate = new Novate.Builder(this)
                .connectTimeout(20)
                .baseUrl("http://systemapp.laoshi888.com/")
                .addLog(true)
                .build();
    }

    public static AppComp getAppComp() {
        return appComp;
    }

    public static BaseApplication getApp() {
        return mBaseApplication;
    }

    public static Novate getNovate() {
        return novate;
    }
}
