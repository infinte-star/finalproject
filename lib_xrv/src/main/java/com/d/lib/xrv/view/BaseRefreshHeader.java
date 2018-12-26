package com.d.lib.xrv.view;


public interface BaseRefreshHeader {

    void onMove(float delta);

    boolean releaseAction();

    void refreshComplete();
}