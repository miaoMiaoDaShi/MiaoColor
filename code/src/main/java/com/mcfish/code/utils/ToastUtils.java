package com.mcfish.code.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/10/4
 * Description : toast 工具类
 */

public final class ToastUtils {

    private static Toast mToast;

    private ToastUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static void show(String content, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(Utils.getApp(), content, duration);
        } else {
            mToast.setText(content);
        }
        mToast.show();
    }

    public static void show(String content) {
        show(content, Toast.LENGTH_SHORT);
    }

    public static void show(@StringRes int stringId) {
        show(Utils.getApp().getString(stringId), Toast.LENGTH_SHORT);
    }

    public static void showLong(String content) {
        show(content, Toast.LENGTH_LONG);
    }

    public static void showLong(@StringRes int stringId) {
        show(Utils.getApp().getString(stringId), Toast.LENGTH_LONG);
    }
}
