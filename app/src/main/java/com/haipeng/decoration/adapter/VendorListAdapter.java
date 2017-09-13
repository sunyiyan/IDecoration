package com.haipeng.decoration.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.VendorDetailActivity;
import com.haipeng.decoration.adapter.viewholder.ItemVendorViewHelper;
import com.haipeng.decoration.helper.activityhelper.VendorDetailActivityController;
import com.haipeng.decoration.model.VendorModel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/19.
 */

public class VendorListAdapter extends RecyclerView.Adapter<ItemVendorViewHelper> implements View.OnClickListener {

    Activity mContext;
    List<VendorModel> models;
    LayoutInflater mInflater;

    public VendorListAdapter(Activity mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<VendorModel> list) {
        this.models = list;
        notifyDataSetChanged();
    }

    @Override
    public ItemVendorViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_vendor, parent, false);

        ItemVendorViewHelper viewHelper = new ItemVendorViewHelper(view);
        viewHelper.tvName = (TextView) view.findViewById(R.id.tv_name);
        viewHelper.tvIntro = (TextView) view.findViewById(R.id.tv_intro);
        viewHelper.rlContent = (RelativeLayout) view.findViewById(R.id.rl_content);
        viewHelper.imageAvator = (ImageView) view.findViewById(R.id.iv_avator);

        return viewHelper;
    }

    @Override
    public void onBindViewHolder(ItemVendorViewHelper holder, int position) {
        VendorModel model = models.get(position);
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
                Intent intent = new Intent(mContext, VendorDetailActivity.class);
                intent.putExtra(VendorDetailActivityController.TEMPLATE_UNIQUENMBER_KEY, ((VendorModel)v.getTag()).getUniqueNumber());
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return null == models ? 0 : models.size();
    }
}
