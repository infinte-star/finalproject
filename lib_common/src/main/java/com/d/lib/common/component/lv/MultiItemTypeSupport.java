package com.d.lib.common.component.lv;

/**
 * CommonHolder for ListView
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);

    int getViewTypeCount();

    int getItemViewType(int position, T t);
}
