package com.haipeng.decoration.helper.fragmenthelper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.fragment.MineFragment;

/**
 * Created by Administrator on 2017/8/12.
 */

public class MineFragmentViewHelper {
    MineFragment mFragment;

    public MineFragmentViewHelper(MineFragment mineFragment) {
        mFragment = mineFragment;
        initView();
    }

    public void initView() {
        mFragment.llSignOk = (LinearLayout) mFragment.mContentView.findViewById(R.id.ll_sign_in_ok);
        mFragment.llSignUp = (LinearLayout) mFragment.mContentView.findViewById(R.id.ll_init_sign);
        mFragment.btnSignUp = (Button) mFragment.mContentView.findViewById(R.id.btn_sign_up);
        mFragment.btnSignIn = (Button) mFragment.mContentView.findViewById(R.id.btn_sign_in);
        mFragment.tvName = (TextView) mFragment.mContentView.findViewById(R.id.tv_name);



    }
}
