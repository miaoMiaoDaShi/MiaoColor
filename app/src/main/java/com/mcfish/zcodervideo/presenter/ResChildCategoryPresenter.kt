package com.mcfish.zcodervideo.presenter

import com.mcfish.code.http.BaseDisposable
import com.mcfish.code.http.ExceptionHandle
import com.mcfish.zcodervideo.contract.ResChildCategoryContract
import com.mcfish.zcodervideo.model.ResChildCategoryModel
import com.mcfish.zcodervideo.model.bean.ResChildCategoryInfo


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class ResChildCategoryPresenter : ResChildCategoryContract.Presenter() {
    private val model: ResChildCategoryModel by lazy {
        ResChildCategoryModel()
    }
    override fun loadResourcesChildCategory(parentId: String) {
        view.showLoading()
        subscribe(object :BaseDisposable<ResChildCategoryInfo>(model.loadResourcesChildCategory(parentId)){
            override fun onNext(t: ResChildCategoryInfo) {
                view.apply {
                    showResourcesChildCategory(t)
                    dismissLoading()
                }


            }

            override fun onError(e: ExceptionHandle.ResponseThrowable) {
                view.showError(e.errorMessage)
            }
        })
    }
}