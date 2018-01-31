package com.mcfish.zcodervideo.contract;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.mcfish.code.base.RxPresenter;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public interface LceContract {
    interface View<M> extends MvpLceView<M> {

    }

    abstract class Presenter extends RxPresenter<View> {
    }
}
