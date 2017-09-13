package com.haipeng.decoration.helper.fragmenthelper;

import com.haipeng.decoration.adapter.TemplatesAdapter;
import com.haipeng.decoration.fragment.TemplatesFragment;
import com.haipeng.decoration.model.TemplateModel;
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

public class TemplatesFragmentsController {
    
    TemplatesFragment mFragment = null;
    TemplatesFragmentsViewHelper viewHelper = null;
    public static String TEMPLATE_UNIQUENUMBER_KEY = "template_unique_number_key";

    public TemplatesFragmentsController(TemplatesFragment templatesFragment, TemplatesFragmentsViewHelper viewHelper) {
        this.mFragment = templatesFragment;
        this.viewHelper = viewHelper;
    }
    
    public void init(){
        mFragment.adapter = new TemplatesAdapter(mFragment.getActivity());
        mFragment.verticalRecyclerView.setAdapter(mFragment.adapter);

        UrlUtils.getAllTemplate(consumer,function);
    }

    public void refreshForConnectNet(){

    }

    public void refreshForLoginSuccess(){

    }

    Consumer<List<TemplateModel>> consumer = new Consumer<List<TemplateModel>>() {
        @Override
        public void accept(List<TemplateModel> models) throws Exception {
            if (models.size() != 0) {
                mFragment.adapter.setData(models);
            } else {
                MyToastUtils.showToastLong(mFragment.getContext(), "查询失败");
            }
        }
    };

    Function<Throwable, List<TemplateModel>> function = new Function<Throwable, List<TemplateModel>>() {
        @Override
        public List<TemplateModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<TemplateModel>();
        }

    };

}
