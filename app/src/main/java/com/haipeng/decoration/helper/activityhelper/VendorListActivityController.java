package com.haipeng.decoration.helper.activityhelper;

import com.haipeng.decoration.activity.VendorListActivity;
import com.haipeng.decoration.adapter.VendorListAdapter;
import com.haipeng.decoration.model.VendorModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/8/19.
 */

public class VendorListActivityController {

    VendorListActivity mActivity;
    VendorListActivityViewHelper mViewHelper;
    List<VendorModel> models;

    public VendorListActivityController(VendorListActivity mActivity, VendorListActivityViewHelper mViewHelper) {
        this.mActivity = mActivity;
        this.mViewHelper = mViewHelper;
    }

    public void init(){

        mActivity.listAdapter = new VendorListAdapter(mActivity);
        mActivity.verticalRecyclerView.setAdapter(mActivity.listAdapter);
        UrlUtils.getAllVendor(consumer,function);

//        UrlUtils.getVendorByUserUniqueNumber(LoginConstant.USER_UNIQUENUMBER,consumer,function);
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Consumer<List<VendorModel>> consumer = new Consumer<List<VendorModel>>() {
        @Override
        public void accept(List<VendorModel> models) throws Exception {
            if (models.size() != 0) {
                mActivity.listAdapter.setData(models);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, List<VendorModel>> function = new Function<Throwable, List<VendorModel>>() {
        @Override
        public List<VendorModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<VendorModel>();
        }

    };
}
