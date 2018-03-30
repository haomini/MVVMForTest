package com.example.zhiyicx.testdagger2._test.recycler_list;

import android.support.v7.util.DiffUtil;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/3/22
 * @Contact 605626708@qq.com
 */

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * userDiff
     */
    public static final DiffUtil.ItemCallback<User> CALLBACK = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
