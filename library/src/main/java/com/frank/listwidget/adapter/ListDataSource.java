package com.frank.listwidget.adapter;

import com.frank.listwidget.core.AdapterDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ListDataSource<T> extends AdapterDataSource<List<T>> {

    private final List<T> mList = new ArrayList<>();

    @Override
    public List<T> getAdapterData() {
        return mList;
    }
}
