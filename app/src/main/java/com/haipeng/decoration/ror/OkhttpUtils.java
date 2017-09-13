package com.haipeng.decoration.ror;

import android.content.Context;
import android.net.ConnectivityManager;
import android.webkit.CookieSyncManager;

import com.haipeng.decoration.application.MyApplication;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/8/16.
 */

public class OkhttpUtils {

    private static OkHttpClient mOkHttpClient;

    private static File cacheDirctory =
            new File(MyApplication.getInstance().getApplicationContext().getCacheDir().getAbsolutePath(), "MyOkHttpCache");
    private static Cache cache = new Cache(cacheDirctory, 10 * 1024 * 1024);

    public static OkHttpClient getOkhttpClient() {
        if (null == mOkHttpClient) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .cookieJar(new CookieManager())
                    //.addInterceptor(new MyIntercepter())
                    //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    //设置请求读写的超时时间
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .build();
        }

        return mOkHttpClient;
    }




}
