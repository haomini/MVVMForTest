package com.example.common.bean;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/9
 * @Contact 605626708@qq.com
 */

public class BaseBean<T> {

    /**
     * satus : 2
     * msg : 恭喜您，找到您的机型所对应的资源啦！
     */

    private int satus;
    private String msg;
    private T data;

    public int getSatus() {
        return satus;
    }

    public void setSatus(int satus) {
        this.satus = satus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}