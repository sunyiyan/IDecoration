package com.haipeng.decoration.utils.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/19.
 */

public class MyToastUtils {

    public static void showToastLong(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_LONG).show();
    }
}
