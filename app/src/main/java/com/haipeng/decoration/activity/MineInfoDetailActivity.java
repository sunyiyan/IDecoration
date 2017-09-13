package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.MineInfoDetailActivityController;
import com.haipeng.decoration.helper.activityhelper.MineInfoDetailActivityViewHelper;

/**
 * Created by Administrator on 2017/8/18.
 */

public class MineInfoDetailActivity extends BaseMainActivity {

    public Button back;
    public Button commit;
    public ImageView img;
    public EditText etName, etPhone, etEmail, etPassword, etRePassword;
    MineInfoDetailActivityViewHelper mViewHelper;
    MineInfoDetailActivityController mController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_info_detail);

        mViewHelper = new MineInfoDetailActivityViewHelper(this);
        mController = new MineInfoDetailActivityController(this,mViewHelper);
    }

    @Override
    public void getConnectNetSuccess() {
//        mController.refreshForConnectNet();
    }

    @Override
    public void loginSuccess() {
//        mController.refreshForLoginSuccess();
    }
}
