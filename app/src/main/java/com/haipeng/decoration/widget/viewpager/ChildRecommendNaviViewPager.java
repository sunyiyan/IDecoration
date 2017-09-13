package com.haipeng.decoration.widget.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haipeng.decoration.R;
import com.haipeng.decoration.listener.OnCountListener;
import com.haipeng.decoration.model.RecommendModel;
import com.haipeng.decoration.ror.UrlUtils;
import com.haipeng.decoration.utils.CountUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ChildRecommendNaviViewPager extends ViewPager implements OnCountListener {


    private RelativeLayout LLView1, LLView2, LLView3, LLView4;
    private ImageView view1, view2, view3, view4;
    private List<RelativeLayout> viewList = new ArrayList<RelativeLayout>();
    private ChildRecommendNaviViewPagerAdapter adapter;
    private Context mContext;

    public ChildRecommendNaviViewPager(Context context) {
        super(context);
    }

    public ChildRecommendNaviViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }

    public void init(Context context, ChildRecommendNaviViewPagerAdapter adapter) {
//        addOnPageChangeListener(this);
//        addOnPageChangeListener(new OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        mContext = context;
        this.adapter = adapter;
        UrlUtils.getAllRecommend(consumer, function);
    }

    Consumer<List<RecommendModel>> consumer = new Consumer<List<RecommendModel>>() {
        @Override
        public void accept(List<RecommendModel> recommendModels) throws Exception {
            if (recommendModels.size() != 0) {
                adapter.setData(createViews(mContext, recommendModels));
//                adapter.setData(getViews(mContext));
            } else {

            }
        }
    };

    Function<Throwable, List<RecommendModel>> function = new Function<Throwable, List<RecommendModel>>() {
        @Override
        public List<RecommendModel> apply(@NonNull Throwable throwable) throws Exception {
            return new ArrayList<RecommendModel>();
        }
    };

//
//    public void
//
//    mFragment.navigationViewPager.setOnGenericMotionListener(new View.OnGenericMotionListener() {
//        @Override
//        public boolean onGenericMotion(View v, MotionEvent event) {
//            if(event.getAction() == MotionEvent.ACTION_DOWN){
//                countUtils.cancelAction();
//            }else if(event.getAction() == MotionEvent.ACTION_UP) {
//                countUtils.inRefresh();
//            }
//            return true;
//        }
//    });

    public List<RelativeLayout> createViews(Context context, List<RecommendModel> models) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 400);

        for (int i = 0; i < models.size(); i++) {
            RecommendModel model = models.get(i);
            RelativeLayout ll = new RelativeLayout(context);
            ImageView iv = new ImageView(context);
            TextView tv = new TextView(context);
            ll.setLayoutParams(layoutParams);

            iv.setLayoutParams(layoutParams);
            iv.setImageResource(R.mipmap.bg_student_online);

            tv.setText(model.getTitle());
            tv.setTextColor(Color.BLACK);

            tv.setTextSize(50f);
            ll.addView(iv);
            ll.addView(tv);
            ll.setTag(model.getUniqueNumber());

            viewList.add(ll);
        }

        return viewList;
    }


    public List<RelativeLayout> getViews(Context context) {

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, 400);

        LLView1 = new RelativeLayout(context);
        LLView2 = new RelativeLayout(context);
        LLView3 = new RelativeLayout(context);
        LLView4 = new RelativeLayout(context);

        view1 = new ImageView(context);
        view2 = new ImageView(context);
        view3 = new ImageView(context);
        view4 = new ImageView(context);

        view1.setImageResource(R.mipmap.bg_teacher_offline);
        view2.setImageResource(R.mipmap.bg_student_offline);
        view3.setImageResource(R.mipmap.bg_student_online);
        view4.setImageResource(R.mipmap.bg_teacher_online);

        view1.setLayoutParams(layoutParams);
        view2.setLayoutParams(layoutParams);
        view3.setLayoutParams(layoutParams);
        view4.setLayoutParams(layoutParams);

        LLView1.setLayoutParams(layoutParams);
        LLView2.setLayoutParams(layoutParams);
        LLView3.setLayoutParams(layoutParams);
        LLView4.setLayoutParams(layoutParams);

        LLView1.addView(view1);
        LLView2.addView(view2);
        LLView3.addView(view3);
        LLView4.addView(view4);

        viewList.add(LLView1);
        viewList.add(LLView2);
        viewList.add(LLView3);
        viewList.add(LLView4);

        return viewList;
    }

    @Override
    public void countAction() {
        setCurrentItem(CountUtils.num);
    }
}
