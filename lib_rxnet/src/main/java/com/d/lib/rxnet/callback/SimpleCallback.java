package com.d.lib.rxnet.callback;

/**
 * SimpleCallback
 */
public interface SimpleCallback<R> {
    void onSuccess(R response);

    void onError(Throwable e);
}
