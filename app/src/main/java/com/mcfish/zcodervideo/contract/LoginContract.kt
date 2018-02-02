package com.mcfish.zcodervideo.contract

import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.mvp.presenter.RxPresenter
import com.mcfish.code.mvp.view.IBaseMvpView
import com.mcfish.zcodervideo.model.bean.UserInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

interface LoginContract {
    interface View : IBaseMvpView {
        fun showLoginSuccess(userInfo: UserInfo)

        fun showError(e: String)
    }

    abstract class Presenter : RxPresenter<View>() {
        abstract fun login(account: String, pwd: String)
    }

    abstract class Model :RxModel(){
        abstract fun login(account: String, pwd: String): Observable<UserInfo>
    }
}