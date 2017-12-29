package com.example.zhiyicx.testdagger2;

import com.example.common.dagger2.module.HttpModule;
import com.example.zhiyicx.testdagger2.remote.HomeClient;

import org.junit.Test;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/27
 * @Contact 605626708@qq.com
 */
public class DownloadUtilsTest {
    @Test
    public void classicDownload() throws Exception {
        HomeClient homeClient = HttpModule.provideRetrofit().create(HomeClient.class);
        homeClient.getResources("PIC-AL00")
                .subscribe(listBaseBean -> System.out.print("accept(): " + listBaseBean));
    }

    @Test
    public void nioDownload() throws Exception {
    }

}