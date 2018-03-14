package com.frank.listwidget.core;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public abstract class AdapterDataSourceObserver {

    public void onChanged() {
    }

    public void onItemRangeChanged(int positionStart, int itemCount) {
    }

    public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
    }

    public void onItemRangeInserted(int positionStart, int itemCount) {
    }

    public void onItemRangeRemoved(int positionStart, int itemCount) {
    }

    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
    }
}
