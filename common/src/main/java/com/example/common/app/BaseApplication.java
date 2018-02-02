package com.example.common.app;

import android.support.multidex.MultiDexApplication;

import com.example.common.dagger2.component.BaseComp;
import com.example.common.dagger2.component.DaggerBaseComp;
import com.example.common.dagger2.module.BaseModule;
import com.example.common.dagger2.module.HttpModule;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */

public class BaseApplication extends MultiDexApplication {

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
    private static BaseComp baseComp;

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;

        baseComp = DaggerBaseComp.builder()
                .baseModule(new BaseModule(this))
                .httpModule(new HttpModule())
                .build();

    }

    public static BaseComp getBaseComp() {
        return baseComp;
    }

    public static BaseApplication getApp() {
        return mBaseApplication;
    }
}
