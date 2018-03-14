package com.frank.listwidget.core;

import android.view.View;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public interface ItemViewHolder {

    void bindData(int position, AdapterDataSource adapterDataSource);

    View getItemView();

    int getPosition();

    void bindPosition(int position);
}
