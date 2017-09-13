package com.haipeng.decoration.adapter.viewholder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haipeng.decoration.widget.viewpager.ChildRecommendNaviViewPager;

/**
 * Created by wanin on 2017/7/20.
 */

public class RecommendPagerViewHolder extends RecyclerView.ViewHolder {
    public RecommendPagerViewHolder(View itemView) {
        super(itemView);
    }

   public ChildRecommendNaviViewPager viewPager;
}
