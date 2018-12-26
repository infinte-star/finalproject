package com.d.lib.common.component.cache;

import com.d.lib.common.component.cache.utils.threadpool.ThreadPool;

/**
 * Cache
 */
public class Cache {
    public static void setThreadPool(ThreadPool pool) {
        ThreadPool.setThreadPool(pool);
    }
}
