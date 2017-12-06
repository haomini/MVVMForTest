package com.example.zhiyicx.testdagger2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.common.base.BaseListViewModel;
import com.example.zhiyicx.testdagger2.base.BaseApplication;
import com.example.zhiyicx.testdagger2.dagger.at.ASimpleType;
import com.example.zhiyicx.testdagger2.dagger.bean.ASimpleBean;
import com.example.zhiyicx.testdagger2.dagger.component.DaggerYComp;
import com.example.zhiyicx.testdagger2.dagger.module.AdeModule;
import com.example.zhiyicx.testdagger2.dagger.module.YModule;
import com.example.zhiyicx.testdagger2.databinding.MainDataBindingBinding;
import com.example.zhiyicx.testdagger2.greendao.bean.User;
import com.example.zhiyicx.testdagger2.greendao.bean.UserDao;

import org.jetbrains.anko.ToastsKt;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    @ASimpleType("Bounds")
    ASimpleBean bean;

    @Inject
    UserDao mUserDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerYComp.builder()
                .appComp(BaseApplication.getAppComp())
                .yModule(new YModule())
                .adeModule(new AdeModule("JULEEEE"))
                .build()
                .injectMembers(this);

        bean.print();

        final MainDataBindingBinding binding = DataBindingUtil
                .setContentView(this, R.layout.main_data_binding);

        binding.setMainVm(new BaseListViewModel(this));
        User user = mUserDao.loadAll().get(0);
        binding.setUser(user);
        binding.setHandler(new MyHandler());
        binding.setUserList(mUserDao.loadAll());
        binding.setIsOk(true);
        binding.setUrl("http://haobeibei.zhibocloud.cn/data/upload/2017/1120/16/5a128e5edbd308372b5f.png");

        Observable.fromArray("1vvf", "2", "3", "4", "5", "8", "9", "10", "11", "22")
                .toList()
                .subscribe(strings -> {

                });
    }

    public void onClick(View v) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public class MyHandler {
        public void onUserClicked(View v, User user) {
            ToastsKt.toast(MainActivity.this, user.toString());
        }
    }


}
