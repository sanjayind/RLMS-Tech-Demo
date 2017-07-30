package com.rlms.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by srishti on 27/07/17.
 */
public class DeviceInfo {
    @SerializedName("deviceIdentifier")
    private String mDeviceidentifier;

    @SerializedName("deviceName")
    private String mDevicename;

    public String getDeviceidentifier() {
        return mDeviceidentifier;
    }

    public void setDeviceidentifier(String deviceidentifier) {
        mDeviceidentifier = deviceidentifier;
    }

    public String getDevicename() {
        return mDevicename;
    }

    public void setDevicename(String devicename) {
        mDevicename = devicename;
    }
}
