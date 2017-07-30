package com.rlms.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by srishti on 27/07/17.
 */
public class GuestDeviceInfo {
    @SerializedName("deviceInfo")
    private DeviceInfo mInfo;

    @SerializedName("mobileAppInfo")
    private MobileAppInfo mAppInfo;

    public DeviceInfo getInfo() {
        return mInfo;
    }

    public void setInfo(DeviceInfo info) {
        mInfo = info;
    }

    public MobileAppInfo getAppInfo() {
        return mAppInfo;
    }

    public void setAppInfo(MobileAppInfo appInfo) {
        mAppInfo = appInfo;
    }
}
