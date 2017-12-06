package com.example.common.databind.adapters;

import android.databinding.BindingAdapter;

import com.example.common.databind.command.i.ICommand;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;


/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class SmartRefreshBinding {

    @BindingAdapter("refresh")
    public static void onRefresh(SmartRefreshLayout smartRefreshLayout, final ICommand refreshCommand) {
        smartRefreshLayout.setOnRefreshListener(v -> refreshCommand.exec());
    }

    @BindingAdapter({"refresh", "load"})
    public static void onLoad(SmartRefreshLayout smartRefreshLayout, final ICommand refreshCommand, final ICommand loadCommand) {
        smartRefreshLayout.setOnRefreshListener(v -> refreshCommand.exec());
        smartRefreshLayout.setOnLoadmoreListener(v -> loadCommand.exec());
    }
}
