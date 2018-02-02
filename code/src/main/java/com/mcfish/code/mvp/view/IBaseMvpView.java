package com.mcfish.code.mvp.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


public interface IBaseMvpView extends MvpView{
    void showLoading();

    void dismissLoading();
}
