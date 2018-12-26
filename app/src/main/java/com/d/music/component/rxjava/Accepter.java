package com.d.music.component.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Accepter
 */
public abstract class Accepter<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
