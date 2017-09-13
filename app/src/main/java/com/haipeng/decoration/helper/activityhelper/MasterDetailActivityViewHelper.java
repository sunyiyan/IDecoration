package com.haipeng.decoration.helper.activityhelper;

import android.widget.ImageView;
import android.widget.TextView;
import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.MasterDetailActivity;

/**
 * Created by Administrator on 2017/7/4.
 */

public class MasterDetailActivityViewHelper {

    MasterDetailActivity mActivity;

    public MasterDetailActivityViewHelper(MasterDetailActivity mainActivity) {
        mActivity = mainActivity;
    }

    public void initView() {
        mActivity.imageAavator = (ImageView) mActivity.findViewById(R.id.iv_avator);
        mActivity.imageLicense = (ImageView) mActivity.findViewById(R.id.iv_license);
        

        mActivity.tvName = (TextView) mActivity.findViewById(R.id.tv_name);
        mActivity.tvPhone = (TextView) mActivity.findViewById(R.id.tv_phone);
        mActivity.tvEmail = (TextView) mActivity.findViewById(R.id.tv_email);
        mActivity.tvAddress = (TextView) mActivity.findViewById(R.id.tv_address);
        mActivity.tvLegalRep = (TextView) mActivity.findViewById(R.id.tv_legal_representative);
    }


}
