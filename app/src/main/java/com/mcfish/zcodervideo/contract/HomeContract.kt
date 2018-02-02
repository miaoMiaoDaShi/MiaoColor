package com.mcfish.zcodervideo.contract

import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.mvp.presenter.RxPresenter
import com.mcfish.code.mvp.view.IBaseMvpView
import com.mcfish.zcodervideo.model.bean.BannerInfo
import com.mcfish.zcodervideo.model.bean.HomeImageInfo
import com.mcfish.zcodervideo.model.bean.HomeNavsInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

interface HomeContract {
    interface View : IBaseMvpView {
        /**
         * 显示banner
         */
        fun showBanner(bannerInfo: BannerInfo)

        /**
         * 显示导航区
         */
        fun showNavigation(navsInfo: HomeNavsInfo)

        /**
         * 显示推荐的图片
         */
        fun showImages(imageInfo: HomeImageInfo)

        /**
         * 显示error
         */
        fun showError(e: String)
    }

    abstract class Presenter : RxPresenter<View>() {
        /**
         * 加载首页数据
         */
        abstract fun loadHomeData()

        abstract fun loadMoreData()
    }

    abstract class Model : RxModel() {
        abstract fun getBanner(): Observable<BannerInfo>?
        abstract fun getNavigation(uid: String): Observable<HomeNavsInfo>
        abstract fun getImages(page:Int,perPage:Int,uId:String,isNew:String): Observable<HomeImageInfo>
    }


}