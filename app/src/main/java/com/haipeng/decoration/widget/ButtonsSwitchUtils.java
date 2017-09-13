package com.haipeng.decoration.widget;

import android.content.Context;
import android.widget.Button;

import com.haipeng.decoration.R;
import com.haipeng.decoration.listener.OnButtonsSwitchListener;

/**
 * Created by wanin on 2017/7/20.
 */

public class ButtonsSwitchUtils {

    private Button type1, type2, type3, type4,type5;
    private Context mContext;


    public ButtonsSwitchUtils(Context context) {
        mContext = context;
    }

    // 按钮
    public void setBtnHomeworkTypes(Button type1, Button type2, Button type3, Button type4, Button type5) {
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.type5 = type5;
    }



    public void changeBtnHomeworkType(int type) {
        switch (type) {
            case 1:
                refreshPress(type1);
                break;
            case 2:
                refreshPress(type2);
                break;
            case 3:
                refreshPress(type3);
                break;
            case 4:
                refreshPress(type4);
                break;
            case 5:
                refreshPress(type5);
                break;
        }
    }



    public void refreshNormal(){
        btnHomeworkTypeNormal(type1);
        btnHomeworkTypeNormal(type2);
        btnHomeworkTypeNormal(type3);
        btnHomeworkTypeNormal(type4);
        btnHomeworkTypeNormal(type5);
    }

    public void refreshPress(Button type){
        refreshNormal();
        btnHomeworkTypePress(type);
    }

    public void btnHomeworkTypePress(Button btn) {
        btn.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
    }

    public void btnHomeworkTypeNormal(Button btn) {
        btn.setBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
//        btn.setTextColor(mContext.getResources().getColor(R.color.colorBtnSelectNormal));
    }
}
