package com.haipeng.decoration.helper.activityhelper;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.LoginActivity;
import com.haipeng.decoration.activity.MainActivity;
import com.haipeng.decoration.widget.panel.MainButtonPanel;

/**
 * Created by Administrator on 2017/7/4.
 */

public class LoginActivityViewHelper {

    LoginActivity mActivity;

    public LoginActivityViewHelper(LoginActivity loginActivity) {
        mActivity = loginActivity;
    }

    public void initView(){
        mActivity.etAccount = (EditText) mActivity.findViewById(R.id.et_account);
        mActivity.etPassword = (EditText) mActivity.findViewById(R.id.et_password);
        mActivity.btnCommit = (Button) mActivity.findViewById(R.id.btn_commit);
    }


}
