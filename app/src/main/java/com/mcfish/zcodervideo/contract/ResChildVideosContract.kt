package com.mcfish.zcodervideo.contract

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.mvp.presenter.RxPresenter
import com.mcfish.zcodervideo.model.bean.ResChildVideosInfo
import io.reactivex.Observable


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :
 */

interface ResChildVideosContract {
    interface View:MvpLceView<ResChildVideosInfo>

    abstract class Presenter:RxPresenter<View>(){
       abstract fun loadResChildVideos(  mcId: String, perPage: Int, pullToRefresh: Boolean)
    }

    abstract class Model :RxModel(){
        abstract fun getResChildVideos(  mcId: String,  page: Int,  perPage: Int):Observable<ResChildVideosInfo>
    }
}