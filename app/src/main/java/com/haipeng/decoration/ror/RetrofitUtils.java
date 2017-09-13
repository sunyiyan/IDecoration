package com.haipeng.decoration.ror;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/8/16.
 */

public class RetrofitUtils {


    //    public static String api_url = "http://192.168.43.121:8080";//手机共享
//    public static String api_url = "http://192.168.101.12:8080"; // 公司R01路由
    public static String api_url = "http://192.168.8.4:8080"; // 宿舍路由
//    public static String api_url = "http://59.110.221.173:8080"; // ali_cloud

    public static String UPLOAD_IMAGE = "";
    public static String qiniuImageAdress = "";

    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    protected static Retrofit getRetrofit(){
        if(null == mRetrofit){
            if(null == mOkHttpClient){
                mOkHttpClient = OkhttpUtils.getOkhttpClient();
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(api_url+"/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit;
    }

}
