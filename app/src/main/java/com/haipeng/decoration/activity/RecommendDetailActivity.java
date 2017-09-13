package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.RecommendDetailActivityController;
import com.haipeng.decoration.helper.activityhelper.RecommendDetailActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class RecommendDetailActivity  extends BaseMainActivity {

    RecommendDetailActivityViewHelper mViewHelper;
    RecommendDetailActivityController mController;

    public TextView tvTitle;
    public TextView tvType;
    public ImageView ivAvator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_detail);
        mViewHelper = new RecommendDetailActivityViewHelper(this);
        mController = new RecommendDetailActivityController(this,mViewHelper);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewHelper.initView();
        mController.init();
    }

    @Override
    public void getConnectNetSuccess() {
//        mController.refreshForConnectNet();
        mViewHelper.initView();
        mController.init();
    }

    @Override
    public void loginSuccess() {
//        mController.refreshForLoginSuccess();
    }
}
