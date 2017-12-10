package com.example.zhiyicx.testdagger2.remote;

import com.example.common.bean.BaseBean;
import com.example.zhiyicx.testdagger2.bean.ApkBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public interface HomeClient {

    @POST("System/Resources/resources")
    @FormUrlEncoded
    Observable<BaseBean<List<ApkBean>>> getResources(@Field("mode") String mode);
}
