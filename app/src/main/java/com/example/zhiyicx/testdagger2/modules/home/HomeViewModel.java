package com.example.zhiyicx.testdagger2.modules.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.app.BaseApplication;
import com.example.common.base.BaseListViewModel;
import com.example.common.base.BaseObserver;
import com.example.common.bean.BaseBean;
import com.example.common.dagger2.module.HttpModule;
import com.example.common.databind.command.i.ICommand;
import com.example.common.util.DeviceUtils;
import com.example.common.widget.EmptyLayout;
import com.example.zhiyicx.testdagger2.R;
import com.example.zhiyicx.testdagger2.bean.ApkBean;
import com.example.zhiyicx.testdagger2.modules.detail.ApkDetailActivity;
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
            mHomeClient.getResources(DeviceUtils.getSysModel())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .subscribe(new BaseObserver<List<ApkBean>, BaseBean<List<ApkBean>>>() {
                        @Override
                        protected void onFailed(int status, String msg) {
                            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
//                            mSmartRefreshLayoutState.set(0);
//                            mEmptyState.set(EmptyLayout.NODATA);

                            mSmartRefreshLayoutState.set(0);
                            mEmptyState.set(EmptyLayout.HIDE_LAYOUT);

                            ApkBean bean = new ApkBean();
                            bean.setName("汤姆猫跑酷-会说话");
                            bean.setIntroduction("探索无穷无尽的跑酷世界");
                            bean.setDescription("2006年，跑酷运动进入中国，并开始在中国推广。跑酷不仅是门运动的艺术，它的热衷者更愿把它看成是一种青年亚文化所倡导生活方式，跑跳攀爬中的自由灵魂在运动中无限伸展。在中国，喜欢跑酷的人越来越多。据中国极限运动协会统计：全国共有150余家有组织的跑酷俱乐部，从事这项运动的民间运动员已达到10万多人，并保持着强劲的增长势头。“首届全国极限跑酷大赛”于2009年10月31日-11月1日，在北京蓝色港湾举行。它是结合运动、音乐、时尚为一体的时尚体育赛事。作为目前国内唯一官方认定的极限跑酷赛事，它将承载着更重大的意义：将民间的、自由的、无组织的极限跑酷运动，发展成为正规的、有组织的体育项目，并使之能够广泛传播，被社会大众所认可。同时，要通过举办体育赛事的平台，将跑酷运动中所蕴含的健康向上、充满信心、勇于挑战、克服困难的运动态度和生活理念传播开来，倡导自由、健康、积极的生活方式。\n" +
                                    "\n" +
                                    "     跑酷运动在中国的发展很迅速，由于这项运动的性质和运动特点决定了它的练习者绝大部分是青少年，通过调查发现其中主要是自由工作者、公司白领和学生为主。主要有以社团、俱乐部等基本形式存在。活动形式分为两种，一种是自发组织的训练、表演、比赛等，实现的跑酷运动发展的多样性和持续性，另一种是由国家、商业、广告等组织的竞技比赛，这增大了跑酷运动影响，为跑酷运动注入了活力，为跑酷运动的发展起到了宣传作用。");
                            bean.setUpload_time("2038-01-19 11:07:14");
                            bean.setDeveloper("新一百科技有限公司");
                            bean.setMode("小米8");
                            bean.setVersion("v2.0.1");

                            bean.setDownload_url("http://111.178.233.108/file3.data.weipan.cn/60475765/8df0704e0f72ccc624b8ccfdcba559d612133112?ip=1512660646,118.113.45.117&ssig=1IufroStYV&Expires=1512661246&KID=sae,l30zoo1wmz&fn=%E9%92%A2%E9%93%81%E6%98%AF%E6%80%8E%E6%A0%B7%E7%82%BC%E6%88%90%E7%9A%84%20");
                            mListDatas.add(bean);
                            mHeaderAndFooterWrapper.notifyDataSetChanged();
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
                TextView opt = holder.getView(R.id.opt);

                holder.setText(R.id.apk_name, apkBean.getName());
                holder.setText(R.id.apk_desc, apkBean.getIntroduction());
                holder.setText(R.id.apk_update, "更新时间: " + apkBean.getUpload_time());

//                opt.setOnClickListener(v -> Toast.makeText(mContext, "下载", Toast.LENGTH_SHORT).show());

                holder.getConvertView().setOnClickListener(view ->
                        mContext.startActivity(new Intent(mContext, ApkDetailActivity.class).putExtra("bean", apkBean)));
            }
        };
    }
}
