package com.example.zhiyicx.testdagger2;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.example.common.base.BaseFragment;
import com.example.common.base.BaseListViewModel;
import com.example.zhiyicx.testdagger2.databinding.ActivityMain2Binding;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import io.reactivex.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/5
 * @Contact 605626708@qq.com
 */

public class MainFragment extends BaseFragment<ActivityMain2Binding> {

    @Override
    protected void initView() {
        super.initView();
        mViewBindings.setMainVm(new BaseListViewModel(getContext()));

        Observable.fromArray("1vvf", "2", "3", "4", "5", "8", "9", "10", "11", "22")
                .toList()
                .subscribe(strings -> {
                    mViewBindings.recycler.setAdapter(new CommonAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, strings) {
                        @Override
                        protected void convert(ViewHolder holder, String o, int position) {
                            ((TextView) holder.getView(android.R.id.text1)).setText(o);
                        }
                    });
                    mViewBindings.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

}
