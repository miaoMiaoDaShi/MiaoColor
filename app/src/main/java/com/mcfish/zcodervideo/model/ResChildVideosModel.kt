package com.mcfish.zcodervideo.model

import com.mcfish.zcodervideo.api.ApiService
import com.mcfish.zcodervideo.compositeRequest
import com.mcfish.zcodervideo.contract.ResChildVideosContract
import com.mcfish.zcodervideo.model.bean.ResChildListRequest
import com.mcfish.zcodervideo.model.bean.ResChildVideosInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :
 */

class ResChildVideosModel : ResChildVideosContract.Model() {
    override fun getResChildVideos(mcId: String, page: Int, perPage: Int): Observable<ResChildVideosInfo> {
        return getApi(ApiService::class.java).getChildVideos(parseData(compositeRequest(ResChildListRequest(mcId, page, perPage))))
    }
}