package com.example.zhiyicx.testdagger2.modules.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.common.base.BaseListViewModel;
import com.example.common.base.BaseObserver;
import com.example.common.bean.BaseBean;
import com.example.common.databind.command.i.ICommand;
import com.example.common.widget.EmptyLayout;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.app.AppApplication;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.modules.detail.ApkDetailActivity;
import com.example.zhiyicx.testdagger2.remote.ClientManager;
import com.example.zhiyicx.testdagger2.remote.HomeClient;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class HomeViewModel extends BaseListViewModel<ApkBean> {

    @Inject
    ClientManager mClientManager;

    private HomeClient mHomeClient;

    HomeViewModel(Context context) {
        super(context);

        DaggerHomeComp
                .builder()
                .appComp(AppApplication.getAppComp())
                .build()
                .injectMembers(this);

        mHomeClient = mClientManager.provideHomeClient();
    }

    @Override
    protected ICommand getRefreshCommand() {
        return () -> {
            mSmartRefreshLayoutState.set(1);
            mHomeClient.getResources("PIC-AL00"/*DeviceUtils.getSysModel()*/)
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
                holder.setText(R.id.apk_name, apkBean.getName());
                holder.setText(R.id.apk_desc, apkBean.getIntroduction());
                holder.setText(R.id.apk_update, "更新时间: " + apkBean.getUpload_time());

                holder.getConvertView().setOnClickListener(view ->
                        mContext.startActivity(new Intent(mContext, ApkDetailActivity.class).putExtra("bean", apkBean)));
            }
        };
    }
}
