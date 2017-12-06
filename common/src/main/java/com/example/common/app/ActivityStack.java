package com.example.common.app;

import com.example.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/4
 * @Contact 605626708@qq.com
 */
public class ActivityStack {
    private static final ActivityStack ourInstance = new ActivityStack();
    private List<BaseActivity> mActivityList;

    public static ActivityStack getInstance() {
        return ourInstance;
    }

    private ActivityStack() {
        mActivityList = new ArrayList<>();
    }

    /**
     * 添加baseActivity
     *
     * @param activity
     */
    public void addActivity(BaseActivity activity) {
        mActivityList.add(activity);
    }

    /**
     * 移除baseActivity
     *
     * @param activity
     */
    public void removeActivity(BaseActivity activity) {
        mActivityList.remove(activity);
    }

    /**
     * 清空栈, 并结束掉栈中所有activity
     */
    public void clear() {
        while (mActivityList.size() > 0)
            mActivityList.get(mActivityList.size() - 1).finish();
    }
}
