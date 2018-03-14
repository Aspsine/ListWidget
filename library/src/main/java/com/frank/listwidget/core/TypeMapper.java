package com.frank.listwidget.core;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public interface TypeMapper<T, DataSource extends AdapterDataSource<T>> {

    void registerType(int type);

    int mapping(DataSource dataSource, int position);

    int getTypeCount();
}
