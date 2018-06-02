package com.rlms.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amitsingh on 16/11/17.
 */

public class LiftParamResponse {

    public LiftParamResponse() {
    }

    @SerializedName("paramKey")
    private String paramKey;

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @SerializedName("paramValue")
    private String paramValue;
}
