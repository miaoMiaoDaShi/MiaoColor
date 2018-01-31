package com.mcfish.zcodervideo.entity;

import com.google.gson.annotations.SerializedName;
import com.mcfish.code.utils.AppUtils;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description : 基本的需要上传的参数
 */


public class BaseRequest {
    @SerializedName("_app_version")
    private String appVersion;
    @SerializedName("_device_version")
    private String deviceVersion;
    @SerializedName("_device_id")
    private String deviceId;
    @SerializedName("_device_type")
    private String deviceType;
    @SerializedName("_sdk_version")
    private String sdkVersion;
    private String sig;
    private String data;

    public BaseRequest() {
        deviceId = AppUtils.getAndroidID(AppUtils.getAppContext());
        appVersion = AppUtils.getAppVersionName(AppUtils.getAppContext());
        deviceType = AppUtils.getModel();
        sdkVersion = AppUtils.getSDKVersion();
        deviceVersion = AppUtils.getOSVersion();

    }


    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
