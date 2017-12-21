package com.example.zhiyicx.testdagger2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public interface DownloadClient {

    @GET("public/hbb_0_1_5.apk")
    Call<ResponseBody> download(@Header("RANGE") String range);
}
