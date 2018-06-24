package com.frank.example.listwidget;


import com.frank.listwidget.adapter.ItemTypeMapper;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.adapter.ItemData;
import com.frank.listwidget.core.TypeMapper;
import com.frank.listwidget.core.ViewHolderFactory;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ListWidgetManager {

    private final ViewHolderFactory<List<ItemData>, AdapterDataSource<List<ItemData>>> mViewHolderFactory;

    private final TypeMapper<List<ItemData>, AdapterDataSource<List<ItemData>>> mTypeMapper;

    private volatile static ListWidgetManager sInstance;

    public static ListWidgetManager getInstance() {
        if (sInstance == null) {
            synchronized (ListWidgetManager.class) {
                if (sInstance == null) {
                    sInstance = new ListWidgetManager();
                }
            }
        }
        return sInstance;
    }

    private ListWidgetManager() {
        mViewHolderFactory = new ItemViewHolderFactory();
        mTypeMapper = new ItemTypeMapper();

        init();
    }

    public void init() {
        registerTypes();
    }

    private void registerTypes() {
        mTypeMapper.registerType(ItemTypeConstants.TYPE_DEFAULT);
        mTypeMapper.registerType(ItemTypeConstants.TYPE_WATCH_INTERACTIVE);
        mTypeMapper.registerType(ItemTypeConstants.TYPE_WATCH_PLAY_LIST_TITLE);
        mTypeMapper.registerType(ItemTypeConstants.TYPE_WATCH_PLAY_LIST_ITEM);
        mTypeMapper.registerType(ItemTypeConstants.TYPE_WATCH_COMMENT_HEADER);
        mTypeMapper.registerType(ItemTypeConstants.TYPE_WATCH_COMMENT_ITEM);
    }

    public ViewHolderFactory<List<ItemData>, AdapterDataSource<List<ItemData>>> getItemViewHolderFactory() {
        return mViewHolderFactory;
    }

    public TypeMapper<List<ItemData>, AdapterDataSource<List<ItemData>>> getTypeMapper() {
        return mTypeMapper;
    }
}
