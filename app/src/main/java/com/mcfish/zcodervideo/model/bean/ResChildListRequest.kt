package com.mcfish.zcodervideo.model.bean

import com.google.gson.annotations.SerializedName

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :
 */


class ResChildListRequest(
        @SerializedName("mc_id")
        var mcId: String,
        var page: Int,
        var perPage: Int
)
