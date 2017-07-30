package com.rlms.Repository;

import com.rlms.core.GFYAppContext;

/**
 * Created by srishti on 27/07/17.
 */
public class APIHelper {

    private static String mBaseurl;
    private static String mAuthheader;
    private static String mAcceptHeader = "text/json";
    private static String mContentType = "application/json";
    private static int mConnectionTimeOut = 10000;

    public static String getBaseUrl() {
        if (mBaseurl == null) {
            mBaseurl = APIConstants.BASE_URL;
        }
        return mBaseurl;
    }

    public static String getAcceptHeader() {
        return mAcceptHeader;
    }

    public static String getAuthorizationHeader() {
        String accesssToken = GFYAppContext.getToken();
        mAuthheader = "accesstoken=" + accesssToken;
        return mAuthheader;
    }

    public static String getContentType() {
        return mContentType;
    }

    public static void setmContentType(String mContentType) {
        APIHelper.mContentType = mContentType;
    }

    public static int getConnectionTimeOut() {
        return mConnectionTimeOut;
    }
}
