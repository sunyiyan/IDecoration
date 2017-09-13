package com.haipeng.decoration.ror;

import com.haipeng.decoration.model.BaseModel;
import com.haipeng.decoration.model.MasterModel;
import com.haipeng.decoration.model.OrderModel;
import com.haipeng.decoration.model.RecommendModel;
import com.haipeng.decoration.model.ResponseUserModel;
import com.haipeng.decoration.model.ReturnResult;
import com.haipeng.decoration.model.TemplateModel;
import com.haipeng.decoration.model.UserModel;
import com.haipeng.decoration.model.VendorModel;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/16.
 */

public class UrlUtils extends RetrofitUtils {

    protected static final UrlService urlService = getRetrofit().create(UrlService.class);

    //设缓存有效期为1天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，使用缓存
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置。不使用缓存
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";

    public static <T> void setSubscribe(Flowable<T> flowable, Consumer<T> consumer, Function<Throwable, T> function) {
        flowable.subscribeOn(Schedulers.io())
                .onErrorReturn(function)
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回到主线程
                .subscribe(consumer);
    }


//    = FFunction<? super Throwable, ? extends BaseModel> valueSupplier

    public static void signUp(String json, Consumer<ReturnResult> consumer, Function<Throwable, ReturnResult> function) {
        setSubscribe(urlService.signUp(json), consumer, function);
    }

    public static void signIn(String userName, String userPassword, Consumer<ResponseUserModel> consumer, Function<Throwable, ResponseUserModel> function) {
        setSubscribe(urlService.signIn(userName, userPassword), consumer, function);
    }

    public static void signIn(long uniqueNumber, Consumer<ResponseUserModel> consumer, Function<Throwable, ResponseUserModel> function) {
        setSubscribe(urlService.signIn(uniqueNumber), consumer, function);
    }


    public static void addOrder(String json, Consumer<OrderModel> consumer, Function<Throwable, OrderModel> function) {
        setSubscribe(urlService.addOrder(json), consumer, function);
    }

    public static void getOrderByUserUniqueNumber(long userUniqueNumber, Consumer<List<OrderModel>> consumer,Function<Throwable, List<OrderModel>> function) {
        setSubscribe(urlService.getOrdersByUserUniqueNumber(userUniqueNumber), consumer, function);
    }

    public static void getOrderByOrderUniqueNumber(long orderUniqueNumber, Consumer<OrderModel> consumer,Function<Throwable, OrderModel> function) {
        setSubscribe(urlService.getOrderByOrderUniqueNumber(orderUniqueNumber), consumer, function);
    }

    public static void getAllOrder(Consumer<List<OrderModel>> consumer,Function<Throwable, List<OrderModel>> function) {
        setSubscribe(urlService.getAllOrder(), consumer, function);
    }

    public static void getTemplate(long uniqueNumber, Consumer<TemplateModel> consumer,Function<Throwable, TemplateModel> function) {
        setSubscribe(urlService.getTemplate(uniqueNumber), consumer, function);
    }

    public static void getAllTemplate(Consumer<List<TemplateModel>> consumer,Function<Throwable, List<TemplateModel>> function) {
        setSubscribe(urlService.getAllTemplate(), consumer, function);
    }

    public static void getVendor(long uniqueNumber, Consumer<VendorModel> consumer,Function<Throwable, VendorModel> function) {
        setSubscribe(urlService.getVendor(uniqueNumber), consumer, function);
    }

    public static void getAllVendor(Consumer<List<VendorModel>> consumer,Function<Throwable, List<VendorModel>> function) {
        setSubscribe(urlService.getAllVendor(), consumer, function);
    }

    public static void getMaster(long uniqueNumber, Consumer<MasterModel> consumer,Function<Throwable, MasterModel> function) {
        setSubscribe(urlService.getMaster(uniqueNumber), consumer, function);
    }

    public static void getAllMaster(Consumer<List<MasterModel>> consumer,Function<Throwable, List<MasterModel>> function) {
        setSubscribe(urlService.getAllMaster(), consumer, function);
    }

    public static void getRecommend(long uniqueNumber, Consumer<RecommendModel> consumer,Function<Throwable, RecommendModel> function) {
        setSubscribe(urlService.getRecommend(uniqueNumber), consumer, function);
    }

    public static void getAllRecommend(Consumer<List<RecommendModel>> consumer,Function<Throwable, List<RecommendModel>> function) {
        setSubscribe(urlService.getAllRecommend(), consumer, function);
    }

}
