package com.mcfish.code;

import android.app.Application;
import android.content.Context;
import android.os.Environment;


import com.mcfish.code.utils.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/10/16
 * Description :
 */


public final class Configurator {
    private final Map<String, Object> CONFIG = new HashMap<>();

    public static Configurator getInstance() {
        return Single.configurator;
    }

    public OkHttpClient getOkHttpClient() {
        return get(ConfigKey.OK_HTTP_CLIENT);
    }

    public Configurator withOkHttpClient(OkHttpClient build) {
        put(ConfigKey.OK_HTTP_CLIENT, build);
        return this;
    }

    private static class Single {
        private static Configurator configurator = new Configurator();
    }


    private void put(ConfigKey configKey, Object object) {
        CONFIG.put(configKey.name(), object);
    }


    private <T> T get(ConfigKey key) {
        return (T) CONFIG.get(key.name());
    }

    /**
     * 配置APiHost
     *
     * @param host
     * @return
     */
    public Configurator withApiHost(String host) {
        put(ConfigKey.API_HOST, host);
        return this;
    }

    /**
     * 配置项目的文件夹
     *
     * @param name
     * @return
     */
    public Configurator withAppFolder(String name) {
        put(ConfigKey.APP_FOLDER, Environment.getExternalStorageDirectory() + File.separator + name);
        return this;
    }

    /**
     * 配置ApplicationContext
     *
     * @param context
     * @return
     */
    public Configurator withApplicationContext(Application context) {
        put(ConfigKey.APPLICATION_CONTEXT, context);
        Utils.init(context);
        return this;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public Context getContext() {
        return get(ConfigKey.APPLICATION_CONTEXT);
    }

    /**
     * 获取PaiHost
     *
     * @return
     */
    public String getApiHost() {
        return get(ConfigKey.API_HOST);
    }

    /**
     * 获取项目文件夹
     *
     * @return
     */
    public String getAppFolder() {
        return get(ConfigKey.APP_FOLDER);
    }

}
