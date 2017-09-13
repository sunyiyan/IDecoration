package com.haipeng.decoration.helper.fragmenthelper;

import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.OrderDetailActivity;
import com.haipeng.decoration.activity.OrderListActivity;
import com.haipeng.decoration.constant.LoginConstant;
import com.haipeng.decoration.event.LoginEvent;
import com.haipeng.decoration.fragment.MainFragment;
import com.haipeng.decoration.model.OrderModel;
import com.haipeng.decoration.model.ResponseUserModel;
import com.haipeng.decoration.model.UserModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.MySharedprefrencesConstantUtils;
import com.haipeng.decoration.utils.StringUtils;
import com.haipeng.decoration.utils.UniqueNumberUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/8/12.
 */

public class MainFragmentController implements View.OnClickListener {

    MainFragment mFragment = null;
    MainFragmentViewHelper mViewHelper = null;
    int size;
    int TYPE_REQUEST = 0;
    int TYPE_REQUEST_CHECK_ORDER = 001; //查看订单
    int TYPE_REQUEST_ADD_ORDER = 002;
    int TYPE_REQUEST_GET_ORDER_PRE = 003; //提前检查订单
    long orderUniqumber = 0;

    public MainFragmentController(MainFragment mainFragment, MainFragmentViewHelper viewHelper) {
        this.mFragment = mainFragment;
        this.mViewHelper = viewHelper;
    }

    public void init() {
        mFragment.btnCommit.setOnClickListener(this);
        mFragment.btnMyOrder.setOnClickListener(this);

        UrlUtils.getOrderByUserUniqueNumber(LoginConstant.USER_UNIQUENUMBER, consumer, function);
        TYPE_REQUEST = TYPE_REQUEST_GET_ORDER_PRE;

    }


    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Consumer<List<OrderModel>> consumer = new Consumer<List<OrderModel>>() {
        @Override
        public void accept(List<OrderModel> models) throws Exception {
            size = models.size();
            if (size != 0) {
                if (TYPE_REQUEST == TYPE_REQUEST_GET_ORDER_PRE) {

                    if (size >= 1) {
                        mFragment.llMyOrder.setVisibility(View.VISIBLE);
                        if (size >= 3) {
                            mFragment.llOutOfOrders.setVisibility(View.VISIBLE);
                        } else {
                            mFragment.llOutOfOrders.setVisibility(View.INVISIBLE);
                        }
                    }

                } else if (TYPE_REQUEST == TYPE_REQUEST_CHECK_ORDER) {
                    if (size == 1) {
                        orderUniqumber = models.get(0).getUniqueNumber();
                        Intent intent = new Intent(mFragment.getActivity(), OrderDetailActivity.class);
                        intent.putExtra("OrderUniqueNumber", orderUniqumber);
                        mFragment.getActivity().startActivity(intent);
                    } else if (size >= 1) {
                        orderUniqumber = models.get(0).getUniqueNumber();
                        Intent intent = new Intent(mFragment.getActivity(), OrderListActivity.class);
                        mFragment.getActivity().startActivity(intent);
                    }
                }

            } else {
                if (TYPE_REQUEST == TYPE_REQUEST_GET_ORDER_PRE) {
                    mFragment.llMyOrder.setVisibility(View.GONE);
                    mFragment.llOutOfOrders.setVisibility(View.GONE);
                } else if (TYPE_REQUEST == TYPE_REQUEST_CHECK_ORDER) {
                    mFragment.llMyOrder.setVisibility(View.GONE);
                    MyToastUtils.showToastLong(mFragment.getContext(), "没发现您的订单");
                }

            }
        }

    };

    Function<Throwable, List<OrderModel>> function = new Function<Throwable, List<OrderModel>>() {
        @Override
        public List<OrderModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<OrderModel>();
        }

    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commit:
                UrlUtils.addOrder(getOrderModelJson(""), addConsumer, addFunction);
                break;
            case R.id.btn_my_order:
                UrlUtils.getOrderByUserUniqueNumber(LoginConstant.USER_UNIQUENUMBER, consumer, function);
                TYPE_REQUEST = TYPE_REQUEST_CHECK_ORDER;
                break;
        }
    }


    Consumer<OrderModel> addConsumer = new Consumer<OrderModel>() {
        @Override
        public void accept(OrderModel orderModel) throws Exception {

        }
    };

    Function<Throwable, OrderModel> addFunction = new Function<Throwable, OrderModel>() {
        @Override
        public OrderModel apply(@NonNull Throwable throwable) throws Exception {
            return new OrderModel();
        }

    };


    public String getOrderModelJson(String imgPath) {
        OrderModel model = new OrderModel();
        model.setUniqueNumber(UniqueNumberUtils.getUniqueNumber());
        model.setUserName(StringUtils.filterStringExe(mFragment.etUserName.getText()));
        model.setUserPhone(StringUtils.filterStringExe(mFragment.etUserPhone.getText()));
        model.setUserEmail(StringUtils.filterStringExe(mFragment.etUserEmail.getText()));
        model.setUserAdress(StringUtils.filterStringExe(mFragment.etUserAddress.getText()));
        model.setUserUniqueNumber(LoginConstant.USER_UNIQUENUMBER);
        model.setDecorationArea(StringUtils.filterStringExe(mFragment.etDecorationArea.getText()));
        model.setDecorationStyle(StringUtils.filterStringExe(mFragment.etDecorationStyle.getText()));
        model.setDecorationRequire(StringUtils.filterStringExe(mFragment.etDecorationRequire.getText()));
        model.setImageAvator(imgPath);

        Gson gson = new Gson();

        return gson.toJson(model);
    }

}
