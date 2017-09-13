package com.haipeng.decoration.helper.fragmenthelper;

import android.content.Intent;
import android.view.View;

import com.haipeng.decoration.R;
import com.haipeng.decoration.activity.LoginActivity;
import com.haipeng.decoration.activity.SignUpActivity;
import com.haipeng.decoration.constant.LoginConstant;
import com.haipeng.decoration.event.LoginEvent;
import com.haipeng.decoration.fragment.MineFragment;
import com.haipeng.decoration.model.ResponseUserModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.MySharedprefrencesConstantUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/8/12.
 */

public class MineFragmentController implements View.OnClickListener {
    MineFragment mFragment = null;
    MineFragmentViewHelper viewHelper = null;

    public MineFragmentController(MineFragment mineFragment, MineFragmentViewHelper viewHelper) {
        this.mFragment = mineFragment;
        this.viewHelper = viewHelper;
        init();
    }

    public void init() {
        mFragment.btnSignIn.setOnClickListener(this);
        mFragment.btnSignUp.setOnClickListener(this);
        EventBus.getDefault().register(this);

//        Function<Throwable, ResponseUserModel> function =


        if (MySharedprefrencesConstantUtils.getUserUniqueNumber() != 0l) {
            try {
                UrlUtils.signIn(MySharedprefrencesConstantUtils.getUserUniqueNumber(), consumer, function);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Function<Throwable, ResponseUserModel> function = new Function<Throwable, ResponseUserModel>() {
        @Override
        public ResponseUserModel apply(@NonNull Throwable throwable) throws Exception {
            return new ResponseUserModel();
        }

    };


    Consumer<ResponseUserModel> consumer = new Consumer<ResponseUserModel>() {
        @Override
        public void accept(ResponseUserModel responseUserModel) throws Exception {
            if (responseUserModel.getUniqueNumber() != 0l) {
                LoginConstant.USER_UNIQUENUMBER = responseUserModel.getUniqueNumber();
                MySharedprefrencesConstantUtils.setUserUniqueNumber(responseUserModel.getUniqueNumber());
                showName(responseUserModel.getName());
            }
        }
    };

    Consumer<Throwable> errorConsumer = new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) throws Exception {
            throwable.getCause();
//            return;
//            MyToastUtils.showToastLong(mFragment.getContext(), "mei");
        }
    };

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void loginEvent(LoginEvent event) {
        showName(event.userName);
    }

    public void showName(String name) {
        mFragment.llSignUp.setVisibility(View.GONE);
        mFragment.llSignOk.setVisibility(View.VISIBLE);
        mFragment.tvName.setText(name);
    }

    public void onDestory() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up:
                Intent intent = new Intent(mFragment.getActivity(), SignUpActivity.class);
                mFragment.getActivity().startActivity(intent);
                break;
            case R.id.btn_sign_in:
                Intent intent2 = new Intent(mFragment.getActivity(), LoginActivity.class);
                mFragment.getActivity().startActivityForResult(intent2, 200);
                break;
        }
    }


}
