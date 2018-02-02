package com.example.zhiyicx.testdagger2

import org.junit.Test
import java.net.HttpURLConnection
import java.net.URL

/**
 * @Describe
 * @Author zhouhao
 * @Date 2018/1/17
 * @Contact 605626708@qq.com
 */
class TestCommon {
    @Test
    fun test(){
        val urlStr = "http://www.baidu.com"
        val url = URL(urlStr)
        val conn = url.openConnection() as HttpURLConnection
        conn.readTimeout = 10 * 1000
        conn.connectTimeout = 10 * 1000
        if(conn.responseCode == HttpURLConnection.HTTP_OK){
//            conn.inputStream.bufferedReader().forEachLine {
//                System.out.println(it)
//            }
        }
    }
}