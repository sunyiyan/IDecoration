package com.haipeng.decoration.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.adapter.viewholder.ChildRecommendHoriViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class ChildRecommendHoriAdapter extends RecyclerView.Adapter<ChildRecommendHoriViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mDatas;
    private Context mContext;


    public ChildRecommendHoriAdapter(Context context, List<String> mDatas) {
        this.mDatas = mDatas;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public ChildRecommendHoriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycle_hori_child_recommend, parent, false);
        ChildRecommendHoriViewHolder viewHolder = new ChildRecommendHoriViewHolder(view);
        viewHolder.ivImageView = (ImageView) view.findViewById(R.id.iv_recommend_avator);
        viewHolder.tv = (TextView) view.findViewById(R.id.tv_recommend);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChildRecommendHoriViewHolder holder, int position) {
        holder.ivImageView.setImageResource(R.mipmap.ic_launcher);
        holder.tv.setText(mDatas.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
