package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.ResContract
import com.mcfish.zcodervideo.model.ResModel
import com.mcfish.zcodervideo.model.bean.ResInfo


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class ResPresenter : ResContract.Presenter() {
    private val resourcesModel: ResModel by lazy {
        ResModel()
    }

    override fun loadResources() {
        view.showLoading()
        subscribe(object : BaseDisposable<ResInfo>(resourcesModel.loadResources()) {
            override fun onError(e: ExceptionHandle.ResponseThrowable) {
                view.showError(e.errorMessage)
                view.dismissLoading()
            }

            override fun onNext(t: ResInfo) {
                view.showResources(t)
                view.dismissLoading()
            }
        })
    }
}