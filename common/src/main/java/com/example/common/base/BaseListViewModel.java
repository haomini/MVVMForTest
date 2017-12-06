package com.example.common.base;

import android.content.Context;
import android.util.Log;

import com.example.common.databind.command.ReplyCommand;


/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class BaseListViewModel extends BaseViewModel {

    // 刷新指令
    public ReplyCommand onRefreshCommand = new ReplyCommand(o ->
            Log.e("BaseListViewModel", "(): " + "onRefreshCommand do!")
    );

    // 加载指令
    public ReplyCommand onLoadCommand = new ReplyCommand(o ->
            Log.e("BaseListViewModel", "(): " + "onLoadCommand do!")
    );

    public BaseListViewModel(Context context) {
        super(context);
    }
}
