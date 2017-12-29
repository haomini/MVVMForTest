package com.example.zhiyicx.testdagger2;

import android.os.Environment;

import com.example.zhiyicx.testdagger2.bean.ApkBean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/20
 * @Contact 605626708@qq.com
 */

public class DownloadUtils {
    public static final String urlStr = "http://sns.hbbclub.com/public/hbb_0_1_5.apk";
    public static final String FILE_PATH = "/haomini_test_files/";
    public static boolean load = true;

    public static void classicDownload(ApkBean apkBean, long breakPos, DownloadProgreser listener) throws IOException {
        URL url = new URL(apkBean.getDownload_url());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("RANGE", "bytes=" + breakPos + "-");
        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_PARTIAL) {
            save(urlConnection.getInputStream(), apkBean, breakPos, urlConnection.getContentLength(), listener);
        } else if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            save(urlConnection.getInputStream(), apkBean, 0, urlConnection.getContentLength(), listener);
        }
    }

    public static File createOrRecreateFile(String file) throws IOException {
        File absFile = new File(Environment.getExternalStorageDirectory() + FILE_PATH + file);
        if (!absFile.getParentFile().exists()) {
            absFile.getParentFile().mkdirs();
        }
        if (!absFile.exists()) {
            absFile.createNewFile();
        }
        return absFile;
    }

    private static void save(InputStream in, ApkBean apkBean, long startsPoint, long contentLength, DownloadProgreser listener) {
        FileChannel channelOut = null;
        // 随机访问文件，可以指定断点续传的起始位置
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(createOrRecreateFile(apkBean.getName() + ".apk"), "rwd");
            //Chanel NIO中的用法，由于RandomAccessFile没有使用缓存策略，直接使用会使得下载速度变慢，亲测缓存下载3.3秒的文件，用普通的RandomAccessFile需要20多秒。
            channelOut = randomAccessFile.getChannel();
            // 内存映射，直接使用RandomAccessFile，是用其seek方法指定下载的起始位置，使用缓存下载，在这里指定下载位置。
            MappedByteBuffer mappedBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE, startsPoint, contentLength);
            byte[] buffer = new byte[1024];
            int len, readlen = 0;
            while (load && ((len = in.read(buffer)) != -1)) {
                mappedBuffer.put(buffer, 0, len);
                readlen += len;
                listener.update(apkBean, startsPoint + readlen, contentLength, startsPoint + readlen == contentLength);
            }

            if (!load) {
                listener.pause(apkBean, startsPoint + readlen, contentLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                if (channelOut != null) {
                    channelOut.close();
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface DownloadProgreser {
        void update(ApkBean apkBean, long totalPos, long contentLength, boolean done);

        void pause(ApkBean apkBean, long totalPos, long contentLength);
    }
}
