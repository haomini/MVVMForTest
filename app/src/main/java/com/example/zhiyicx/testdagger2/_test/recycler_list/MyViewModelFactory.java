package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/22
 * @Contact 605626708@qq.com
 */

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final UserDao mUserDao;

    public MyViewModelFactory(UserDao userDao) {
        mUserDao = userDao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(mUserDao);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
