package com.haipeng.decoration.helper.fragmenthelper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.fragment.MainFragment;

/**
 * Created by Administrator on 2017/7/4.
 */

public class MainFragmentViewHelper {
    MainFragment mFragment;
    View mView;

    public MainFragmentViewHelper(MainFragment mainFragment) {
        mFragment = mainFragment;
        mView = mFragment.mContentView;
    }

    public void initView() {
        mFragment.etUserName = (EditText) mView.findViewById(R.id.et_name);
        mFragment.etUserPhone = (EditText) mView.findViewById(R.id.et_phone);
        mFragment.etUserEmail = (EditText) mView.findViewById(R.id.et_email);
        mFragment.etUserAddress = (EditText) mView.findViewById(R.id.et_address);
        mFragment.etDecorationStyle = (EditText) mView.findViewById(R.id.et_style);
        mFragment.etDecorationArea = (EditText) mView.findViewById(R.id.et_area);
        mFragment.etDecorationRequire = (EditText) mView.findViewById(R.id.et_require);
        mFragment.imageAvator = (ImageView) mView.findViewById(R.id.iv_avator);
        mFragment.btnCommit = (Button) mView.findViewById(R.id.btn_commit);

        mFragment.btnMyOrder = (Button) mFragment.mContentView.findViewById(R.id.btn_my_order);
        mFragment.llMyOrder = (LinearLayout) mFragment.mContentView.findViewById(R.id.ll_my_order);
        mFragment.llOutOfOrders = (LinearLayout) mFragment.mContentView.findViewById(R.id.ll_out_of_orders);

        mFragment.llMyOrder.setVisibility(View.GONE);
        mFragment.llOutOfOrders.setVisibility(View.INVISIBLE);
    }

}
