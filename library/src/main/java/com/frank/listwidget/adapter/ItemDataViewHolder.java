package com.frank.listwidget.adapter;

import android.view.View;

import com.frank.listwidget.core.AbsItemViewHolder;
import com.frank.listwidget.core.AdapterDataSource;

import java.util.List;

/**
 * Created by frank on 2018/6/25.
 */

public class ItemDataViewHolder extends AbsItemViewHolder<List<ItemData>> {
    public ItemDataViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(int position, AdapterDataSource<List<ItemData>> adapterDataSource) {
        bindData(position, adapterDataSource.getAdapterData());
    }

    protected void bindData(int position, List<ItemData> items) {
    }
}
