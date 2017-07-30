package com.rlms.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by srishti on 27/07/17.
 */
public class MobileAppInfo {
    @SerializedName("mobileAppVersion")
    private String mAppVersion;

    public String getAppVersion() {
        return mAppVersion;
    }

    public void setAppVersion(String appVersion) {
        mAppVersion = appVersion;
    }
}
