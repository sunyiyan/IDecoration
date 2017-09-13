package com.haipeng.decoration.helper.fragmenthelper;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.haipeng.decoration.adapter.ChildRecommendHoriAdapter;
import com.haipeng.decoration.adapter.HomePageAdapter;
import com.haipeng.decoration.fragment.HomePageFragment;
import com.haipeng.decoration.listener.OnCountListener;
import com.haipeng.decoration.listener.UploadMoreOnScrollListener;
import com.haipeng.decoration.utils.CountUtils;
import com.haipeng.decoration.widget.viewpager.ChildRecommendNaviViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class HomePagerFragementController implements SwipeRefreshLayout.OnRefreshListener {

    HomePageFragment mFragment;
    HomePageFragmentViewHelper mViewHelper;


    List<String> data = new ArrayList<String>();

    public void setData() {
        data.add("a");
        data.add("b");
        data.add("c");
    }

    public HomePagerFragementController(HomePageFragment pageFragment, HomePageFragmentViewHelper viewHelper) {
        mFragment = pageFragment;
        mViewHelper = viewHelper;
        setData();
        init();
    }

    public void init() {
        mViewHelper.initView();
        mFragment.swipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.BLUE, Color.YELLOW);
        //纵向recyclerView初始化
        LinearLayoutManager VLM = new LinearLayoutManager(mFragment.getActivity());
        VLM.setOrientation(LinearLayoutManager.VERTICAL);
        mFragment.verticalRecyclerView.setHasFixedSize(true);
        mFragment.verticalRecyclerView.setLayoutManager(VLM);
        mFragment.verticalAdapter = new HomePageAdapter(mFragment.getActivity());
        mFragment.verticalAdapter.setDataContent(data);
        mFragment.verticalRecyclerView.setAdapter(mFragment.verticalAdapter);
        mFragment.swipeRefreshLayout.setOnRefreshListener(this);
        mFragment.verticalRecyclerView.setHasFixedSize(true);
        mFragment.verticalRecyclerView.addOnScrollListener(new UploadMoreOnScrollListener(VLM) {
            @Override
            public void onLoadMore(int currentPage) {
                onLoadMoreRecyclerView();
            }
        });
//        countUtils.setListener(this);
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    @Override
    public void onRefresh() {

        // adapter里面的
        Flowable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).map(new Function<Long, Object>() {
            @Override
            public Object apply(@NonNull Long aLong) throws Exception {
                mFragment.swipeRefreshLayout.setRefreshing(false);
                data.clear();
                data.add("赵");
                data.add("钱");
                data.add("孙");
                data.add("李");
                mFragment.verticalAdapter.setDataContent(data);
                Toast.makeText(mFragment.getActivity(), "Toast", Toast.LENGTH_LONG).show();
                return 2;
            }
        }).subscribe();
    }

    public void onLoadMoreRecyclerView() {
        Flowable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).map(new Function<Long, Object>() {
            @Override
            public Object apply(@NonNull Long aLong) throws Exception {
                data.add("赵");
                data.add("钱");
                data.add("孙");
                data.add("李");
                mFragment.verticalAdapter.setDataContent(data);
                Toast.makeText(mFragment.getActivity(), "Toast2", Toast.LENGTH_LONG).show();
                return 2;
            }
        }).subscribe();
    }
}
