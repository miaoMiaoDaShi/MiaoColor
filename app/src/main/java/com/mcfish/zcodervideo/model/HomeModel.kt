package com.mcfish.zcodervideo.model

import com.mcfish.zcodervideo.api.ApiService
import com.mcfish.zcodervideo.compositeRequest
import com.mcfish.zcodervideo.contract.HomeContract
import com.mcfish.zcodervideo.model.bean.*
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class HomeModel : HomeContract.Model() {
    override fun getBanner(): Observable<BannerInfo>? {
        return null
    }

    override fun getNavigation(uid: String): Observable<HomeNavsInfo> {
        return getApi(ApiService::class.java).getHomeNavInfo(parseData(compositeRequest(HomeNavRequest(uid))))
    }

    override fun getImages(page: Int, perPage: Int, uId: String, isNew: String): Observable<HomeImageInfo> {
        return getApi(ApiService::class.java).getHomeImages(parseData(compositeRequest(HomeImagesRequest(page, perPage, uId, isNew))))
    }
}