package com.example.zhiyicx.testdagger2.dagger2.module;

import com.example.zhiyicx.testdagger2.remote.HomeClient;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

@Module
public class ClientModule {

    @Provides
    public static HomeClient provideHomeClient(Retrofit retrofit){
        return retrofit.create(HomeClient.class);
    }
}
