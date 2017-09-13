package com.haipeng.decoration.helper.activityhelper;

import com.haipeng.decoration.activity.TemplateDetailActivity;
import com.haipeng.decoration.model.TemplateModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class TemplateDetailActivityController  {

    TemplateDetailActivity mActivity;
    TemplateDetailActivityViewHelper mViewHelper;
    public static String TEMPLATE_UNIQUENMBER_KEY ="template_unique_key";

    public TemplateDetailActivityController(TemplateDetailActivity mainActivity, TemplateDetailActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;

    }

    public void init() {
        long templateUniqueNumber = mActivity.getIntent().getLongExtra(TEMPLATE_UNIQUENMBER_KEY, 0L);
        if (templateUniqueNumber != 0l) {
            UrlUtils.getTemplate(templateUniqueNumber, consumer, function);
        }
    }


    Consumer<TemplateModel> consumer = new Consumer<TemplateModel>() {
        @Override
        public void accept(TemplateModel model) throws Exception {
            if (model.getUniqueNumber() != 0l) {

                mActivity.tvTitle.setText(model.getTitle());
                mActivity.tvMasterId.setText(model.getMasterUniqueNumber());
                mActivity.tvVendorId.setText(model.getVendorUniqueNumber());
                ImageLoader.getInstance().displayImage(model.getImageAvator(), mActivity.imageAvator);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, TemplateModel> function = new Function<Throwable, TemplateModel>() {
        @Override
        public TemplateModel apply(@NonNull Throwable throwable) throws Exception {
            return new TemplateModel();
        }

    };

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }



}
