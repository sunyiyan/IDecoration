package com.haipeng.decoration.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/8/19.
 */

public class ItemMasterViewHelper extends RecyclerView.ViewHolder {

    public ItemMasterViewHelper(View itemView) {
        super(itemView);
    }

    public RelativeLayout rlContent;
    public TextView tvName;
    public TextView tvIntro;
    public ImageView imageAvator;
}
