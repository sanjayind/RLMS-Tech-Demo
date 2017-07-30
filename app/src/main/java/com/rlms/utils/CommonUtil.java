package com.rlms.utils;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;

import com.google.gson.Gson;
import com.rlms.R;
import com.rlms.exception.ApiException;
import com.rlms.exception.GFYException;

import java.net.HttpURLConnection;
import java.util.ArrayList;


/**
 * Created by srishti on 27/07/17.
 */
public class CommonUtil {

    private static String GCM_TOKEN = "gcm_token";
    private static final String LOGIN_FLAG = "LoginType";
    private static final String MESSAGE = "messages";

    private static SharedPreferences getSP() {
        return PreferenceManager.getDefaultSharedPreferences(RLMSApplication.getAppContext());
    }

    public static String getGCMToken() {
        return getSP().getString(GCM_TOKEN, null);
    }

    public static void saveGCMToken(String token) {
        getSP().edit().putString(GCM_TOKEN, token).commit();
    }

    public static boolean checkIsGuest() {
        return getSP().getBoolean(LOGIN_FLAG, true);
    }

    public static void saveGuestState(boolean state) {
        getSP().edit().putBoolean(LOGIN_FLAG, state).commit();
    }


    public static void clearMessages() {
        getSP().edit().putString(MESSAGE, null).commit();
    }

    public static ArrayList<String> getMessages() {
        Gson gson = new Gson();
        ArrayList<String> messages = new ArrayList<>();
        String json = getSP().getString(MESSAGE, null);
        if (json != null) {
            messages = gson.fromJson(json, messages.getClass());
        }
        return messages;
    }

    public static void saveMessages(ArrayList<String> messages) {
        Gson gson = new Gson();
        String jsonText = gson.toJson(messages);
        getSP().edit().putString(MESSAGE, jsonText).commit();
    }

    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static synchronized String getErrorMessage(GFYException ex) {
        String message = null;
        if (ex != null && ex instanceof ApiException) {
            message = getErrorMessage(((ApiException) ex).getHttpStatusCode());
        } else if (ex != null) {
            message = ex.getLocalizedMessage();
        }
        return message;
    }

    public static synchronized String getErrorMessage(int statusCode) {
        String errorMessage;
        switch (statusCode) {
            case HttpURLConnection.HTTP_BAD_REQUEST: //HttpStatus.SC_BAD_REQUEST:
                errorMessage = RLMSApplication.getAppContext().getResources().getString(R.string.http_400);
                break;
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                errorMessage = RLMSApplication.getAppContext().getResources().getString(R.string.http_401);
                break;
            case HttpURLConnection.HTTP_INTERNAL_ERROR:
                errorMessage = RLMSApplication.getAppContext().getResources().getString(R.string.http_500);
                break;
            case ApiException.NO_CONNECTION_STATUS_CODE:
                errorMessage = RLMSApplication.getAppContext().getResources().getString(R.string.no_connection);
                break;
            default:
                errorMessage = RLMSApplication.getAppContext().getResources().getString(R.string.server_conn_error);
                break;
        }
        return errorMessage;
    }

    public static boolean isWriteStoragePermissionAvailable() {
        int permissionCheck = ContextCompat.checkSelfPermission(RLMSApplication.getAppContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean isReadPhoneStatePermissionAvailable() {
        int permissionCheck = ContextCompat.checkSelfPermission(RLMSApplication.getAppContext(), Manifest.permission.READ_PHONE_STATE);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

}
