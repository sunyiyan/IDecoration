package com.haipeng.decoration.helper.activityhelper;

import com.haipeng.decoration.activity.OrderListActivity;
import com.haipeng.decoration.adapter.OrderListAdapter;
import com.haipeng.decoration.constant.LoginConstant;
import com.haipeng.decoration.model.OrderModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/8/19.
 */

public class OrderListActivityController {

    OrderListActivity mActivity;
    OrderListActivityViewHelper mViewHelper;

    public OrderListActivityController(OrderListActivity mActivity, OrderListActivityViewHelper mViewHelper) {
        this.mActivity = mActivity;
        this.mViewHelper = mViewHelper;
    }

    public void init(){

        mActivity.orderListAdapter = new OrderListAdapter(mActivity);
        mActivity.verticalRecyclerView.setAdapter(mActivity.orderListAdapter);

        UrlUtils.getOrderByUserUniqueNumber(LoginConstant.USER_UNIQUENUMBER,consumer,function);
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Consumer<List<OrderModel>> consumer = new Consumer<List<OrderModel>>() {
        @Override
        public void accept(List<OrderModel> models) throws Exception {
            if (models.size() != 0) {
                mActivity.orderListAdapter.setData(models);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, List<OrderModel>> function = new Function<Throwable, List<OrderModel>>() {
        @Override
        public List<OrderModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<OrderModel>();
        }

    };
}
