package com.d.lib.rxnet.base;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Config
 */
class Config {
    static String TAG_LOG = "RetrofitLog Back = ";
    static HttpLoggingInterceptor.Level LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;

    /****************** Default ******************/
    static final String BASE_URL = "https://www.google.com/";
    static final long CONNECT_TIMEOUT = 10 * 1000;
    static final long READ_TIMEOUT = 10 * 1000;
    static final long WRITE_TIMEOUT = 10 * 1000;
    static final int RETRY_COUNT = 3; // Default retries
    static final long RETRY_DELAY_MILLIS = 3 * 1000; // Default retry interval (ms)
}
