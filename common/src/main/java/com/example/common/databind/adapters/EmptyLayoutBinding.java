package com.example.common.databind.adapters;

import android.databinding.BindingAdapter;

import com.example.common.databind.command.ReplyProcess;
import com.example.common.widget.EmptyLayout;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/10
 * @Contact 605626708@qq.com
 */

public class EmptyLayoutBinding {

    @BindingAdapter("state")
    public static void setState(EmptyLayout emptyLayout, @EmptyLayout.EMPTY_STATE int state){
        emptyLayout.setState(state);
    }

    @BindingAdapter("onEmptyClicked")
    public static void setOnEmptyClicked(EmptyLayout emptyLayout, ReplyProcess onEmptyClicked){
        emptyLayout.setOnEmptyClicked(onEmptyClicked);
    }
}
