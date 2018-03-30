package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/22
 * @Contact 605626708@qq.com
 */

public class UserDao {

    public LiveData<List<User>> getUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User(1, "周鸥"));
        list.add(new User(2, "赵华"));
        list.add(new User(3, "吴海"));
        list.add(new User(4, "知月"));
        list.add(new User(5, "知晴"));
        list.add(new User(6, "李天"));
        list.add(new User(7, "宋海"));
        MutableLiveData<List<User>> liveData = new MutableLiveData<>();
        liveData.postValue(list);
        return liveData;
    }
}
