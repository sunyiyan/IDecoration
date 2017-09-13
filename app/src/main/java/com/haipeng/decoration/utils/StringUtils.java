package com.haipeng.decoration.utils;

import android.text.Editable;

/**
 * Created by Administrator on 2017/8/19.
 */

public class StringUtils {

    public static String filterStringExe(Editable eta){
        String temp = "";
        if(null == eta)
            return "";
        else
        {
            temp = eta.toString().trim();
            return temp;
        }
    }
}
