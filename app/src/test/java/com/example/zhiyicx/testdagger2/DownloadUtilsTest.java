package com.example.zhiyicx.testdagger2;

import com.example.common.dagger2.module.HttpModule;
import com.example.zhiyicx.testdagger2.remote.HomeClient;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import rx.Observable;

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

    @Test
    public void test2() {
        Observable.from(Arrays.asList("1", "2", "3"))
                .doOnNext(System.out::println)
                .map(s -> s + " - 5")
                .doOnNext(s -> System.out.println(s + "1"))
                .doOnNext(s -> System.out.println(s + "2"))
                .doOnNext(s -> System.out.println(s + "3"))
                .subscribe(System.out::println);
    }

    @Test
    public void test3(){
        Pattern pattern = Pattern.compile("^[.]*$");
        System.out.print(pattern.matcher("ma").find());
    }

}