package com.rlms.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amitsingh on 20/02/18.
 */

public class LiftInfoResponse {

    @SerializedName("liftId")
    private int liftId;
    @SerializedName("liftNumber")
    private String liftNumber;
    @SerializedName("liftCustomerMapId")
    private int liftCustoMapId;

    public int getLiftId() {
        return liftId;
    }

    public void setLiftId(int liftId) {
        this.liftId = liftId;
    }

    public String getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(String liftNumber) {
        this.liftNumber = liftNumber;
    }

    public int getLiftCustoMapId() {
        return liftCustoMapId;
    }

    public void setLiftCustoMapId(int liftCustoMapId) {
        this.liftCustoMapId = liftCustoMapId;
    }
}
