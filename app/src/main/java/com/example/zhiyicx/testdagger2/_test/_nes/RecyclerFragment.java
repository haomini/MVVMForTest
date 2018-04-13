package com.example.zhiyicx.testdagger2._test._nes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.example.common.widget.EmptyLayout;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.databinding.FragmentTestBinding;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/1/16
 * @Contact 605626708@qq.com
 */

public class RecyclerFragment extends Fragment {

    public static final String IS_EMPTY = "EMPTY";
    public boolean isEmpty = false;
    public RecyclerView.Adapter mAdapter;
    private List<String> list;

    public static RecyclerFragment newInstance(boolean isEmpty) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_EMPTY, isEmpty);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isEmpty = getArguments().getBoolean(IS_EMPTY);
        FragmentTestBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
//        mBinding.smartRefreshLayout.setEnableRefresh(false);
        mBinding.empty.setState(isEmpty ? EmptyLayout.NODATA : EmptyLayout.HIDE_LAYOUT);
//        mBinding.getRoot().findViewById(R.id.nes).setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        if (!isEmpty) {
            mBinding.recycler.setAdapter(mAdapter = new CommonAdapter<String>(getContext(),
                    R.layout.list_item_swipe, list = getTestList()) {
                @Override
                protected void convert(ViewHolder holder, String s, int position) {
                    ((TextView) holder.getView(R.id.content)).setText(s);
                    SwipeLayout swipeLayout = holder.getView(R.id.swipe);
                }
            });
            mBinding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return mBinding.getRoot();
    }

    public List<String> getTestList() {
        List<String> list = new ArrayList<>();
        list.add("11232");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        list.add("17");
        return list;
    }
}
