package com.example.zhiyicx.testdagger2;

import org.junit.Test;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/4/16
 * @Contact 605626708@qq.com
 */
public class text {

    /**
     * 判断版本号, 是否需要升级
     */
    @Test
    public void compareVersionNeedUpdate() {

        String versionName = "1.0.0";
        String version = "1.0.0";
        final String[] appVersion = versionName.split("\\.");
        final String[] compareVersion = version.split("\\.");
        int maxLength = Math.max(appVersion.length, compareVersion.length);
        for (int i = 0; i < maxLength; i++) {
            if ((compareVersion.length <= i ? 0 : Integer.parseInt(compareVersion[i]))
                    < (appVersion.length <= i ? 0 : Integer.parseInt(appVersion[i]))) {
                System.out.print("false");
                return;
            }else if((compareVersion.length <= i ? 0 : Integer.parseInt(compareVersion[i]))
                    > (appVersion.length <= i ? 0 : Integer.parseInt(appVersion[i]))){
                System.out.print("true");
                return;
            }
        }
        System.out.print("false");
    }
}
