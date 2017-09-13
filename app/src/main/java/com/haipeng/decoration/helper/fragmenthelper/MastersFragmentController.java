package com.haipeng.decoration.helper.fragmenthelper;

import com.haipeng.decoration.adapter.MastersAdapter;
import com.haipeng.decoration.fragment.MainFragment;
import com.haipeng.decoration.fragment.MastersFragment;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.widget.MyToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/8/12.
 */

public class MastersFragmentController {

    MastersFragment mFragment = null;
    MastersFragmentViewHelper viewHelper = null;


    public MastersFragmentController(MastersFragment mainFragment, MastersFragmentViewHelper viewHelper) {
        this.mFragment = mainFragment;
        this.viewHelper = viewHelper;
    }

    public void init() {
        mFragment.adapter = new MastersAdapter(mFragment.getActivity());
        mFragment.verticalRecyclerView.setAdapter(mFragment.adapter);
        UrlUtils.getAllMaster(consumer, function);
    }

    Consumer<List<MasterModel>> consumer = new Consumer<List<MasterModel>>() {
        @Override
        public void accept(List<MasterModel> models) throws Exception {
            if (models.size() != 0) {
                mFragment.adapter.setData(models);
            } else {
                MyToastUtils.showToastLong(mFragment.getContext(), "查询失败");
            }
        }
    };

    Function<Throwable, List<MasterModel>> function = new Function<Throwable, List<MasterModel>>() {
        @Override
        public List<MasterModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<MasterModel>();
        }

    };

    public void setData(List<MasterModel> models) {
        this.mFragment.adapter.setData(models);
    }

    public void refreshForConnectNet() {

    }

    public void refreshForLoginSuccess() {

    }
}
