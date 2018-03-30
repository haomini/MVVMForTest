package com.example.zhiyicx.testdagger2;

import com.example.common.dagger2.module.HttpModule;
import com.example.zhiyicx.testdagger2.remote.HomeClient;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;

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
        System.out.println(immutableList);
    }

    public List<String> getTestList(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(String.valueOf(i));
        }
        list.add(null);
        return list;
    }
}