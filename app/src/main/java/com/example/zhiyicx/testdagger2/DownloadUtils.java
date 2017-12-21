package com.example.zhiyicx.testdagger2;

import android.os.Environment;
import android.util.Log;

import com.example.common.util.download.ProgressResponseBody;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/20
 * @Contact 605626708@qq.com
 */

public class DownloadUtils {
    public static final String urlStr = "http://sns.hbbclub.com/public/hbb_0_1_5.apk";
    public static final String FILE_PATH = "/haomini_test_files/";

    public static void classicDownload() throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("RANGE", "bytes=0-");
        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_PARTIAL
                || urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            Log.e("DownloadUtils_classic ", "result_code: " + urlConnection.getResponseCode());

            save(urlConnection.getInputStream(), 0, urlConnection.getContentLength());
        }
    }

    public static void nioDownload(long startPos, ProgressResponseBody.ProgressListener progressListener) {
        Interceptor interceptor = chain -> {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
        };
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sns.hbbclub.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        retrofit.create(DownloadClient.class).download("bytes=" + startPos + "-")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        if (response.code() == HttpURLConnection.HTTP_OK) {
                            // 重新下载
                        } else if (response.code() == HttpURLConnection.HTTP_PARTIAL) {
                            // 继续下载
                        }
                        save(response.body().byteStream(), startPos, response.body().contentLength());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
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

    private static void save(InputStream in, long startsPoint, long endPos) {
        FileChannel channelOut = null;
        // 随机访问文件，可以指定断点续传的起始位置
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(createOrRecreateFile("hbb_by_retrofit.apk"), "rwd");
            //Chanel NIO中的用法，由于RandomAccessFile没有使用缓存策略，直接使用会使得下载速度变慢，亲测缓存下载3.3秒的文件，用普通的RandomAccessFile需要20多秒。
            channelOut = randomAccessFile.getChannel();
            // 内存映射，直接使用RandomAccessFile，是用其seek方法指定下载的起始位置，使用缓存下载，在这里指定下载位置。
            MappedByteBuffer mappedBuffer = channelOut.map(FileChannel.MapMode.READ_WRITE, startsPoint, endPos);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                mappedBuffer.put(buffer, 0, len);
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
}
