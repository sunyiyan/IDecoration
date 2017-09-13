package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.adapter.VendorListAdapter;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.VendorListActivityController;
import com.haipeng.decoration.helper.activityhelper.VendorListActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class VendorListActivity extends BaseMainActivity {

    private VendorListActivityViewHelper mViewHelper;
    private VendorListActivityController mController;

    public RecyclerView verticalRecyclerView;
    public VendorListAdapter orderListAdapter;
    public SwipeRefreshLayout swipeRefreshLayout;

    public VendorListAdapter listAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        mViewHelper = new VendorListActivityViewHelper(this);
        mController = new VendorListActivityController(this,mViewHelper);
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
