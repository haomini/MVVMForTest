package com.example.common.dagger2.at;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */
@Scope
@Retention(RUNTIME)
public @interface LifeScope {
}
