package com.mcfish.zcodervideo.model;

import com.mcfish.zcodervideo.entity.HomeNavsInfo;
import com.mcfish.zcodervideo.entity.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public interface CeService {
    /**
     * 登录
     * @param request
     * @return
     */
    @POST("api/users/login")
    @FormUrlEncoded
    Observable<UserInfo> login(@FieldMap Map<String, String> request);

    @POST("api/Community/index")
    @FormUrlEncoded
    Observable<HomeNavsInfo> getHomeNavInfo(@FieldMap Map<String, String> request);
}
