package com.haipeng.decoration.helper.activityhelper;


import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.RecommendDetailActivity;
import com.haipeng.decoration.model.RecommendModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class RecommendDetailActivityController {

    RecommendDetailActivity mActivity;
    RecommendDetailActivityViewHelper mViewHelper;
    public static String RECOMMEND_UNIQUENMBER_KEY = "recommend_unique_key";

    public RecommendDetailActivityController(RecommendDetailActivity mainActivity, RecommendDetailActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;

    }

    public void init() {
        long recommendUniqueNumber = mActivity.getIntent().getLongExtra(RECOMMEND_UNIQUENMBER_KEY, 0L);
        if (recommendUniqueNumber != 0l) {
            UrlUtils.getRecommend(recommendUniqueNumber, consumer, function);
        }
    }

    Consumer<RecommendModel> consumer = new Consumer<RecommendModel>() {
        @Override
        public void accept(RecommendModel model) throws Exception {
            if (model.getUniqueNumber() != 0l) {
                mActivity.tvTitle.setText(model.getTitle());
                mActivity.tvTitle.setText(model.getType());
                mActivity.ivAvator.setImageResource(R.mipmap.bg_teacher_online);
//                ImageLoader.getInstance().displayImage(model.getImageAvator(), mActivity.imageAvator);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, RecommendModel> function = new Function<Throwable, RecommendModel>() {
        @Override
        public RecommendModel apply(@NonNull Throwable throwable) throws Exception {
            return new RecommendModel();
        }

    };

    public void refreshForConnectNet() {

    }

    public void refreshForLoginSuccess() {

    }


}
