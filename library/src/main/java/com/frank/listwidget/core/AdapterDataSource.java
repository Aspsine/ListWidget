package com.frank.listwidget.core;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public abstract class AdapterDataSource<T> {

    private AdapterDataSourceObservable<AdapterDataSourceObserver> mObservable = new AdapterDataSourceObservable<>();

    public void registerObserver(AdapterDataSourceObserver observer) {
        mObservable.registerObserver(observer);
    }

    public void unregisterObserver(AdapterDataSourceObserver observer) {
        mObservable.unregisterObserver(observer);
    }

    public void unregisterAll() {
        mObservable.unregisterAll();
    }

    public boolean hasObservers() {
        return mObservable.hasObservers();
    }

    public void notifyChanged() {
        mObservable.notifyChanged();
    }

    public void notifyItemRangeChanged(int positionStart, int itemCount) {
        mObservable.notifyItemRangeChanged(positionStart, itemCount);
    }

    public void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
        mObservable.notifyItemRangeChanged(positionStart, itemCount, payload);
    }

    public void notifyItemRangeInserted(int positionStart, int itemCount) {
        mObservable.notifyItemRangeInserted(positionStart, itemCount);
    }

    public void notifyItemRangeRemoved(int positionStart, int itemCount) {
        mObservable.notifyItemRangeRemoved(positionStart, itemCount);
    }

    public void notifyItemMoved(int fromPosition, int toPosition) {
        mObservable.notifyItemMoved(fromPosition, toPosition);
    }

    public abstract T getAdapterData();
}
