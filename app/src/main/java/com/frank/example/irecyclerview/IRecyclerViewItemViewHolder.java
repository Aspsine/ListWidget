package com.frank.example.irecyclerview;

import com.aspsine.irecyclerview.IViewHolder;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by frank on 2018/6/24.
 */

public class IRecyclerViewItemViewHolder<T, DataSource extends AdapterDataSource<T>> extends IViewHolder {

    private final ItemViewHolder<T, DataSource> mItemViewHolder;

    public IRecyclerViewItemViewHolder(ItemViewHolder<T, DataSource> itemViewHolder) {
        super(itemViewHolder.getItemView());
        mItemViewHolder = itemViewHolder;
    }

    public ItemViewHolder<T, DataSource> getItemViewHolder() {
        return mItemViewHolder;
    }
}
