package com.example.common.base;

import android.util.Log;

import com.example.common.bean.BaseBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public abstract class BaseObserver<D extends Object, T extends BaseBean<D>> implements Observer<T> {

    public static final int DEFAULT_ERROR = 1009;
    public static final int DEFAULT_SUCCESS = 2;

    @Override
    public void onSubscribe(Disposable d) {
        Log.e("TAG", "onSubscribe: ");
    }

    @Override
    public void onNext(T t) {
        if (t.getStatus() == DEFAULT_SUCCESS) {
            onSuccess(t.getMsg(), t.getData());
        } else {
            onFailed(t.getStatus(), t.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailed(DEFAULT_ERROR, e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e("TAG", "onComplete: ");
    }

    protected abstract void onFailed(int status, String msg);

    protected abstract void onSuccess(String msg, D data);
}
