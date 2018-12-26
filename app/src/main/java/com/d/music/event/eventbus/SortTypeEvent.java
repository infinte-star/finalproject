package com.d.music.event.eventbus;


public class SortTypeEvent {
    public int type;
    public int orderType;

    public SortTypeEvent(int type, int orderType) {
        this.type = type;
        this.orderType = orderType;
    }
}
