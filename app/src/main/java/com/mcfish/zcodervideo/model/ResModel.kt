package com.mcfish.zcodervideo.model

import com.mcfish.zcodervideo.api.ApiService
import com.mcfish.zcodervideo.compositeRequest
import com.mcfish.zcodervideo.contract.ResContract
import com.mcfish.zcodervideo.model.bean.ResInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class ResModel : ResContract.Model() {
    override fun loadResources(): Observable<ResInfo> {
        return getApi(ApiService::class.java).getResources(parseData(compositeRequest(Unit)))
    }
}