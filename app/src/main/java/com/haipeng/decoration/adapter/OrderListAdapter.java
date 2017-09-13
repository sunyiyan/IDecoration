package com.haipeng.decoration.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.OrderDetailActivity;
import com.haipeng.decoration.adapter.viewholder.ItemOrderViewHelper;
import com.haipeng.decoration.helper.activityhelper.OrderDetailActivityController;
import com.haipeng.decoration.model.OrderModel;

import java.util.List;

/**
 * Created by Administrator on 2017/8/19.
 */

public class OrderListAdapter extends RecyclerView.Adapter<ItemOrderViewHelper> implements View.OnClickListener {

    Activity mContext;
    List<OrderModel> models;
    LayoutInflater mInflater;

    public OrderListAdapter(Activity mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<OrderModel> list) {
        this.models = list;
        notifyDataSetChanged();
    }

    @Override
    public ItemOrderViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_order, parent, false);

        ItemOrderViewHelper viewHelper = new ItemOrderViewHelper(view);
        viewHelper.tvName = (TextView) view.findViewById(R.id.tv_name);

        viewHelper.tvPhone = (TextView) view.findViewById(R.id.tv_phone);

        viewHelper.tvEmail = (TextView) view.findViewById(R.id.tv_email);

        viewHelper.tvAddress = (TextView) view.findViewById(R.id.tv_address);

        viewHelper.tvArea = (TextView) view.findViewById(R.id.tv_area);

        viewHelper.tvRequire = (TextView) view.findViewById(R.id.tv_require);

        viewHelper.tvOrderUniqueNumber = (TextView) view.findViewById(R.id.tv_uniqueNumber);

        viewHelper.btnDetail = (Button) view.findViewById(R.id.btn_detail);

//        viewHelper.imageAvator = (ImageView) view.findViewById(R.id.iv_avator);

        return viewHelper;
    }

    @Override
    public void onBindViewHolder(ItemOrderViewHelper holder, int position) {
        OrderModel model = models.get(position);
        holder.tvName.setText(model.getUserName());// (TextView) view.findViewById(R.id.tv_name);

        holder.tvPhone.setText(model.getUserPhone());// (TextView) view.findViewById(R.id.tv_phone);

        holder.tvEmail.setText(model.getUserEmail());// (TextView) view.findViewById(R.id.tv_email);

        holder.tvAddress.setText(model.getUserAdress());// (TextView) view.findViewById(R.id.tv_address);

        holder.tvArea.setText(model.getDecorationArea());// (TextView) view.findViewById(R.id.tv_area);

        holder.tvRequire.setText(model.getDecorationRequire());// (TextView) view.findViewById(R.id.tv_require);

        holder.tvOrderUniqueNumber.setText(model.getUniqueNumber() + "");// (TextView) view.findViewById(R.id.tv_uniqueNumber);

        holder.btnDetail.setTag(model.getUniqueNumber());

        holder.btnDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_detail:
                Intent intent = new Intent(mContext, OrderDetailActivity.class);
                intent.putExtra(OrderDetailActivityController.ORDER_UNIQUENMBER_KEY, Long.valueOf(v.getTag().toString()));
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return null == models ? 0 : models.size();
    }
}
