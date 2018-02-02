package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.LoginContract
import com.mcfish.zcodervideo.model.LoginModel
import com.mcfish.zcodervideo.model.bean.UserInfo

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


class Test : LoginContract.Presenter() {
    override fun login(account: String, pwd: String) {
        subscribe(object : BaseDisposable<UserInfo>(LoginModel().login(account, pwd)) {

            override fun onNext(userInfo: UserInfo) {

            }

            override fun onError(e: ExceptionHandle.ResponseThrowable) {
                view.showError(e.errorMessage)
            }
        })
    }
}
