package com.rlms.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amitsingh on 30/07/17.
 */

public class ApiResponse {

    @SerializedName("status")
   public boolean status;
    @SerializedName("response")
   public String message;
}
