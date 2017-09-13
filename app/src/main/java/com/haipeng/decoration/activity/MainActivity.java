package com.haipeng.decoration.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.haipeng.decoration.R;
import com.haipeng.decoration.base.BaseMainActivity;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.fragment.MainFragment;
import com.haipeng.decoration.fragment.MastersFragment;
import com.haipeng.decoration.fragment.MineFragment;
import com.haipeng.decoration.fragment.TemplatesFragment;
import com.haipeng.decoration.helper.activityhelper.MainActivityController;
import com.haipeng.decoration.helper.activityhelper.MainActivityViewHelper;
import com.haipeng.decoration.utils.MySharedprefrencesConstantUtils;
import com.haipeng.decoration.widget.panel.MainButtonPanel;

import de.greenrobot.event.EventBus;


/**
 * 四个页面这样分，主页推荐，装修样板，设计团队，我的，中间是装修填写
 */

public class MainActivity extends BaseMainActivity implements
        HomePageFragment.OnFragmentInteractionListener,
        TemplatesFragment.OnFragmentInteractionListener,
        MainFragment.OnFragmentInteractionListener,
        MastersFragment.OnFragmentInteractionListener,
        MineFragment.OnFragmentInteractionListener {

    private MainActivityController mController;
    private MainActivityViewHelper mViewHelper;
    public FrameLayout frameLayout;
    public FragmentManager fragmentManager;
    //    public FragmentTransaction fragmentTransaction;
    public HomePageFragment homePageFragment;
    public TemplatesFragment templatesFragment;
    public MainFragment mainFragment;
    public MastersFragment mastersFragment;
    public MineFragment mineFragment;

    public MainButtonPanel buttonPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySharedprefrencesConstantUtils.createConstantSharedPreferences(this);
        mViewHelper = new MainActivityViewHelper(this);
        mController = new MainActivityController(this, mViewHelper);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void getConnectNetSuccess() {
        mController.refreshForConnectNet();
    }

    @Override
    public void loginSuccess() {
        mController.refreshForLoginSuccess();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
