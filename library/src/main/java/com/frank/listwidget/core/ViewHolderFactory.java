package com.frank.listwidget.core;

import android.view.ViewGroup;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public interface ViewHolderFactory<T, DataSource extends AdapterDataSource<T>> {

    ItemViewHolder<T, DataSource> createItemViewHolder(ViewGroup parent, int type);
}
