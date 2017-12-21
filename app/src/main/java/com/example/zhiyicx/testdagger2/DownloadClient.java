package com.example.zhiyicx.testdagger2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public interface DownloadClient {

    @GET
    Call<ResponseBody> download(@Url String url,  @Header("RANGE") String range);
}
