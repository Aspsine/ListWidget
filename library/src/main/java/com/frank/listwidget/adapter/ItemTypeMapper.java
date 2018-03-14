package com.frank.listwidget.adapter;

import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.TypeMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ItemTypeMapper implements TypeMapper<List<ItemData>, AdapterDataSource<List<ItemData>>> {

    private List<Integer> mTypeList = new LinkedList<>();

    @Override
    public void registerType(int type) {
        if (!mTypeList.contains(type)) {
            mTypeList.add(type);
        }
    }

    @Override
    public int mapping(AdapterDataSource<List<ItemData>> dataSource, int position) {
        final List<ItemData> items = dataSource.getAdapterData();
        final ItemData item = items.get(position);
        return item.getType();
    }

    @Override
    public int getTypeCount() {
        return mTypeList.size();
    }
}
