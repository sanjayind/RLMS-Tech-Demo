package com.rlms.Repository;

/**
 * Created by srishti on 27/07/17.
 */
public enum HttpMethod {
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE");

    private String value = null;

    HttpMethod(String value) {
        this.value = value;
    }

    public String getHttpMethodString() {
        return this.value;
    }
}
