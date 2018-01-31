package com.mcfish.code.http;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/8
 * Description :
 */

public class BaseResponse implements Parcelable {

    private int status;
    private String resmsg;
    private int totalrow;

    public int getStatus() {
        return status;
    }

    public int getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(int totalrow) {
        this.totalrow = totalrow;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResmsg() {
        return resmsg;
    }

    public void setResmsg(String resmsg) {
        this.resmsg = resmsg;
    }


    public boolean isOk() {
        return status == 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.status);
        dest.writeString(this.resmsg);
        dest.writeInt(this.totalrow);
    }

    public BaseResponse() {
    }

    protected BaseResponse(Parcel in) {
        this.status = in.readInt();
        this.resmsg = in.readString();
        this.totalrow = in.readInt();
    }

    public static final Parcelable.Creator<BaseResponse> CREATOR = new Parcelable.Creator<BaseResponse>() {
        @Override
        public BaseResponse createFromParcel(Parcel source) {
            return new BaseResponse(source);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };
}
