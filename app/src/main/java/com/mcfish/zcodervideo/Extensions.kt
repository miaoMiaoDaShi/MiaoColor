package com.mcfish.zcodervideo

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import com.mcfish.code.Configurator
import com.mcfish.code.http.BaseRequest
import com.mcfish.code.mvp.model.RxModel
import com.mcfish.code.Constant.URL_SIG_KEY
import com.mcfish.code.utils.EncryptUtils
import com.mcfish.code.utils.EncodeUtils
import com.mcfish.code.Constant.AES_IV
import com.mcfish.code.Constant.AES_PWD
import com.google.gson.Gson
import com.mcfish.code.mvp.model.RxModel.parseData
import com.mcfish.code.utils.AesEncryptionUtil
import com.mcfish.zcodervideo.model.bean.UserInfo
import com.mcfish.zcodervideo.utils.ShareManager


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity!!.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun RxModel.compositeRequest(request: Any): BaseRequest {
    val baseRequest = BaseRequest()

    if (request != null) {
        baseRequest.data = AesEncryptionUtil.encrypt(Gson().toJson(request), Constant.AES_PWD, Constant.AES_IV)
    }

    val params = parseData(baseRequest)
    val sb = StringBuilder("")
    for (entry in params.entries) {
        sb.append("&")
                .append(entry.key)
                .append("=")
                .append(EncodeUtils.urlEncode(entry.value, "UTF-8"))
    }
    baseRequest.sig = EncryptUtils.encryptMD5ToString(sb.toString().substring(1) + Constant.URL_SIG_KEY)
    return baseRequest
}