package com.example.common.databind.command;

import android.util.Log;

import com.example.common.databind.command.i.ICommand;

import io.reactivex.functions.Function;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class ReplyCommand implements ICommand {

    private Function mConsumer;

    public ReplyCommand(Function consumer) {
        mConsumer = consumer;
    }

    @Override
    public void exec() {
        try {
            checkCommandNull();
            mConsumer.apply(null);
        } catch (Exception e) {
            onError(e);
        }
    }

    protected void onError(Exception e) {
        Log.e("ReplyCommand", "onError(): not catch");
        e.printStackTrace();
    }

    private void checkCommandNull(){
        if(mConsumer == null) throw new NullPointerException("Command must not be null");
    }
}
