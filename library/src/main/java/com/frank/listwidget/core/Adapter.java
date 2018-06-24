package com.frank.listwidget.core;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public interface Adapter<T, DataSource extends AdapterDataSource<T>> {

    @NonNull
    DataSource getDataSource();

    @NonNull
    ItemViewHolder<T, DataSource> onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull ItemViewHolder<T, DataSource> holder, int position);

    @NonNull
    Object getItem(int position);

    int getItemCount();

    int getItemViewType(int position);

    int getViewTypeCount();
}
