package com.mcfish.zcodervideo.api

import com.mcfish.zcodervideo.model.bean.*
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

interface ApiService {
    /**
     * 登录
     * @param request
     * @return
     */
    @POST("api/users/login")
    @FormUrlEncoded
    fun login(@FieldMap request: Map<String, String>): Observable<UserInfo>

    /**
     * 导航
     */
    @POST("api/Community/index")
    @FormUrlEncoded
    fun getHomeNavInfo(@FieldMap request: Map<String, String>): Observable<HomeNavsInfo>

    /**
     * 首页的图片
     */
    @POST("api/community/listArticles")
    @FormUrlEncoded
    fun getHomeImages(@FieldMap request: Map<String, String>): Observable<HomeImageInfo>

    /**
     * 资源分类
     */
    @POST("api/resource/newCatsList")
    @FormUrlEncoded
    fun getResources(@FieldMap request: Map<String, String>): Observable<ResInfo>

    /**
     * 资源分类下的子分类
     */
    @POST("api/cats/getChildList")
    @FormUrlEncoded
    fun getChildCategory(@FieldMap request: Map<String, String>): Observable<ResChildCategoryInfo>


    /***
     * 资源分类下的详情列表 视频
     */
    @POST("api/videos/listAll")
    @FormUrlEncoded
    fun getChildVideos(@FieldMap request: Map<String, String>): Observable<ResChildVideosInfo>

    /***
     * 资源分类下的详情列表 图片
     */
    @POST("api/photos/listAll")
    @FormUrlEncoded
    fun getChildPhotos(@FieldMap request: Map<String, String>): Observable<ResChildPhotosInfo>

    /***
     * 资源分类下的详情列表 声音
     */
    @POST("api/sounds/listAll")
    @FormUrlEncoded
    fun getChildSounds(@FieldMap request: Map<String, String>): Observable<ResChildSoundsInfo>

    /***
     * 资源分类下的详情列表 小说
     */
    @POST("api/novels/listAll")
    @FormUrlEncoded
    fun getChildNovels(@FieldMap request: Map<String, String>): Observable<ResChildNovelsInfo>
}