package com.example.zhiyicx.testdagger2.modules;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.app.BaseApplication;
import com.example.common.base.BaseListViewModel;
import com.example.common.base.BaseObserver;
import com.example.common.bean.BaseBean;
import com.example.common.dagger2.module.HttpModule;
import com.example.common.databind.command.i.ICommand;
import com.example.common.widget.EmptyLayout;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.remote.HomeClient;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class HomeViewModel extends BaseListViewModel<ApkBean> {

    private HomeClient mHomeClient;

    public HomeViewModel(Context context) {
        super(context);
        mHomeClient = HttpModule.provideRetrofit(BaseApplication.getApp()).create(HomeClient.class);
    }

    @Override
    protected ICommand getRefreshCommand() {
        return () -> {
            mSmartRefreshLayoutState.set(1);
            mHomeClient.getResources("小米8")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(new BaseObserver<List<ApkBean>, BaseBean<List<ApkBean>>>() {
                        @Override
                        protected void onFailed(int status, String msg) {
                            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                            mSmartRefreshLayoutState.set(0);
                            mEmptyState.set(EmptyLayout.NODATA);
                        }

                        @Override
                        protected void onSuccess(String msg, List<ApkBean> data) {
                            Log.e("TAG", "onSuccess: " + mEmptyState.get());
                            mSmartRefreshLayoutState.set(0);
                            mEmptyState.set(EmptyLayout.HIDE_LAYOUT);
                            mListDatas.clear();
                            mListDatas.addAll(data);
                            mHeaderAndFooterWrapper.notifyDataSetChanged();
                        }
                    });
        };
    }

    @Override
    protected ICommand getEmptyCommand() {
        return () -> {
            mEmptyState.set(EmptyLayout.LOADING);
            onRefreshCommand.run();
        };
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new CommonAdapter<ApkBean>(mContext, R.layout.home_item_layout, mListDatas) {
            @Override
            protected void convert(ViewHolder holder, ApkBean apkBean, int position) {
                TextView opt = holder.getView(R.id.opt);

                holder.setText(R.id.apk_name, apkBean.getName());
                holder.setText(R.id.apk_desc, apkBean.getIntroduction());
                holder.setText(R.id.apk_update, "更新时间: " + apkBean.getUpload_time());

                opt.setOnClickListener(v -> Toast.makeText(mContext, "下载", Toast.LENGTH_SHORT).show());
            }
        };
    }
}
