package com.rlms.Repository;

import com.google.gson.Gson;
import com.rlms.apiresponsehandler.ApiResponseListener;
import com.rlms.model.LiftDetails;
import com.rlms.model.request.ComplaintStatusRequest;
import com.rlms.model.request.ComplaintsRequest;
import com.rlms.model.request.LiftDetailsRequest;
import com.rlms.model.request.LiftsReqest;
import com.rlms.model.request.LoginRequest;
import com.rlms.model.response.ApiResponse;


/**
 * Created by srishti on 27/07/17.
 */
public class AuthRepository {
    private static final String AUTHENTICATION_URL = "/RLMS/API/register/registerTechnicianDeviceByMblNo";
    private static final String COMPLAINTS_URL = "/RLMS/API/getAllComplaintsAssigned";
    private static final String COMPLAINT_STATUS_URL = "/RLMS/API/updateComplaintStatus";
    private static final String UPLOAD_IMAGE_URL = "RLMS/API/complaints/uploadPhotos";
    private static final String LIFTS_URL = "/RLMS/API/lift/getApplicableLifts";
    private static final String LIFT_Details_URL = "/RLMS/API/lift/getLiftParameters";
    private static final String UPDATE_LIFT_Details_URL = "/RLMS/API/lift/updateLiftDetails";



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

    /**
     * get all lifts api..
     */
    public static ApiAsyncTask<ApiResponse> getAllLifts(ApiResponseListener listener, ReqPriority reqPriority, LiftsReqest liftsReqest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + LIFTS_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(liftsReqest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }

    /**
     * get lift details api..
     */
    public static ApiAsyncTask<ApiResponse> getLiftDetails(ApiResponseListener listener, ReqPriority reqPriority, LiftDetailsRequest liftDetailsRequest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + LIFT_Details_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(liftDetailsRequest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }
    /**
     * update lift details api..
     */
    public static ApiAsyncTask<ApiResponse> updateLiftDetails(ApiResponseListener listener, ReqPriority reqPriority, LiftDetails liftDetailsRequest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + UPDATE_LIFT_Details_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(liftDetailsRequest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }
    /**
     * update complaint status api..
     */
    public static ApiAsyncTask<ApiResponse> updateComplaintStatus(ApiResponseListener listener, ReqPriority reqPriority, ComplaintStatusRequest complaintStatusRequest) {
        RestClient restClient = new RestClient(APIHelper.getBaseUrl() + COMPLAINT_STATUS_URL, HttpMethod.POST);
        Gson gson = new Gson();
        String body = gson.toJson(complaintStatusRequest);
        restClient.setBody(body);
        ApiAsyncTask<ApiResponse> apiAsyncTask = new ApiAsyncTask<ApiResponse>(listener, ApiResponse.class);
        apiAsyncTask.startRequestExecution(restClient, reqPriority);
        return apiAsyncTask;
    }

    /**
     * Upload images
     */
//    public static ApiAsyncTask uploadUserPicture(String userId, String groupName, IDataResponseListener<UploadImageResponse> responseListener, ReqPriority reqPriority, ByteArrayInputStream stream) {
//        FileUploadRestClient restClient = new FileUploadRestClient(getUploadPictureUrl(groupName, angle, resolution, userId), HttpMethod.POST);
//        restClient.setBody(stream);
//        ApiAsyncTask apiAsyncTask = new ApiAsyncTask<>(responseListener, UploadImageResponse.class);
//        return apiAsyncTask.startRequestExecution(restClient, reqPriority);
//    }
//
//    public static String getUploadPictureUrl(String groupName, PictureAngle angle, PictureResolution resolution, String userId) {
//        JewelfieURIQueryStringEncoder encoder = new JewelfieURIQueryStringEncoder(String.format((JFNetworkLibAPIHelper.getBaseUrl() + UPLOAD_USER_PICTURES), userId != null ? userId : USER_ID));
//        encoder.setQueryParam(JewelfieQueryParams.RESOLUTION, resolution.toString());
//        encoder.setQueryParam(JewelfieQueryParams.PICTUREANGLE, angle.toString());
//        encoder.setQueryParam(JewelfieQueryParams.GROUP_NAME, groupName);
//        return encoder.build();
//    }
}
