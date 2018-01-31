package com.mcfish.code.http;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/10
 * Description :
 */

public abstract class BaseDisposable<T> extends DisposableObserver<T> {

    private final Observable<T> mObservable;

    Observable<T> getObservable() {
        return mObservable;
    }

    public BaseDisposable(Observable<T> observable) {
        mObservable = observable;
    }

    @Override
    public final void onError(Throwable e) {
        if (e instanceof ExceptionHandle.ResponseThrowable) {
            onError((ExceptionHandle.ResponseThrowable) e);
        } else {
            onError(new ExceptionHandle.ResponseThrowable(e, ExceptionHandle.ERROR_CODE.UNKNOWN));
        }

    }


    @Override
    public void onComplete() {

    }

    public abstract void onError(ExceptionHandle.ResponseThrowable e);

}
