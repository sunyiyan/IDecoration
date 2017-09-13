package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.ImageView;
import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.MasterDetailActivityController;
import com.haipeng.decoration.helper.activityhelper.MasterDetailActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class MasterDetailActivity extends BaseMainActivity {

    public ImageView imageAavator,imageLicense;//,imgOther;
    public TextView tvName, tvPhone, tvEmail, tvAddress, tvLegalRep;
    private MasterDetailActivityViewHelper mViewHelper;
    private MasterDetailActivityController mController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        mViewHelper = new MasterDetailActivityViewHelper(this);
        mController = new MasterDetailActivityController(this, mViewHelper);
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
