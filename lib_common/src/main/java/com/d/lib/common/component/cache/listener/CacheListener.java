package com.d.lib.common.component.cache.listener;


public interface CacheListener<T> {
    void onLoading();

    void onSuccess(T result);

    void onError(Throwable e);
}
