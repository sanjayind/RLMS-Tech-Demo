package com.rlms.exception;

/**
 * Created by srishti on 27/07/17.
 */
public class ApiException extends GFYException {
    public static final int NO_CONNECTION_STATUS_CODE = 601;

    private int httpStatusCode;
    private API_EXCEPTION_TYPE exceptionType;

    public ApiException(int httpStatusCode, API_EXCEPTION_TYPE exceptionType, String detailMessage) {
        super(detailMessage);
        this.httpStatusCode = httpStatusCode;
        this.exceptionType = exceptionType;
    }

    public ApiException(API_EXCEPTION_TYPE exceptionType, String detailMessage) {
        super(detailMessage);
        this.exceptionType = exceptionType;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public enum API_EXCEPTION_TYPE {
        HTTP_EXCEPTION, IO_EXCEPTION, NO_INTERNET_EXCEPTION
    }
}
