package com.haipeng.decoration.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.adapter.viewholder.RecommendHoriViewHolder;
import com.haipeng.decoration.adapter.viewholder.RecommendNormalViewHolder;
import com.haipeng.decoration.adapter.viewholder.RecommendPagerViewHolder;
import com.haipeng.decoration.utils.CountUtils;
import com.haipeng.decoration.widget.viewpager.ChildRecommendNaviViewPager;
import com.haipeng.decoration.widget.viewpager.ChildRecommendNaviViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomePageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Activity mContext;
    int TYPE_PAGER = 1, TYPE_HORI = 2, TYPE_NORMAL = 3;
    ChildRecommendNaviViewPagerAdapter childPagerAdapter;
    ChildRecommendHoriAdapter childHoriAdapter;
    private List<ImageView> viewList;
    private List<String> horiList;
    private CountUtils countUtils;
    private List<String> mDatas;

    List<String> data = new ArrayList<String>();

    public void setData() {
        data.add("a");
        data.add("b");
        data.add("c");
    }

    public HomePageAdapter(Activity context) {
        this.mDatas = mDatas;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        setData();
        countUtils = new CountUtils();
    }

    public void setDataContent(List<String> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    public void setListImageViews(List<ImageView> list) {
        viewList = list;
    }

    public void setListHori(List<String> list) {
        horiList = list;
    }

    public void setListVertical(List<String> list) {
        mDatas = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_PAGER) {
            view = mInflater.inflate(R.layout.item_pager_recommend, parent, false);
            RecommendPagerViewHolder pagerViewHolder = new RecommendPagerViewHolder(view);
            pagerViewHolder.viewPager = (ChildRecommendNaviViewPager) view.findViewById(R.id.view_pager_navigation);
            countUtils.setListener(pagerViewHolder.viewPager);
            return pagerViewHolder;
        } else if (viewType == TYPE_HORI) {
            view = mInflater.inflate(R.layout.item_recycle_hori_recommend, parent, false);
            RecommendHoriViewHolder horiViewHolder = new RecommendHoriViewHolder(view);
            horiViewHolder.horiRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_horizontal);
            return horiViewHolder;
        } else {
            view = mInflater.inflate(R.layout.item_recycle_vertical_recommend, parent, false);
            RecommendNormalViewHolder normalViewHolder = new RecommendNormalViewHolder(view);
            normalViewHolder.ivRecommend = (ImageView) view.findViewById(R.id.iv_recommend_avator);
            normalViewHolder.tvRecommend = (TextView) view.findViewById(R.id.tv_recommend);
            return normalViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecommendPagerViewHolder) {
            RecommendPagerViewHolder pagerViewHolder = (RecommendPagerViewHolder) holder;
            childPagerAdapter = new ChildRecommendNaviViewPagerAdapter(mContext);
            pagerViewHolder.viewPager.setAdapter(childPagerAdapter);
            pagerViewHolder.viewPager.init(mContext,childPagerAdapter);
        } else if (holder instanceof RecommendHoriViewHolder) {
            RecommendHoriViewHolder horiViewHolder = (RecommendHoriViewHolder) holder;
            // 横向recyclerView初始化
            LinearLayoutManager hLM = new LinearLayoutManager(mContext);
            hLM.setOrientation(LinearLayoutManager.HORIZONTAL);
            horiViewHolder.horiRecyclerView.setLayoutManager(hLM);
            childHoriAdapter = new ChildRecommendHoriAdapter(mContext, data);
            horiViewHolder.horiRecyclerView.setAdapter(childHoriAdapter);
        } else {
            RecommendNormalViewHolder normalViewHolder = (RecommendNormalViewHolder) holder;
            normalViewHolder.ivRecommend.setImageResource(R.mipmap.ic_launcher);
            normalViewHolder.tvRecommend.setText(mDatas.get(position - 2));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_PAGER;
        } else if (position == 1) {
            return TYPE_HORI;
        } else {
            return TYPE_NORMAL;
        }
    }
}
