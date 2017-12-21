package com.example.common.databind.adapters;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class RecyclerViewBinding {

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recycler, RecyclerView.Adapter adapter) {
        recycler.setAdapter(adapter);
    }
}
