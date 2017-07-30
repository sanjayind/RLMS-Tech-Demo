package com.rlms.Repository;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A thread pool executor which will schedule api calls required for foreground operations.
 * It uses a LinkedBlockingQueue which will cause the apis to be executed in FIFO order.
 */
public class ForegroundReqExecutor extends ThreadPoolExecutor {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 0;

    private static ForegroundReqExecutor instance;

    private ForegroundReqExecutor() {
        super(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }

    public static ForegroundReqExecutor getInstance() {
        if(instance == null) {
            instance = new ForegroundReqExecutor();
        }
        return instance;
    }

}
