package com.haipeng.decoration.helper.activityhelper;

import com.haipeng.decoration.activity.OrderDetailActivity;
import com.haipeng.decoration.constant.LoginConstant;
import com.haipeng.decoration.event.LoginEvent;
import com.haipeng.decoration.model.OrderModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.MySharedprefrencesConstantUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import de.greenrobot.event.EventBus;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/8/19.
 */

public class OrderDetailActivityController {

    public static String ORDER_UNIQUENMBER_KEY = "OrderUniqueNumber";
    OrderDetailActivity mActivity;
    OrderDetailActivityViewHelper mViewHelper;
    long orderUniqueNumber;

    public OrderDetailActivityController(OrderDetailActivity mActivity, OrderDetailActivityViewHelper mViewHelper) {
        this.mActivity = mActivity;
        this.mViewHelper = mViewHelper;
    }

    public void init() {
        orderUniqueNumber = mActivity.getIntent().getLongExtra(ORDER_UNIQUENMBER_KEY, 0L);
        if (orderUniqueNumber != 0l) {
            UrlUtils.getOrderByOrderUniqueNumber(orderUniqueNumber, consumer, function);
        }
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Consumer<OrderModel> consumer = new Consumer<OrderModel>() {
        @Override
        public void accept(OrderModel model) throws Exception {
            if (model.getUniqueNumber() != 0l) {
                mActivity.tvName.setText(model.getUserName());
                mActivity.tvPhone.setText(model.getUserPhone());
                mActivity.tvAddress.setText(model.getUserAdress());
                mActivity.tvEmail.setText(model.getUserEmail());
                mActivity.tvRequire.setText(model.getDecorationRequire());
                mActivity.tvRequire.setText(model.getDecorationStyle());
                ImageLoader.getInstance().displayImage(model.getImageAvator(), mActivity.imageAvator);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, OrderModel> function = new Function<Throwable, OrderModel>() {
        @Override
        public OrderModel apply(@NonNull Throwable throwable) throws Exception {
            return new OrderModel();
        }

    };
}
