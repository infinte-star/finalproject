package com.d.lib.rxnet.callback;

/**
 * UploadCallback
 */
public interface ProgressCallback {
    void onStart();

    void onProgress(long currentLength, long totalLength);

    void onSuccess();

    void onError(Throwable e);

    void onCancel();
}
