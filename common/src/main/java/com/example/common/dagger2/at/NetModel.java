package com.example.common.dagger2.at;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/11
 * @Contact 605626708@qq.com
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface NetModel {
    String value() default "normal";
}
