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
import com.haipeng.decoration.activity.TemplateDetailActivity;
import com.haipeng.decoration.adapter.viewholder.ItemTemplateViewHelper;
import com.haipeng.decoration.adapter.viewholder.ItemTemplateViewHelper;
import com.haipeng.decoration.helper.activityhelper.TemplateDetailActivityController;
import com.haipeng.decoration.model.TemplateModel;
import com.haipeng.decoration.model.VendorModel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2017/8/19.
 */

public class TemplatesAdapter extends RecyclerView.Adapter<ItemTemplateViewHelper> implements View.OnClickListener {

    Activity mContext;
    List<TemplateModel> models;
    LayoutInflater mInflater;

    public TemplatesAdapter(Activity mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<TemplateModel> list) {
        this.models = list;
        notifyDataSetChanged();
    }

    @Override
    public ItemTemplateViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_template, parent, false);

        ItemTemplateViewHelper viewHelper = new ItemTemplateViewHelper(view);
        viewHelper.tvName = (TextView) view.findViewById(R.id.tv_name);
        viewHelper.tvIntro = (TextView) view.findViewById(R.id.tv_intro);
        viewHelper.rlContent = (RelativeLayout) view.findViewById(R.id.rl_content);
        viewHelper.imageAvator = (ImageView) view.findViewById(R.id.iv_avator);

        return viewHelper;
    }

    @Override
    public void onBindViewHolder(ItemTemplateViewHelper holder, int position) {
        TemplateModel model = models.get(position);
        holder.tvName.setText(model.getTitle());
        holder.tvIntro.setText("");
        ImageLoader.getInstance().displayImage(model.getImageAvator(), holder.imageAvator);
        holder.rlContent.setOnClickListener(this);
        holder.rlContent.setTag(models.get(position).getUniqueNumber());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_content:
                Intent intent = new Intent(mContext, TemplateDetailActivity.class);
                intent.putExtra(TemplateDetailActivityController.TEMPLATE_UNIQUENMBER_KEY, Long.valueOf(v.getTag().toString()));
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return null == models ? 0 : models.size();
    }
}
