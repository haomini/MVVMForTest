package com.example.common.base;

import android.content.Context;

import retrofit2.Retrofit;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/4
 * @Contact 605626708@qq.com
 */

public class BaseViewModel {

    public Retrofit mRetrofit;

    protected Context mContext;

    public BaseViewModel(Context context) {
        mContext = context;
    }
}
