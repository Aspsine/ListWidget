package com.frank.listwidget.core;

import android.database.Observable;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

class AdapterDataSourceObservable<Observer extends AdapterDataSourceObserver> extends Observable<Observer> {

    boolean hasObservers() {
        return !this.mObservers.isEmpty();
    }

    void notifyChanged() {
        for (int i = this.mObservers.size() - 1; i >= 0; --i) {
            this.mObservers.get(i).onChanged();
        }
    }

    void notifyItemRangeChanged(int positionStart, int itemCount) {
        this.notifyItemRangeChanged(positionStart, itemCount, (Object) null);
    }

    void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
        for (int i = this.mObservers.size() - 1; i >= 0; --i) {
            this.mObservers.get(i).onItemRangeChanged(positionStart, itemCount, payload);
        }
    }

    void notifyItemRangeInserted(int positionStart, int itemCount) {
        for (int i = this.mObservers.size() - 1; i >= 0; --i) {
            this.mObservers.get(i).onItemRangeInserted(positionStart, itemCount);
        }
    }

    void notifyItemRangeRemoved(int positionStart, int itemCount) {
        for (int i = this.mObservers.size() - 1; i >= 0; --i) {
            this.mObservers.get(i).onItemRangeRemoved(positionStart, itemCount);
        }
    }

    void notifyItemMoved(int fromPosition, int toPosition) {
        for (int i = this.mObservers.size() - 1; i >= 0; --i) {
            this.mObservers.get(i).onItemRangeMoved(fromPosition, toPosition, 1);
        }
    }
}
