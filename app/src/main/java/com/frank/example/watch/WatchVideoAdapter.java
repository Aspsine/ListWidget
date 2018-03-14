package com.frank.example.watch;

import android.support.annotation.NonNull;

import com.frank.example.listwidget.BaseItemDataListAdapter;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.adapter.ItemData;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class WatchVideoAdapter extends BaseItemDataListAdapter {

    public WatchVideoAdapter(@NonNull AdapterDataSource<List<ItemData>> dataSource) {
        super(dataSource);
    }
}
