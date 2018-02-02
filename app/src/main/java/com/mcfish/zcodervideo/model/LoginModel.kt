package com.mcfish.zcodervideo.model

import com.mcfish.zcodervideo.api.ApiService
import com.mcfish.zcodervideo.compositeRequest
import com.mcfish.zcodervideo.contract.LoginContract
import com.mcfish.zcodervideo.model.bean.LoginRequest
import com.mcfish.zcodervideo.model.bean.UserInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class LoginModel : LoginContract.Model() {
    override fun login(account: String, pwd: String): Observable<UserInfo> {
        return getApi(ApiService::class.java).login(parseData(compositeRequest(LoginRequest(account, pwd))))
    }
}