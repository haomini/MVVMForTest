package com.example.zhiyicx.testdagger2.dagger.bean;

import android.util.Log;

import com.example.zhiyicx.testdagger2.dagger.at.ASimpleType;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/11/27
 * @Contact 605626708@qq.com
 */

public class ASimpleBean extends ASimpleParBean{
    private String name;

    @ASimpleType("Normal")
    public ASimpleBean() {
    }

    @ASimpleType("Bounds")
    public ASimpleBean(ADepBean bean){
        this.name = bean.getJule();
    }

    public void print(){
        Log.e("ASimpleBean", "print(): " + name);
    }

    @Override
    public String toString() {
        return "ASimpleBean{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
