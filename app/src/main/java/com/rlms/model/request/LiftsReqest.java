package com.rlms.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amitsingh on 20/02/18.
 */

public class LiftsReqest {

    private int userRoleId;

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}
