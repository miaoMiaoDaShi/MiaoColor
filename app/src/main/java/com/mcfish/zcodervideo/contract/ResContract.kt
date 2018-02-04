package com.mcfish.zcodervideo.contract

import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.mvp.presenter.RxPresenter
import com.mcfish.code.mvp.view.IBaseMvpView
import com.mcfish.zcodervideo.model.bean.ResInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

interface ResContract {
    interface View :IBaseMvpView{
        fun showResources(resourcesInfo: ResInfo)

        fun showError(string: String)
    }

    abstract class Presenter:RxPresenter<View>(){
        abstract fun loadResources()
    }

    abstract class Model :RxModel(){
        abstract fun loadResources():Observable<ResInfo>
    }
}