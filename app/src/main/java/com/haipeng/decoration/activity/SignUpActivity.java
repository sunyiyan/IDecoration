package com.haipeng.decoration.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.helper.activityhelper.SignUpActivityViewHelper;
import com.haipeng.decoration.helper.activityhelper.SignUpActivityController;

/**
 * Created by Administrator on 2017/8/17.
 */

public class SignUpActivity extends BaseMainActivity{


    public Button back;
    public Button commit;
    public ImageView img;
    public EditText etName, etPhone, etEmail, etPassword, etRePassword;

    SignUpActivityViewHelper mViewHelper;
    SignUpActivityController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mViewHelper = new SignUpActivityViewHelper(this);
        mController = new SignUpActivityController(this, mViewHelper);
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
