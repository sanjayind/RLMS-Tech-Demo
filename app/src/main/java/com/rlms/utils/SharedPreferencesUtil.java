package com.rlms.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesUtil {

    public static final String USER_ID = "USER_ID";


    public static String getUserId(Context c) {
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(c);
        return shared.getString(USER_ID, null);
    }

    public static void setUserId(Context c, String email) {
        SharedPreferences.Editor sharedEditor = PreferenceManager.getDefaultSharedPreferences(c).edit();
        sharedEditor.putString(USER_ID, email);
        sharedEditor.commit();
    }
}
