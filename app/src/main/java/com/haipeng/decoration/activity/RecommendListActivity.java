package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.haipeng.decoration.base.BaseMainActivity;

/**
 * Created by Administrator on 2017/8/18.
 */

public class RecommendListActivity extends BaseMainActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void getConnectNetSuccess() {
//        mController.refreshForConnectNet();
    }

    @Override
    public void loginSuccess() {
//        mController.refreshForLoginSuccess();
    }
}
