package com.haipeng.decoration.helper.activityhelper;


import com.haipeng.decoration.activity.MasterDetailActivity;
import com.haipeng.decoration.model.VendorModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class VendorDetailActivityController {

    MasterDetailActivity mActivity;
    MasterDetailActivityViewHelper mViewHelper;
    public static String TEMPLATE_UNIQUENMBER_KEY = "template_unique_key";

    public VendorDetailActivityController(MasterDetailActivity mainActivity, MasterDetailActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;
    }

    public void init() {

        long vendorUniqueNumber = mActivity.getIntent().getLongExtra(TEMPLATE_UNIQUENMBER_KEY, 0L);
        if (vendorUniqueNumber != 0l) {
            UrlUtils.getVendor(vendorUniqueNumber, consumer, function);
        }
        
    }

    Consumer<VendorModel> consumer = new Consumer<VendorModel>() {
        @Override
        public void accept(VendorModel model) throws Exception {
            if (model.getUniqueNumber() != 0l) {
                mActivity.tvName.setText(model.getName());
                mActivity.tvPhone.setText(model.getPhone());
                mActivity.tvAddress.setText(model.getAddress());
                mActivity.tvEmail.setText(model.getEmail());
                ImageLoader.getInstance().displayImage(model.getImageAvator(), mActivity.imageAavator);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, VendorModel> function = new Function<Throwable, VendorModel>() {
        @Override
        public VendorModel apply(@NonNull Throwable throwable) throws Exception {
            return new VendorModel();
        }

    };



    public void refreshForConnectNet() {

    }

    public void refreshForLoginSuccess() {

    }


}
