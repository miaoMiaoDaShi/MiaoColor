package com.mcfish.code.mvp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mcfish.code.http.RetrofitClient;

import java.util.Map;
import java.util.TreeMap;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description : 如果你使用RxJava+Retrofit 建议你继承此model
 */


public abstract class RxModel {
    /**
     * 对象转化为map
     *
     * @param data
     * @return
     */
    public static Map<String, String> parseData(Object data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        Map<String, String> map = gson.fromJson(json, new TypeToken<TreeMap<String, String>>() {
        }.getType());
        return map;
    }

    /**
     * 获取Observable
     *
     * @param service
     * @param <T>
     * @return
     */
    protected <T> T getApi(final Class<T> service) {
        return RetrofitClient.getApiService(service);
    }
}
