package com.example.zhiyicx.testdagger2.remote;

import javax.inject.Inject;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/21
 * @Contact 605626708@qq.com
 */

public class ClientManager {

    private HomeClient mHomeClient;

    @Inject
    public ClientManager(HomeClient homeClient){
        mHomeClient = homeClient;
    }

    public HomeClient provideHomeClient(){
        return mHomeClient;
    }
}
