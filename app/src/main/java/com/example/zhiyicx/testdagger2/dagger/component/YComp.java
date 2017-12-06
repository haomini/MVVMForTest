package com.example.zhiyicx.testdagger2.dagger.component;

import com.example.zhiyicx.testdagger2.MainActivity;
import com.example.zhiyicx.testdagger2.dagger.at.LifeScope;
import com.example.zhiyicx.testdagger2.dagger.module.AdeModule;
import com.example.zhiyicx.testdagger2.dagger.module.YModule;

import dagger.Component;
import dagger.MembersInjector;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */
@LifeScope
@Component(dependencies = AppComp.class, modules = {YModule.class, AdeModule.class})
public interface YComp extends MembersInjector<MainActivity> {
}
