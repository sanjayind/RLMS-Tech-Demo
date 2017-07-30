package com.rlms.Repository;

/**
 * Enum to be used to define if an api call should be made on the foreground threadpool executor or
 * the background threadpool executor.
 */
public enum ReqPriority {
    HIGH, LOW
}
