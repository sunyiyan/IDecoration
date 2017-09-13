package com.haipeng.decoration.utils;

import android.util.Log;

import com.haipeng.decoration.listener.OnCountListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/7/17.
 */

public class CountUtils {

    Subscription subs;
    int blankTime = 10;
    public static int num;
    boolean isPause = false;
    private OnCountListener listener;

    Flowable<Integer> flowableCountDown;
    Subscriber<Integer> suscriberCountDown;
    int test = 9;

    public CountUtils() {
    }

    public void realize(final int blankTime) {
        num = num + 1 > 3 ? 0 : num + 1;
        listener.countAction();
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {
                e.onNext(test);
            }
        }, BackpressureStrategy.ERROR).delay(blankTime, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                Log.d("tag", "sunyiyan");
                if (isPause) {
                    isPause = true;
                } else {
                    realize(blankTime);
                }
            }
        });

    }

    public void setListener(OnCountListener listener) {
        this.listener = listener;
        realize(blankTime);
        this.listener.countAction();
    }

    public void cancelAction() {
        if (null != subs)
            isPause = true;
    }

    // 当用户手滑动时
    public void inRefresh() {
        cancelAction();
        blankTime = 20;
        realize(blankTime);
    }


}
