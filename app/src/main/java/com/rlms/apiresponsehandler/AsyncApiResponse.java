package com.rlms.apiresponsehandler;

import com.rlms.exception.ApiException;

public class AsyncApiResponse<T> {
    private ApiException mException;
    private T mResponseModel;
    private ApiResponseListener.APIResponseMode mApiResponseMode = ApiResponseListener.APIResponseMode.API_RESPONSE_MODE_ONLINE;

    public AsyncApiResponse(T classType) {
        this.mResponseModel = classType;
    }

    public AsyncApiResponse(ApiException exception) {
        this.mException = exception;
    }

    public ApiResponseListener.APIResponseMode getApiResponseMode() {
        return mApiResponseMode;
    }

    public void setApiResponseMode(ApiResponseListener.APIResponseMode responseMode) {
        this.mApiResponseMode = responseMode;
    }

    public T getResultModel() {
        return mResponseModel;
    }

    public ApiException getException() {
        return mException;
    }
}
