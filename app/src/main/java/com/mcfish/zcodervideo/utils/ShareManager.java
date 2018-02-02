package com.mcfish.zcodervideo.utils;

import com.google.gson.Gson;
import com.mcfish.code.utils.SPUtils;
import com.mcfish.zcodervideo.model.bean.BannerInfo;
import com.mcfish.zcodervideo.model.bean.UserInfo;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/1
 * Description :
 */


public class ShareManager {

    /**
     * 存储用户信息
     *
     * @param info
     */
    public static void saveUserInfo(UserInfo info) {
        SPUtils.getInstance().put("userInfo", new Gson().toJson(info), true);
    }

    /**
     * 读取用户信息
     *
     * @return
     */
    public static UserInfo getUserInfo() {
        return new Gson().fromJson(SPUtils.getInstance().getString("userInfo"), UserInfo.class);
    }

    /**
     * 获取主页Banner信息
     */
    public static BannerInfo getHomeBannerInfo() {
        return new Gson().fromJson(SPUtils.getInstance().getString("homeBanner", ""), BannerInfo.class);
    }

    /**
     * 存储主页banner信息
     */
    public static void saveHomeBannerInfo(BannerInfo bannerInfo) {
        if (bannerInfo == null) {
            return;
        }
        SPUtils.getInstance().put("homeBanner", new Gson().toJson(bannerInfo));
    }

}
