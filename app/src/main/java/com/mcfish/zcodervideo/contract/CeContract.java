package com.mcfish.zcodervideo.contract;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mcfish.code.base.RxPresenter;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public interface CeContract {
    interface View<M> extends MvpView {
        void onSuccess(M m);
        void onError(String e);
    }

    abstract class Presenter extends RxPresenter<View> {
    }
}
