package com.d.lib.rxnet.func;

import com.d.lib.rxnet.callback.AsyncCallback;
import com.d.lib.rxnet.utils.Util;

import io.reactivex.functions.Function;

/**
 * Map with AsyncCallback
 */
public class MapFunc<T, R> implements Function<T, R> {
    private AsyncCallback<T, R> mCallback;

    public MapFunc(AsyncCallback<T, R> callback) {
        this.mCallback = callback;
    }

    @Override
    public R apply(T responseBody) throws Exception {
        Util.printThread("RxNet_theard callback apply");
        return mCallback.apply(responseBody);
    }
}
