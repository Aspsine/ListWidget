package com.frank.listwidget.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.frank.listwidget.adapter.listview.ListViewAdapter;
import com.frank.listwidget.adapter.recyclerview.RecyclerViewAdapter;
import com.frank.listwidget.core.Adapter;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class AdapterHelper {

    public static void setAdapter(ListView listView, Adapter adapter) {
        final ListViewAdapter listViewAdapter = new ListViewAdapter(adapter);
        listView.setAdapter(listViewAdapter);
    }

    public static void setAdapter(RecyclerView recyclerView, Adapter adapter) {
        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(adapter);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
