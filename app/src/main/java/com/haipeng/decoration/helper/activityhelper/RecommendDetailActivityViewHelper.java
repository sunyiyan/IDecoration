package com.haipeng.decoration.helper.activityhelper;

import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.RecommendDetailActivity;

/**
 * Created by Administrator on 2017/7/4.
 */

public class RecommendDetailActivityViewHelper {

    RecommendDetailActivity mActivity;

    public RecommendDetailActivityViewHelper(RecommendDetailActivity mainActivity) {
        mActivity = mainActivity;
    }

    public void initView(){
        mActivity.tvTitle = (TextView) mActivity.findViewById(R.id.tv_title);
        mActivity.tvType = (TextView) mActivity.findViewById(R.id.tv_type);
        mActivity.ivAvator = (ImageView) mActivity.findViewById(R.id.iv_avator);
    }


}
