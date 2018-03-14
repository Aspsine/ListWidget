package com.frank.listwidget.core;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ListAdapter<T> extends AbsAdapter<List<T>, AdapterDataSource<List<T>>> {

    public ListAdapter(@NonNull AdapterDataSource<List<T>> dataSource, @NonNull TypeMapper<List<T>, AdapterDataSource<List<T>>> typeMapper, @NonNull ViewHolderFactory viewHolderFactory) {
        super(dataSource, typeMapper, viewHolderFactory);
    }

    @NonNull
    @Override
    public T getItem(int position) {
        return getAdapterData().get(position);
    }

    @Override
    public int getItemCount() {
        return getAdapterData().size();
    }
}
