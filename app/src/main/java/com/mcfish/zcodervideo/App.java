package com.mcfish.zcodervideo;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.mcfish.code.Configurator;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/1
 * Description :
 */


public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Configurator.getInstance()
                .withApiHost("http://119.28.59.47:8089/")
                .withApplicationContext(this);
    }
}
