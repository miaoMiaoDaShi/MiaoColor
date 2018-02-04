package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.LoginContract
import com.mcfish.zcodervideo.model.LoginModel
import com.mcfish.zcodervideo.model.bean.UserInfo
import com.mcfish.zcodervideo.utils.ShareManager


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


class LoginPresenter : LoginContract.Presenter() {
    private val loginModel: LoginModel by lazy {
        LoginModel()
    }


    override fun login(account: String, pwd: String) {
        view.showLoading()
        subscribe(object : BaseDisposable<UserInfo>(LoginModel().login(account, pwd)) {

            override fun onNext(userInfo: UserInfo) {
                ShareManager.saveUserInfo(userInfo)
                view.apply {
                    showLoginSuccess(userInfo)
                    dismissLoading()
                }

            }

            override fun onError(e: ExceptionHandle.ResponseThrowable) {
                view.apply {
                    showError(e.errorMessage)
                    dismissLoading()
                }

            }
        })
    }
}
