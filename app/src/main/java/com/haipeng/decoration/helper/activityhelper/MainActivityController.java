package com.haipeng.decoration.helper.activityhelper;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.MainActivity;
import com.haipeng.decoration.base.BaseMainFragment;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.fragment.MainFragment;
import com.haipeng.decoration.fragment.MastersFragment;
import com.haipeng.decoration.fragment.MineFragment;
import com.haipeng.decoration.fragment.TemplatesFragment;
import com.haipeng.decoration.listener.OnButtonsSwitchListener;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MainActivityController implements OnButtonsSwitchListener {

    MainActivity mActivity;
    MainActivityViewHelper mViewHelper;

    public MainActivityController(MainActivity mainActivity, MainActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;

        init();
    }

    public void init() {
        mViewHelper.initView();
        mActivity.buttonPanel.setListener(this);
        mActivity.homePageFragment = HomePageFragment.newInstance("", "");
        mActivity.templatesFragment = TemplatesFragment.newInstance("", "");
        mActivity.mainFragment = MainFragment.newInstance("", "");
        mActivity.mastersFragment = MastersFragment.newInstance("", "");
        mActivity.mineFragment = MineFragment.newInstance("", "");

        mActivity.fragmentManager = mActivity.getSupportFragmentManager();
        FragmentTransaction ft = mActivity.fragmentManager.beginTransaction();

        ft.replace(R.id.fragment, mActivity.homePageFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    public void switchFragment(BaseMainFragment fragment) {
        FragmentTransaction ft = mActivity.fragmentManager.beginTransaction();
        ft.replace(R.id.fragment, fragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @Override
    public void OnClickOne() {
        switchFragment(mActivity.homePageFragment);
    }

    @Override
    public void OnClickTwo() {
        switchFragment(mActivity.templatesFragment);
    }

    @Override
    public void OnClickThree() {
        switchFragment(mActivity.mainFragment);
    }

    @Override
    public void OnClickFour() {
        switchFragment(mActivity.mastersFragment);
    }

    @Override
    public void OnClickFive() {
        switchFragment(mActivity.mineFragment);
    }
}
