package com.example.common.dagger2.module;

import com.example.common.app.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/6
 * @Contact 605626708@qq.com
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(BaseApplication application) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        return new Retrofit.Builder()
                .baseUrl("http://www.baidu.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
}
