package com.example.common.databind.adapters;

import android.databinding.BindingAdapter;

import com.example.common.databind.command.ReplyProcess;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;


/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class SmartRefreshBinding {

    @BindingAdapter("refresh")
    public static void onRefresh(SmartRefreshLayout smartRefreshLayout, ReplyProcess refreshCommand) {
        smartRefreshLayout.setOnRefreshListener(v -> refreshCommand.run());
    }

    @BindingAdapter({"refresh", "load"})
    public static void onLoad(SmartRefreshLayout smartRefreshLayout, ReplyProcess refreshCommand, ReplyProcess loadCommand) {
        smartRefreshLayout.setOnRefreshListener(v -> refreshCommand.run());
        smartRefreshLayout.setOnLoadmoreListener(v -> loadCommand.run());
    }

    @BindingAdapter({"state"})
    public static synchronized void setStatus(SmartRefreshLayout smartRefreshLayout, int state) {
        if (state == 0) {
            smartRefreshLayout.finishLoadmore();
            smartRefreshLayout.finishRefresh();
        } else if (state == 1) {
            smartRefreshLayout.autoRefresh();
        } else if (state == 2) {
            smartRefreshLayout.autoLoadmore();
        }
    }
}
