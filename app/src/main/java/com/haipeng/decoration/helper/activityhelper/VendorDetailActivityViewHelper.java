package com.haipeng.decoration.helper.activityhelper;

import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.OrderDetailActivity;

/**
 * Created by Administrator on 2017/8/19.
 */

public class VendorDetailActivityViewHelper {

    OrderDetailActivity mActivity;

    public VendorDetailActivityViewHelper(OrderDetailActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void init(){
        mActivity.tvName = (TextView) mActivity.findViewById(R.id.tv_name);
        mActivity.tvPhone = (TextView) mActivity.findViewById(R.id.tv_phone);
        mActivity.tvEmail = (TextView) mActivity.findViewById(R.id.tv_email);
        mActivity.tvAddress = (TextView) mActivity.findViewById(R.id.tv_address);
        mActivity.tvArea = (TextView) mActivity.findViewById(R.id.tv_area);
        mActivity.tvStyle = (TextView)mActivity.findViewById(R.id.tv_style);
        mActivity.tvRequire = (TextView) mActivity.findViewById(R.id.tv_area);
        mActivity.imageAvator = (ImageView) mActivity.findViewById(R.id.iv_avator);

    }
}
