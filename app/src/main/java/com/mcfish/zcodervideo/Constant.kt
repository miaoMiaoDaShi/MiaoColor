package com.mcfish.zcodervideo


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */

class Constant private constructor(){
    companion object {
        val AES_IV = "5efd3f6060emaomi"
        val AES_PWD = "625202f9149maomi"
        var BACKUP_DOMAIN = "123.huhul1l.com"
        val URL_SIG_KEY = "maomi_pass_xyz"
    }


    enum class MemoryUnit {
        BYTE,
        KB,
        MB,
        GB
    }

    enum class TimeUnit {
        MSEC,
        SEC,
        MIN,
        HOUR,
        DAY
    }

}