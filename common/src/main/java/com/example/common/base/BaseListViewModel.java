package com.example.common.base;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.v7.widget.RecyclerView;

import com.example.common.databind.command.ReplyProcess;
import com.example.common.databind.command.i.ICommand;
import com.example.common.widget.EmptyLayout;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public abstract class BaseListViewModel<T> extends BaseViewModel {

    public HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    public RecyclerView.Adapter mAdapter;
    public ObservableInt mSmartRefreshLayoutState = new ObservableInt(1);
    public ObservableInt mEmptyState = new ObservableInt(EmptyLayout.LOADING);
    protected List<T> mListDatas = new ArrayList<>();

    // 刷新指令
    public ReplyProcess onRefreshCommand;

    // 加载指令
    public ReplyProcess onLoadCommand;

    // 空布局点击事件
    public ReplyProcess onEmptyClicked;

    public BaseListViewModel(Context context) {
        super(context);
        mAdapter = getAdapter();
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        onRefreshCommand = new ReplyProcess(getRefreshCommand());
        onLoadCommand = new ReplyProcess(getLoadMoreCommand());
        onEmptyClicked = new ReplyProcess(getEmptyCommand());
    }

    // 提供刷新指令 must
    protected abstract ICommand getRefreshCommand();

    // adapter
    protected abstract RecyclerView.Adapter getAdapter();

    // 提供加载指令 well
    protected ICommand getLoadMoreCommand() {
        return () -> {
        };
    }

    protected ICommand getEmptyCommand(){
        return () -> {
        };
    }
}
