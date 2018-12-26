package com.d.lib.xrv.itemtouchhelper;

import android.support.v7.widget.RecyclerView;

/**
 * Listener for manual initiation of a drag.
 */
public interface OnStartDragListener {

    /**
     * Called when a view is requesting a start of a drag.
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);

}
