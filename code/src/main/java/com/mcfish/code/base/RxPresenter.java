package com.mcfish.code.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mcfish.code.Constant;
import com.mcfish.code.http.BaseDisposable;
import com.mcfish.code.http.BaseRequest;
import com.mcfish.code.http.BaseResponse;
import com.mcfish.code.http.RetrofitClient;
import com.mcfish.code.utils.AesEncryptionUtil;
import com.mcfish.code.utils.EncodeUtils;
import com.mcfish.code.utils.EncryptUtils;

import java.util.Map;
import java.util.TreeMap;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/17
 * Description : 当你使用rxJava时,建议你继承此类
 */


public class RxPresenter<V extends MvpView> extends MvpNullObjectBasePresenter<V> {
    protected CompositeDisposable mCompositeDisposable;

    private final void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    /**
     * 获取Observable
     *
     * @param service
     * @param <T>
     * @return
     */
    protected <T> T getApi(final Class<T> service) {
        return RetrofitClient.getApiService(service);
    }

    /**
     * 执行请求
     *
     * @param disposable
     * @param <E>
     * @param <T>
     * @return
     */
    protected final <E extends BaseDisposable<T>, T extends BaseResponse> E enqueue(BaseDisposable<T> disposable) {
        return (E) addSubscribe(RetrofitClient.getInstance().enqueue(disposable));
    }


    private final Disposable addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
        return subscription;
    }

    protected BaseRequest compositeRequest(Object request) {
        final BaseRequest baseRequest = new BaseRequest();
        baseRequest.setData(AesEncryptionUtil.encrypt(new Gson().toJson(request), Constant.AES_PWD, Constant.AES_IV));

        Map<String, String> params = parseData(baseRequest);
        StringBuilder sb = new StringBuilder("");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append("&")
                    .append(entry.getKey())
                    .append("=")
                    .append(EncodeUtils.urlEncode(entry.getValue(), "UTF-8"));
        }
        baseRequest.setSig(EncryptUtils.encryptMD5ToString(sb.toString().substring(1) + Constant.URL_SIG_KEY));
        return baseRequest;
    }

    /**
     * 对象转化为map
     *
     * @param data
     * @return
     */
    public static Map<String, String> parseData(Object data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        Map<String, String> map = gson.fromJson(json, new TypeToken<TreeMap<String, String>>() {
        }.getType());
        return map;
    }

    @Override
    public void detachView() {
        super.detachView();
        unSubscribe();
    }
}
