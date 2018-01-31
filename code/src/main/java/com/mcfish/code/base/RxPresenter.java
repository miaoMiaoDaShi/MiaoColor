package com.mcfish.code.base;

import com.hannesdorfmann.mosby3.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mcfish.code.http.BaseDisposable;
import com.mcfish.code.http.BaseResponse;
import com.mcfish.code.http.RetrofitClient;

import io.reactivex.Observable;
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

    @Override
    public void detachView() {
        super.detachView();
        unSubscribe();
    }
}
