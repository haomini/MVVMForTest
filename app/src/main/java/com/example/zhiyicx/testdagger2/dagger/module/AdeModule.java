package com.example.zhiyicx.testdagger2.dagger.module;

import com.example.zhiyicx.testdagger2.dagger.bean.ADepBean;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */

@Module
public class AdeModule {
    private String name;

    public AdeModule(String name) {
        this.name = name;
    }

    @Provides
    ADepBean provideAdeBean() {
        return new ADepBean(name);
    }
}
