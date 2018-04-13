package com.example.zhiyicx.testdagger2;

import com.example.common.dagger2.module.HttpModule;
import com.example.zhiyicx.testdagger2.remote.HomeClient;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;


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
        String str = "{\"a\":123, \"b\":\"abc\"}";
        MyBean bean = new Gson().fromJson(str, MyBean.class);
        System.out.print(bean);
    }

    @Test
    public void test3() {
        Pattern pattern = Pattern.compile("^[.]*$");
        System.out.print(pattern.matcher("ma").find());
    }

    @Test
    public void testOptional() {
        Optional<Integer> possible = Optional.of(1231);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());

        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.hashCode(new Object()));
        System.out.println(MoreObjects.toStringHelper("MyObject")
                .add("x", 1)
                .toString());


        ImmutableSet<String> immutableList = ImmutableSet.of("A", "B", "C");
        ImmutableMap<Integer, String> lis = ImmutableMap.of(1, "A", 2, "B", 3, "C");
        System.out.println(immutableList);
    }

    public List<String> getTestList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        list.add(null);
        return list;
    }
}

class MyBean{
    int a;
    String b;

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }
}