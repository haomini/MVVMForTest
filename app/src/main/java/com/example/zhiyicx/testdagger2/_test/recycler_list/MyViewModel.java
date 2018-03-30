package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/22
 * @Contact 605626708@qq.com
 */

public class MyViewModel extends ViewModel implements DefaultLifecycleObserver{

    public final LiveData<List<User>> usersList;

    public MyViewModel(UserDao userDao) {
        usersList = userDao.getUserList();
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.e("MyViewModel", "onCreate(): " + " activity created!");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.e("MyViewModel", "onDestroy(): " + " i'll be destroyed!");
        owner.getLifecycle().removeObserver(this);
    }
}
