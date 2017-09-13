package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haipeng.decoration.R;
import com.haipeng.decoration.adapter.HomePageAdapter;
import com.haipeng.decoration.adapter.OrderListAdapter;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.OrderListActivityController;
import com.haipeng.decoration.helper.activityhelper.OrderListActivityViewHelper;
import com.haipeng.decoration.helper.fragmenthelper.MainFragmentController;
import com.haipeng.decoration.helper.fragmenthelper.MainFragmentViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class OrderListActivity  extends BaseMainActivity {

    private OrderListActivityViewHelper mViewHelper;
    private OrderListActivityController mController;

    public RecyclerView verticalRecyclerView;
    public OrderListAdapter orderListAdapter;
    public SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        mViewHelper = new OrderListActivityViewHelper(this);
        mController = new OrderListActivityController(this,mViewHelper);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewHelper.initView();
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
