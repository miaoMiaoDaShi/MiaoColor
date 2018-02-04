package com.mcfish.zcodervideo.contract

import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.mvp.presenter.RxPresenter
import com.mcfish.code.mvp.view.IBaseMvpView
import com.mcfish.zcodervideo.model.bean.ResChildCategoryInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

interface ResChildCategoryContract {
    interface View : IBaseMvpView {
        fun showResourcesChildCategory(resourcesChildCategoryInfo: ResChildCategoryInfo)
        fun showError(string: String)
    }

    abstract class Presenter : RxPresenter<View>() {
        abstract fun loadResourcesChildCategory(parentId: String)
    }

    abstract class Model : RxModel() {
        abstract fun loadResourcesChildCategory(parentId: String): Observable<ResChildCategoryInfo>
    }

}