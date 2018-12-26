package com.d.lib.xrv.adapter;

/**
 * MultiItemTypeSupport for RecyclerView
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int viewType);

    int getItemViewType(int position, T t);
}
