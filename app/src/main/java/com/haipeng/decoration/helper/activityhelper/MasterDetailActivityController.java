package com.haipeng.decoration.helper.activityhelper;

import com.haipeng.decoration.activity.MasterDetailActivity;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MasterDetailActivityController {

    MasterDetailActivity mActivity;
    MasterDetailActivityViewHelper mViewHelper;
    public static String MASTER_UNIQUENMBER_KEY = "master_unique_key";

    public MasterDetailActivityController(MasterDetailActivity mainActivity, MasterDetailActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;
    }

    public void init() {

        long masterUniqueNumber = mActivity.getIntent().getLongExtra(MASTER_UNIQUENMBER_KEY, 0L);
        if (masterUniqueNumber != 0l) {
            UrlUtils.getMaster(masterUniqueNumber, consumer, function);
        }
    }

    public void setViewData(MasterModel model) {
        mActivity.tvName.setText(model.getName());
        mActivity.tvPhone.setText(model.getPhone());// (TextView) mActivity.findViewById(R.id.tv_phone);
        mActivity.tvEmail.setText(model.getEmail());// (TextView) mActivity.findViewById(R.id.tv_email);
        mActivity.tvAddress.setText(model.getAddress());// (TextView) mActivity.findViewById(R.id.tv_address);
        mActivity.tvLegalRep.setText(model.getLegalRepresentative());// (TextView) mActivity.findViewById(R.id.tv_legal_representative);
        ImageLoader.getInstance().displayImage(model.getImageAvator(), mActivity.imageAavator);
        ImageLoader.getInstance().displayImage(model.getImageLicense(), mActivity.imageLicense);
    }

    Consumer<MasterModel> consumer = new Consumer<MasterModel>() {
        @Override
        public void accept(MasterModel model) throws Exception {
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

    Function<Throwable, MasterModel> function = new Function<Throwable, MasterModel>() {
        @Override
        public MasterModel apply(@NonNull Throwable throwable) throws Exception {
            return new MasterModel();
        }

    };


    public void refreshForConnectNet() {

    }

    public void refreshForLoginSuccess() {

    }


}
