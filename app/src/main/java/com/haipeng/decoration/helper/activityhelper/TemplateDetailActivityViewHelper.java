package com.haipeng.decoration.helper.activityhelper;

import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.TemplateDetailActivity;

/**
 * Created by Administrator on 2017/7/4.
 */

public class TemplateDetailActivityViewHelper {

    TemplateDetailActivity mActivity;

    public TemplateDetailActivityViewHelper(TemplateDetailActivity mainActivity) {
        mActivity = mainActivity;
    }

    public void initView() {
        mActivity.imageAvator = (ImageView) mActivity.findViewById(R.id.iv_avator);
        mActivity.tvTitle = (TextView) mActivity.findViewById(R.id.tv_title);
        mActivity.tvMasterId = (TextView) mActivity.findViewById(R.id.tv_master);
        mActivity.tvVendorId = (TextView) mActivity.findViewById(R.id.tv_vendor);

    }


}
