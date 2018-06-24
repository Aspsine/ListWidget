package com.frank.listwidget.core;

import android.view.View;

/**
 * Created by frank on 2018/6/24.
 */

public interface ItemViewHolder<T, DataSource extends AdapterDataSource<T>> {
    void bindData(int position, DataSource adapterDataSource);

    View getItemView();

    int getPosition();

    void bindPosition(int position);
}
