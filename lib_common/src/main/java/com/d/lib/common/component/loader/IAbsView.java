package com.d.lib.common.component.loader;

import com.d.lib.common.component.mvp.MvpView;

import java.util.List;

/**
 * Auto-Loader - IView
 */
public interface IAbsView<T> extends MvpView {
    void getData();

    void setData(List<T> datas);

    void loadError();
}
