package com.example.zhiyicx.testdagger2.ui.test_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.example.common.base.BaseListViewModel;
import com.example.common.databind.command.i.ICommand;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/2/9
 * @Contact 605626708@qq.com
 */

public class TestListViewModel extends BaseListViewModel<String> {

    public TestListViewModel(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new CommonAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, gettestList()) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {
                holder.setText(android.R.id.text1, o);
            }
        };
    }

    @Override
    protected ICommand getRefreshCommand() {
        return () -> {
            mListDatas.clear();
            mListDatas.addAll(gettestList());
            mHeaderAndFooterWrapper.notifyDataSetChanged();
            mSmartRefreshLayoutState.set(0);
            mEmptyState.set(1);
        };
    }

    @Override
    protected ICommand getLoadMoreCommand() {
        return () -> {
            mListDatas.clear();
            mListDatas.addAll(gettestList());
            mListDatas.add("adasda");
            mHeaderAndFooterWrapper.notifyDataSetChanged();
        };
    }

    @Override
    protected ICommand getEmptyCommand() {
        return getRefreshCommand();
    }

    public List<String> gettestList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        return list;
    }
}
