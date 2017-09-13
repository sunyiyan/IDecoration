package com.haipeng.decoration.ror;

import android.content.Context;
import android.widget.Toast;

import com.haipeng.decoration.application.MyApplication;
import com.haipeng.decoration.utils.NetWorkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/16.
 */

public class MyIntercepter implements Interceptor {

    Context mContext = MyApplication.getInstance().getApplicationContext();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(!NetWorkUtils.isNetworkReachable(mContext)){
            Toast.makeText(mContext,"has not find network now",Toast.LENGTH_LONG).show();
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)// 无网络时从缓存中读取
                    .build();
        }

        Response response = chain.proceed(request);
        if(NetWorkUtils.isNetworkReachable(mContext)){
            int maxAge = 60*60;// 有网络时 设置缓存超时时间1个小时
            response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public,max-age="+maxAge)
                    .build();
        }else{
            int maxStale = 60*60*24*28; // // 无网络时，设置超时为4周
            response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public,only-if-cached,max-stale="+maxStale)
                    .build();
        }

        return response;
    }
}
