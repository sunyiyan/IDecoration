package com.haipeng.decoration.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.haipeng.decoration.constant.LoginConstant;

public class MySharedprefrencesConstantUtils {

    public static SharedPreferences preferences;
    public static String USER_UNIQUENUMBER_KEY ="USER_UNIQUENUMBER";

    public static void createConstantSharedPreferences(Context context) {
        preferences = context.getSharedPreferences("constant",Context.MODE_APPEND);
    }

    public static void setUserUniqueNumber(long uniqueNumber){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(USER_UNIQUENUMBER_KEY,uniqueNumber);
        editor.commit();
    }

    public static long getUserUniqueNumber(){
        LoginConstant.USER_UNIQUENUMBER = preferences.getLong(USER_UNIQUENUMBER_KEY,0l);
        return LoginConstant.USER_UNIQUENUMBER;
    }

}
