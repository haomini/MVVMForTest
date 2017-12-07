package com.example.zhiyicx.testdagger2.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.zhiyicx.testdagger2.Main2Activity;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/7
 * @Contact 605626708@qq.com
 */

public class AutoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent actionIntent = new Intent(context, Main2Activity.class);
        actionIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(actionIntent);
    }
}
