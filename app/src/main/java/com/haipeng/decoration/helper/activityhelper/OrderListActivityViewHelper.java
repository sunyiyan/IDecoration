package com.haipeng.decoration.helper.activityhelper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.OrderListActivity;

/**
 * Created by Administrator on 2017/8/19.
 */

public class OrderListActivityViewHelper {

    OrderListActivity mActivity;

    public OrderListActivityViewHelper(OrderListActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void initView() {

        mActivity.verticalRecyclerView = (RecyclerView) mActivity.findViewById(R.id.recycler_view_vertical);
        LinearLayoutManager VLM = new LinearLayoutManager(mActivity);
        VLM.setOrientation(LinearLayoutManager.VERTICAL);
        mActivity.verticalRecyclerView.setHasFixedSize(true);
        mActivity.verticalRecyclerView.setLayoutManager(VLM);

        mActivity.swipeRefreshLayout = (SwipeRefreshLayout) mActivity.findViewById(R.id.sr_view_vertical);
    }
}
