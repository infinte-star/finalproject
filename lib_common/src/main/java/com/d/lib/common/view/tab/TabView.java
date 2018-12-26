package com.d.lib.common.view.tab;

/**
 * TabItem
 */
public interface TabView {
    void setText(String text);

    void setPadding(int padding);

    void setNumber(String text, int visibility);

    void notifyData(boolean focus);

    void onScroll(float factor);
}
