package com.example.zhiyicx.testdagger2.dagger.module;

import com.example.zhiyicx.testdagger2.dagger.at.ASimpleType;
import com.example.zhiyicx.testdagger2.dagger.bean.ADepBean;
import com.example.zhiyicx.testdagger2.dagger.bean.ASimpleBean;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */

@Module
public class YModule {

    @Provides
    @ASimpleType("Normal")
    static ASimpleBean provideNormalBean(){
        return new ASimpleBean();
    }

    @Provides
    @ASimpleType("Bounds")
    static ASimpleBean provideBoundsBean(ADepBean module){
        return new ASimpleBean(module);
    }
}
