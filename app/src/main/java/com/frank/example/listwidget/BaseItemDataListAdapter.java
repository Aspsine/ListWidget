package com.frank.example.listwidget;

import android.support.annotation.NonNull;

import com.frank.listwidget.adapter.ItemDataListAdapter;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.adapter.ItemData;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class BaseItemDataListAdapter extends ItemDataListAdapter {
    public BaseItemDataListAdapter(@NonNull AdapterDataSource<List<ItemData>> dataSource) {
        super(dataSource, ListWidgetManager.getInstance().getTypeMapper(), ListWidgetManager.getInstance().getItemViewHolderFactory());
    }
}
