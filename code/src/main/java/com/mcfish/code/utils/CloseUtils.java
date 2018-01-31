package com.mcfish.code.utils;

import android.app.Activity;

import java.io.Closeable;
import java.io.IOException;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/6
 * Description : 啥都能关
 */

public final class CloseUtils {

    private CloseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 关闭 IO
     *
     * @param closeables closeables
     */
    public static void closeIO(final Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 暴力退出
     */
    public static void closeApp() {
        System.exit(0);
    }

    /**
     * 只是退出Activity,适用于含有推送服务的应用
     */
    public static void closeActivity() {
        for (Activity activity : Utils.sActivityList) {
            if (activity != null) {
                activity.finish();
            }
        }
    }


}