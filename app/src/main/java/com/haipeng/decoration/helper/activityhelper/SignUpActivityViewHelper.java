package com.haipeng.decoration.helper.activityhelper;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.SignUpActivity;

/**
 * Created by Administrator on 2017/7/4.
 */

public class SignUpActivityViewHelper {

    SignUpActivity mActivity;

    public SignUpActivityViewHelper(SignUpActivity loginActivity) {
        mActivity = loginActivity;
        initView();
    }

    public void initView(){
        mActivity.back = (Button) mActivity.findViewById(R.id.back);
        mActivity.commit = (Button) mActivity.findViewById(R.id.commit);
        mActivity.img = (ImageView) mActivity.findViewById(R.id.iv_add_user);

        mActivity.etName = (EditText) mActivity.findViewById(R.id.et_name);
        mActivity.etPhone = (EditText) mActivity.findViewById(R.id.et_phone);
        mActivity.etEmail = (EditText) mActivity.findViewById(R.id.et_email);
        mActivity.etPassword = (EditText) mActivity.findViewById(R.id.et_password);
        mActivity.etRePassword = (EditText) mActivity.findViewById(R.id.et_re_password);
    }




}
