package com.haipeng.decoration.helper.fragmenthelper;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.haipeng.decoration.R;
import com.haipeng.decoration.fragment.TemplatesFragment;

/**
 * Created by Administrator on 2017/8/12.
 */

public class TemplatesFragmentsViewHelper {
    TemplatesFragment mFragment;
    View mView;

    public TemplatesFragmentsViewHelper(TemplatesFragment templatesFragment) {
        mFragment = templatesFragment;
        mView = mFragment.mContentView;
    }

    public void initView(){
        mFragment.verticalRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view_vertical);
        LinearLayoutManager VLM = new LinearLayoutManager(mFragment.getActivity());
        VLM.setOrientation(LinearLayoutManager.VERTICAL);
        mFragment.verticalRecyclerView.setHasFixedSize(true);
        mFragment.verticalRecyclerView.setLayoutManager(VLM);
        mFragment.swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.sr_view_vertical);
    }
}
