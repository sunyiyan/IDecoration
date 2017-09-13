package com.haipeng.decoration.ror;

import com.haipeng.decoration.application.MyApplication;
import com.haipeng.decoration.ror.PersistentCookieStore;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by Administrator on 2017/8/16.
 */

public class CookieManager implements CookieJar {

    private final PersistentCookieStore cookieStore = new PersistentCookieStore(MyApplication.getInstance().getApplicationContext());

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if(cookies != null && cookies.size()>0){
            for (Cookie item:cookies){
                cookieStore.add(url,item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }
}
