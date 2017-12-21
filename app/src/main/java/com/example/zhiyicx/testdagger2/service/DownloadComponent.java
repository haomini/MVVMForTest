package com.example.zhiyicx.testdagger2.service;

import com.example.zhiyicx.testdagger2.dagger2.comp.AppComp;

import dagger.Component;
import dagger.MembersInjector;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */
@Component(dependencies = AppComp.class)
public interface DownloadComponent extends MembersInjector<DownloadService>{
}
