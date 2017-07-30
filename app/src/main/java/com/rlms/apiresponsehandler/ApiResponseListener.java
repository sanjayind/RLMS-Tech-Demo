package com.rlms.apiresponsehandler;

import com.rlms.exception.ApiException;

public interface ApiResponseListener<T> {

    void onSuccess(T response, APIResponseMode apiResponseMode);

    void onError(T response, ApiException exception);

    enum APIResponseMode {
        API_RESPONSE_MODE_ONLINE, API_RESPONSE_MODE_CACHE
    }
}
