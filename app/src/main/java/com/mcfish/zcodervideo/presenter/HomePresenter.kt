package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.HomeContract
import com.mcfish.zcodervideo.model.HomeModel
import com.mcfish.zcodervideo.model.bean.HomeImageInfo
import com.mcfish.zcodervideo.model.bean.HomeImagesRequest
import com.mcfish.zcodervideo.model.bean.HomeNavsInfo
import com.mcfish.zcodervideo.utils.ShareManager


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class HomePresenter : HomeContract.Presenter() {

    private var page = 1

    private val homeModel: HomeModel by lazy {
        HomeModel()
    }

    override fun loadHomeData() {
        view.showLoading()
        subscribe(object : BaseDisposable<HomeNavsInfo>(homeModel
                .getNavigation(ShareManager.getUserInfo().data.mu_id)) {
            override fun onNext(t: HomeNavsInfo) {
                view.showNavigation(t)
                loadMoreData()
            }

            override fun onError(e: ExceptionHandle.ResponseThrowable) {
                view.apply {
                    showError(e.errorMessage)
                    dismissLoading()
                }

            }

        })
    }

    override fun loadMoreData() {
        subscribe(object : BaseDisposable<HomeImageInfo>(homeModel
                .getImages(page, 10, ShareManager.getUserInfo().data.mu_id, "0")) {
            override fun onNext(t: HomeImageInfo) {
                view.apply {
                    showImages(t)
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
        page++
    }
}