package com.rlms.Repository;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Use this class for scheduling background api operations on a lower priority.
 */
public class BackgroundReqExecutor extends ThreadPoolExecutor {

    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 2;
    private static final int KEEP_ALIVE_TIME = 0;

    private static BackgroundReqExecutor instance;

    private BackgroundReqExecutor() {
        super(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }

    public static BackgroundReqExecutor getInstance() {
        if(instance == null) {
            instance = new BackgroundReqExecutor();
        }
        return instance;
    }

}
