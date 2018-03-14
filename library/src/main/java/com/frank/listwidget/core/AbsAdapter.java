package com.frank.listwidget.core;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public abstract class AbsAdapter<T, DataSource extends AdapterDataSource<T>> implements Adapter<T, DataSource> {

    @NonNull
    private final DataSource mDataSource;

    @NonNull
    private final ViewHolderFactory mViewHolderFactory;

    @NonNull
    private final TypeMapper<T, DataSource> mTypeMapper;

    public AbsAdapter(@NonNull DataSource dataSource, @NonNull TypeMapper<T, DataSource> typeMapper, @NonNull ViewHolderFactory viewHolderFactory) {
        this.mDataSource = dataSource;
        this.mTypeMapper = typeMapper;
        this.mViewHolderFactory = viewHolderFactory;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return mDataSource;
    }

    @Override
    public int getItemViewType(int position) {
        return mTypeMapper.mapping(getDataSource(), position);
    }

    @Override
    public int getViewTypeCount() {
        return mTypeMapper.getTypeCount();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mViewHolderFactory.createItemViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(position, getDataSource());
    }

    public T getAdapterData() {
        return getDataSource().getAdapterData();
    }
}
