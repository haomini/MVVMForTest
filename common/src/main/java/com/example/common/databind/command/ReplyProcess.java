package com.example.common.databind.command;

import android.util.Log;

import com.example.common.databind.command.i.ICommand;

/**
 * @Describe 应答指令集处理器
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class ReplyProcess {

    private ICommand mCommand;

    public ReplyProcess(ICommand command) {
        mCommand = command;
    }

    public void run() {
        try {
            checkCommandNull();
            mCommand.exec();
        } catch (Exception e) {
            onError(e);
        }
    }

    protected void onError(Exception e) {
        Log.e("ReplyProcess", "onError(): not catch");
        e.printStackTrace();
    }

    private void checkCommandNull(){
        if(mCommand == null) throw new NullPointerException("Command must not be null");
    }
}
