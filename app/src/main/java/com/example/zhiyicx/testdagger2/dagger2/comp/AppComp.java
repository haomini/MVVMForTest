package com.example.zhiyicx.testdagger2.dagger2.comp;

import com.example.common.dagger2.component.BaseComp;
import com.example.zhiyicx.testdagger2.dagger2.module.ClientModule;
import com.example.zhiyicx.testdagger2.dagger2.module.SqlModule;
import com.example.zhiyicx.testdagger2.remote.ClientManager;
import com.example.zhiyicx.testdagger2.remote.SqlManager;

import dagger.Component;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */
@Component(dependencies = BaseComp.class, modules = {ClientModule.class, SqlModule.class})
public interface AppComp{
    ClientManager provideClientManager();

    SqlManager provideSqlManager();
}
