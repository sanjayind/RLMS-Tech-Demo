package com.rlms.network.webapi;

import com.rlms.model.RLMSAPIResponse;
import com.rlms.model.response.ComplaintsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIToMarkAsResolved {

    @Headers("Accept: application/json")
    @POST("/RLMS/API/updateComplaintStatus")
    Call<RLMSAPIResponse> updateComplaintStatus(
            @Body ComplaintsResponse complaint);

}
