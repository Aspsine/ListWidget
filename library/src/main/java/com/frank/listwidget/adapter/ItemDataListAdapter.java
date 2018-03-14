package com.frank.listwidget.adapter;

import android.support.annotation.NonNull;

import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.ListAdapter;
import com.frank.listwidget.core.TypeMapper;
import com.frank.listwidget.core.ViewHolderFactory;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ItemDataListAdapter extends ListAdapter<ItemData> {

    public ItemDataListAdapter(@NonNull AdapterDataSource<List<ItemData>> dataSource, @NonNull TypeMapper<List<ItemData>, AdapterDataSource<List<ItemData>>> typeMapper, @NonNull ViewHolderFactory viewHolderFactory) {
        super(dataSource, typeMapper, viewHolderFactory);
    }
}
