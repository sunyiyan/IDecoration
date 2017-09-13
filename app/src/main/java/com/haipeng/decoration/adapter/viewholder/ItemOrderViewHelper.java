package com.haipeng.decoration.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/8/19.
 */

public class ItemOrderViewHelper extends RecyclerView.ViewHolder {

    public ItemOrderViewHelper(View itemView) {
        super(itemView);
    }

    public TextView tvName;
    public TextView tvPhone;
    public TextView tvEmail;
    public TextView tvAddress;
    public TextView tvArea;
    public TextView tvRequire;
    public TextView tvOrderUniqueNumber;
    public Button btnDetail;
//    public ImageView imageAvator;
}
