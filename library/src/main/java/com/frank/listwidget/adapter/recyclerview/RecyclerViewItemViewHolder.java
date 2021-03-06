package com.frank.listwidget.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;

import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class RecyclerViewItemViewHolder<T, DataSource extends AdapterDataSource<T>> extends RecyclerView.ViewHolder {

    private final ItemViewHolder<T, DataSource> mItemViewHolder;

    public RecyclerViewItemViewHolder(ItemViewHolder<T, DataSource> itemViewHolder) {
        super(itemViewHolder.getItemView());
        mItemViewHolder = itemViewHolder;
    }

    public ItemViewHolder<T, DataSource> getItemViewHolder() {
        return mItemViewHolder;
    }
}
