package com.mcfish.code.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;

public class AppUtils {
    private static Context mContext;
    private static Handler sHandler = new Handler(Looper.getMainLooper());



    public static Context getAppContext() {
        return mContext;
    }

    public static AssetManager getAssets() {
        return mContext.getAssets();
    }

    public static Resources getResource() {
        return mContext.getResources();
    }



    public static void runOnUI(Runnable r) {
        sHandler.post(r);
    }

    public static void runOnUIDelayed(Runnable r, long delayMills) {
        sHandler.postDelayed(r, delayMills);
    }

    public static void removeRunnable(Runnable r) {
        if (r == null) {
            sHandler.removeCallbacksAndMessages(null);
        } else {
            sHandler.removeCallbacks(r);
        }
    }

    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getAppVersionName() {
        return getAppVersionName(Utils.getApp(), Utils.getApp().getPackageName());
    }

    public static String getAppVersionName(Context context, String packageName) {
        String str = null;
        if (!StringUtils.isSpace(packageName)) {
            try {
                PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
                if (pi != null) {
                    str = pi.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp(), Utils.getApp().getPackageName());
    }

    public static int getAppVersionCode(Context context, String packageName) {
        int i = 1;
        if (!StringUtils.isSpace(packageName)) {
            try {
                PackageInfo pi = context.getPackageManager().getPackageInfo(packageName, 0);
                if (pi != null) {
                    i = pi.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            return model.trim().replaceAll("\\s*", "");
        }
        return "";
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID() {
        @SuppressLint("MissingPermission") String deviceId = ((TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return TextUtils.isEmpty(deviceId) ? Settings.Secure.getString(Utils.getApp().getContentResolver(), "android_id") : deviceId;
    }

    public static int[] getScreenDispaly() {
        WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService(Context.WINDOW_SERVICE);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        return new int[]{width, height};
    }
}