package com.frank.listwidget.adapter;

import android.view.View;

import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public abstract class BaseItemViewHolder implements ItemViewHolder {

    private View mItemView;

    private int mPosition = -1;

    public BaseItemViewHolder(View itemView) {
        this.mItemView = itemView;
    }

    @Override
    public final View getItemView() {
        return mItemView;
    }

    @Override
    public final int getPosition() {
        if (mPosition == -1) {
            throw new IllegalStateException("You shouldn't call getPosition before onBindViewHolder");
        }
        return mPosition;
    }

    @Override
    public final void bindPosition(int position) {
        this.mPosition = position;
    }
}
