package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.OrderDetailActivityController;
import com.haipeng.decoration.helper.activityhelper.OrderDetailActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class OrderDetailActivity extends BaseMainActivity {

    public TextView tvName;
    public TextView tvPhone;
    public TextView tvEmail;
    public TextView tvAddress;
    public TextView tvArea;
    public TextView tvStyle;
    public TextView tvRequire;
    public ImageView imageAvator;
    private OrderDetailActivityViewHelper mViewHelper;
    private OrderDetailActivityController mController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        mViewHelper = new OrderDetailActivityViewHelper(this);
        mController = new OrderDetailActivityController(this,mViewHelper);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewHelper.init();
        mController.init();
    }

    @Override
    public void getConnectNetSuccess() {
        mController.refreshForConnectNet();
    }

    @Override
    public void loginSuccess() {
        mController.refreshForLoginSuccess();
    }
}
