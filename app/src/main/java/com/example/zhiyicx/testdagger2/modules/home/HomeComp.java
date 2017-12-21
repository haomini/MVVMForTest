package com.example.zhiyicx.testdagger2.modules.home;

import com.example.common.dagger2.at.LifeScope;
import com.example.zhiyicx.testdagger2.dagger2.comp.AppComp;

import dagger.Component;
import dagger.MembersInjector;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */
@LifeScope
@Component(dependencies = AppComp.class)
public interface HomeComp extends MembersInjector<HomeViewModel>{
}
