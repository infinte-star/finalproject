package com.d.lib.common.component.loader;

import android.content.Context;

import com.d.lib.common.component.mvp.MvpBasePresenter;

/**
 * Auto-Loader - Presenter
 */
public class AbsPresenter<M> extends MvpBasePresenter<IAbsView<M>> {
    public AbsPresenter(Context context) {
        super(context);
    }
}
