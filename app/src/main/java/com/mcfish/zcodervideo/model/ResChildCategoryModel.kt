package com.mcfish.zcodervideo.model

import com.mcfish.zcodervideo.api.ApiService
import com.mcfish.zcodervideo.compositeRequest
import com.mcfish.zcodervideo.contract.ResChildCategoryContract
import com.mcfish.zcodervideo.model.bean.ResChildCategoryInfo
import com.mcfish.zcodervideo.model.bean.ResChildCategoryRequest
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class ResChildCategoryModel : ResChildCategoryContract.Model() {
    override fun loadResourcesChildCategory(parentId: String):Observable<ResChildCategoryInfo> {
        return getApi(ApiService::class.java).getChildCategory(parseData(compositeRequest(ResChildCategoryRequest(parentId))))
    }
}