package com.rlms.core;

/**
 * Created by srishti on 27/07/17.
 */
public class GFYAppContext {

    private static String token;

    synchronized public static String getToken() {
        if (token == null) {
            token = "123456";
        }
        return token;
    }

    public static void deleteUser() {
        token = null;
    }
}
