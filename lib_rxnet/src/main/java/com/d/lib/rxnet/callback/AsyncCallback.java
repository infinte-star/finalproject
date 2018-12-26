package com.d.lib.rxnet.callback;

import io.reactivex.annotations.NonNull;

/**
 * AsyncCallback
 */
public interface AsyncCallback<T, R> extends SimpleCallback<R> {
    R apply(@NonNull T t) throws Exception;
}
