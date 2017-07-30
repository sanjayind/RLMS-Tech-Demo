package com.rlms.Repository;

import com.google.gson.Gson;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.model.request.ComplaintsRequest;
import com.rlms.model.request.LoginRequest;
import com.rlms.model.response.ApiResponse;


/**
 * Created by srishti on 27/07/17.
 */
public class AuthRepository {
    private static final String AUTHENTICATION_URL = "/RLMS/API/register/registerTechnicianDeviceByMblNo";
    private static final String COMPLAINTS_URL = "/RLMS/API/getAllComplaintsAssigned";

    /**
     * login api..
     */
    public static ApiAsyncTask<ApiResponse> authenticateTechnician(ApiResponseListener listener, ReqPriority reqPriority, LoginRequest loginRequest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + AUTHENTICATION_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(loginRequest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }

    /**
     * get all complaints api..
     */
    public static ApiAsyncTask<ApiResponse> getAllComplaints(ApiResponseListener listener, ReqPriority reqPriority, ComplaintsRequest complaintsRequest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + COMPLAINTS_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(complaintsRequest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }
}
