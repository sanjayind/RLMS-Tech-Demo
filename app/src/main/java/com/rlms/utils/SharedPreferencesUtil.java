package com.rlms.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesUtil {

    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";


    public static String getEmail(Context c) {
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(c);
        return shared.getString(EMAIL, null);
    }

    public static void setEmail(Context c, String email) {
        SharedPreferences.Editor sharedEditor = PreferenceManager.getDefaultSharedPreferences(c).edit();
        sharedEditor.putString(EMAIL, email);
        sharedEditor.commit();
    }

    public static String getPassword(Context c) {
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(c);
        return shared.getString(PASSWORD, null);
    }

    public static void setPassword(Context c, String password) {
        SharedPreferences.Editor sharedEditor = PreferenceManager.getDefaultSharedPreferences(c).edit();
        sharedEditor.putString(PASSWORD, password);
        sharedEditor.commit();
    }

    public static void resetData(Context c) {
        setPassword(c, null);
        setEmail(c, null);
    }
}
