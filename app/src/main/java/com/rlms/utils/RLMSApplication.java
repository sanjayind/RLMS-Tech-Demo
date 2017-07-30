package com.rlms.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 12/4/17.
 */

public class RLMSApplication extends Application  {

    private static RLMSApplication mApplication;

    public static Context getAppContext() {
        return mApplication;
    }

    public static RLMSApplication getApplicationInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplication == null)
            mApplication = this;
    }
}
