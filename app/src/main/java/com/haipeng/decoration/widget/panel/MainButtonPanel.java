package com.haipeng.decoration.widget.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.haipeng.decoration.R;
import com.haipeng.decoration.listener.OnButtonsSwitchListener;
import com.haipeng.decoration.widget.ButtonsSwitchUtils;

/**
 * Created by Administrator on 2017/7/4.
 */

public class MainButtonPanel extends LinearLayout implements View.OnClickListener {

    LayoutInflater mLayoutInflater;
    Context mContext;
    View mContentView;
    Button homeButton, templateButton, mainButton, masterButton, mineButton;
    ButtonsSwitchUtils switchUtils;
    private OnButtonsSwitchListener listener;

    public MainButtonPanel(Context context) {
        super(context);
        init(context);
    }

    public MainButtonPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setListener(OnButtonsSwitchListener listener) {
        this.listener = listener;
    }

    public void init(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContentView = mLayoutInflater.inflate(R.layout.panel_main_button, null);
        addView(mContentView);

        homeButton = (Button) mContentView.findViewById(R.id.btn_home);
        templateButton = (Button) mContentView.findViewById(R.id.btn_templates);
        mainButton = (Button) mContentView.findViewById(R.id.btn_i_want);
        masterButton = (Button) mContentView.findViewById(R.id.btn_masters);
        mineButton = (Button) mContentView.findViewById(R.id.btn_mine);

        switchUtils = new ButtonsSwitchUtils(getContext());
        switchUtils.setBtnHomeworkTypes(homeButton, templateButton, mainButton, masterButton, mineButton);

        homeButton.setOnClickListener(this);
        templateButton.setOnClickListener(this);
        mainButton.setOnClickListener(this);
        masterButton.setOnClickListener(this);
        mineButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                listener.OnClickOne();
                switchUtils.changeBtnHomeworkType(1);
                break;
            case R.id.btn_templates:
                listener.OnClickTwo();

                switchUtils.changeBtnHomeworkType(2);
                break;
            case R.id.btn_i_want:
                listener.OnClickThree();

                switchUtils.changeBtnHomeworkType(3);
                break;
            case R.id.btn_masters:
                listener.OnClickFour();

                switchUtils.changeBtnHomeworkType(4);
                break;
            case R.id.btn_mine:
                listener.OnClickFive();

                switchUtils.changeBtnHomeworkType(5);
                break;
        }
    }
}
