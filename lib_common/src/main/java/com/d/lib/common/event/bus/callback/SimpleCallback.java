package com.d.lib.common.event.bus.callback;

/**
 * SimpleCallback
 */
public interface SimpleCallback<R> {
    void onSuccess(R response);

    void onError(Throwable e);
}
