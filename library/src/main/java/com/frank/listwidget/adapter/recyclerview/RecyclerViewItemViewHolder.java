package com.frank.listwidget.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;

import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class RecyclerViewItemViewHolder extends RecyclerView.ViewHolder {

    private final ItemViewHolder mItemViewHolder;

    public RecyclerViewItemViewHolder(ItemViewHolder itemViewHolder) {
        super(itemViewHolder.getItemView());
        mItemViewHolder = itemViewHolder;
    }

    public ItemViewHolder getItemViewHolder(){
        return mItemViewHolder;
    }
}
