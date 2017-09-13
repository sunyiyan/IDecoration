package com.haipeng.decoration.helper.fragmenthelper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haipeng.decoration.R;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.widget.viewpager.ChildRecommendNaviViewPager;

/**
 * Created by Administrator on 2017/7/10.
 */

public class HomePageFragmentViewHelper {
    HomePageFragment mFragment;
    View mView;

    public HomePageFragmentViewHelper(HomePageFragment homePageFragment) {
        mFragment = homePageFragment;
        mView = mFragment.mContentView;
    }

    public void initView(){
        mFragment.verticalRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view_vertical);
        mFragment.swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.sr_view_vertical);
    }


}
