package com.d.lib.common.component.cache.base;

import android.content.Context;


public class CacheManager {
    protected volatile static ACache aCache;

    protected CacheManager(Context context) {
        init(context.getApplicationContext());
    }

    private void init(Context context) {
        if (aCache == null) {
            synchronized (CacheManager.class) {
                if (aCache == null) {
                    aCache = ACache.get(context);
                }
            }
        }
    }
}
