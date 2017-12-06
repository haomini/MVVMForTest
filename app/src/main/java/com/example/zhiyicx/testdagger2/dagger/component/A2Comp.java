package com.example.zhiyicx.testdagger2.dagger.component;

import com.example.zhiyicx.testdagger2.Main2Activity;
import com.example.zhiyicx.testdagger2.dagger.at.LifeScope;

import dagger.Component;
import dagger.MembersInjector;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/29
 * @Contact 605626708@qq.com
 */

@LifeScope
@Component(dependencies = AppComp.class)
public interface A2Comp extends MembersInjector<Main2Activity>{
}
