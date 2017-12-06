package com.example.common.base;

import android.content.Context;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/4
 * @Contact 605626708@qq.com
 */

public abstract class BaseViewModel {

    protected Context mContext;

    public BaseViewModel(Context context) {
        mContext = context;
    }
}
