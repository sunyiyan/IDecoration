package com.haipeng.decoration.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.MasterDetailActivity;
import com.haipeng.decoration.adapter.viewholder.ItemMasterViewHelper;
import com.haipeng.decoration.helper.activityhelper.MasterDetailActivityController;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.model.MasterModel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/19.
 */

public class MastersAdapter extends RecyclerView.Adapter<ItemMasterViewHelper> implements View.OnClickListener {

    Activity mContext;
    List<MasterModel> models;
    LayoutInflater mInflater;

    public MastersAdapter(Activity mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<MasterModel> list) {
        this.models = list;
        notifyDataSetChanged();
    }

    @Override
    public ItemMasterViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_master, parent, false);

        ItemMasterViewHelper viewHelper = new ItemMasterViewHelper(view);
        viewHelper.tvName = (TextView) view.findViewById(R.id.tv_name);
        viewHelper.tvIntro = (TextView) view.findViewById(R.id.tv_intro);
        viewHelper.rlContent = (RelativeLayout) view.findViewById(R.id.rl_content);
        viewHelper.imageAvator = (ImageView) view.findViewById(R.id.iv_avator);

        return viewHelper;
    }

    @Override
    public void onBindViewHolder(ItemMasterViewHelper holder, int position) {
        MasterModel model = models.get(position);
        holder.tvName.setText(model.getName());
        holder.tvIntro.setText(model.getAddress());
        ImageLoader.getInstance().displayImage(model.getImageAvator(),holder.imageAvator);
        holder.rlContent.setOnClickListener(this);
        holder.rlContent.setTag(models.get(position));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_content:
                Intent intent = new Intent(mContext, MasterDetailActivity.class);
                intent.putExtra(MasterDetailActivityController.MASTER_UNIQUENMBER_KEY, ((MasterModel)v.getTag()).getUniqueNumber());
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return null == models ? 0 : models.size();
    }
}
