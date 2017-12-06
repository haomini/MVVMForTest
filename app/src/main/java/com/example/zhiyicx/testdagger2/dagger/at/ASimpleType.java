package com.example.zhiyicx.testdagger2.dagger.at;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/29
 * @Contact 605626708@qq.com
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ASimpleType {
    String value();
}
