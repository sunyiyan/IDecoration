package com.haipeng.decoration.widget.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.haipeng.decoration.activity.RecommendDetailActivity;
import com.haipeng.decoration.helper.activityhelper.RecommendDetailActivityController;
import com.haipeng.decoration.listener.OnCountListener;
import com.haipeng.decoration.utils.CountUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ChildRecommendNaviViewPagerAdapter extends PagerAdapter {


    List<RelativeLayout> mViewList;
    Activity mContext;
    private int childCount = 0;

    public ChildRecommendNaviViewPagerAdapter(Activity context) {
        mContext = context;
    }

    @Override
    public void notifyDataSetChanged() {
        childCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mViewList == null ? 0 : mViewList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        if (childCount > 0) {
            childCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    public void setData(List<RelativeLayout> linearLayouts) {
        mViewList = linearLayouts;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        int preNum = CountUtils.num - 1 < 0 ? 3 : CountUtils.num - 1;
        container.removeView(mViewList.get(position % mViewList.size()));

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViewList.get(position % mViewList.size());
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecommendDetailActivity.class);
                intent.putExtra(RecommendDetailActivityController.RECOMMEND_UNIQUENMBER_KEY, Long.valueOf(String.valueOf(v.getTag())));
                mContext.startActivity(intent);
            }
        });
        return view;
    }
}
