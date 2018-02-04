package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.ResChildVideosContract
import com.mcfish.zcodervideo.model.ResChildVideosModel
import com.mcfish.zcodervideo.model.bean.ResChildVideosInfo


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :
 */


class ResChildVideosPresenter : ResChildVideosContract.Presenter() {
    private val modle: ResChildVideosModel by lazy {
        ResChildVideosModel()
    }

    private var page = 1

    override fun loadResChildVideos(mcId: String, perPage: Int, pullToRefresh: Boolean) {
        subscribe(object : BaseDisposable<ResChildVideosInfo>(modle.getResChildVideos(mcId, page, perPage)) {
            override fun onNext(t: ResChildVideosInfo) {
                view.apply {
                    showContent()
                    setData(t)
                }
            }

            override fun onError(e: ExceptionHandle.ResponseThrowable?) {
                view.apply {
                    showError(e, pullToRefresh)
                }
            }
        })

        page++
    }
}
