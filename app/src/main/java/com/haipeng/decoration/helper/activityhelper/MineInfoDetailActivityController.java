package com.haipeng.decoration.helper.activityhelper;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.MineInfoDetailActivity;
import com.haipeng.decoration.model.ResponseUserModel;
import com.haipeng.decoration.model.UserModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class MineInfoDetailActivityController {

    MineInfoDetailActivity mActivity;
    MineInfoDetailActivityViewHelper mViewHelper;
    public static String USER_UNIQUE_NUMBER_KEY="user_unique_number_key";

    public MineInfoDetailActivityController(MineInfoDetailActivity mainActivity, MineInfoDetailActivityViewHelper viewHelper) {
        mActivity = mainActivity;
        mViewHelper = viewHelper;
    }

    public void init() {
        long userUniqueNumber = mActivity.getIntent().getLongExtra(USER_UNIQUE_NUMBER_KEY, 0L);
        if (userUniqueNumber != 0l) {
            UrlUtils.signIn(userUniqueNumber, consumer, function);
        }
    }

    Consumer<ResponseUserModel> consumer = new Consumer<ResponseUserModel>() {
        @Override
        public void accept(ResponseUserModel model) throws Exception {
            if (model.getUniqueNumber() != 0l) {
//                mActivity.back .setText();// (Button) mActivity.findViewById(R.id.back);
//                mActivity.commit .setText();// (Button) mActivity.findViewById(R.id.commit);
//                mActivity.img .setText();// (ImageView) mActivity.findViewById(R.id.iv_add_user);

                mActivity.etName .setText(model.getName());// (EditText) mActivity.findViewById(R.id.et_name);
                mActivity.etPhone .setText(model.getPhone());// (EditText) mActivity.findViewById(R.id.et_phone);
                mActivity.etEmail .setText(model.getEmail());// (EditText) mActivity.findViewById(R.id.et_email);
//                ImageLoader.getInstance().displayImage(model.get, mActivity.imageAvator);
            } else {
                MyToastUtils.showToastLong(mActivity, "查询失败");
            }
        }
    };

    Function<Throwable, ResponseUserModel> function = new Function<Throwable, ResponseUserModel>() {
        @Override
        public ResponseUserModel apply(@NonNull Throwable throwable) throws Exception {
            return new ResponseUserModel();
        }

    };

    public void setViewData(UserModel model) {

    }


    public void refreshForConnectNet() {

    }

    public void refreshForLoginSuccess() {

    }


}
