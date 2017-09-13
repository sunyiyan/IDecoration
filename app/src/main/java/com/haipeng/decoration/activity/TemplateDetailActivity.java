package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.TemplateDetailActivityController;
import com.haipeng.decoration.helper.activityhelper.TemplateDetailActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class TemplateDetailActivity extends BaseMainActivity {

    public ImageView imageAvator;
    public TextView tvTitle, tvMasterId, tvVendorId;
    TemplateDetailActivityViewHelper mViewHelper;
    TemplateDetailActivityController mController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_detail);
        mViewHelper = new TemplateDetailActivityViewHelper(this);
        mController = new TemplateDetailActivityController(this, mViewHelper);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewHelper.initView();
        mController.init();
    }

    @Override
    public void getConnectNetSuccess() {

    }

    @Override
    public void loginSuccess() {
//        mController.refreshForLoginSuccess();
    }
}
