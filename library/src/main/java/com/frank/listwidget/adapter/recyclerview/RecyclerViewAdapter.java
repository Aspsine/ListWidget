package com.frank.listwidget.adapter.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.frank.listwidget.core.Adapter;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.AdapterDataSourceObserver;
import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class RecyclerViewAdapter<T, DataSource extends AdapterDataSource<T>> extends RecyclerView.Adapter<RecyclerViewItemViewHolder> {
    @NonNull
    private final Adapter<T, DataSource> mAdapter;

    public RecyclerViewAdapter(@NonNull Adapter<T, DataSource> adapter) {
        this.mAdapter = adapter;
        this.mAdapter.getDataSource().registerObserver(new NotifyAdapterObserver(this));
    }

    @Override
    public RecyclerViewItemViewHolder<T, DataSource> onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new RecyclerViewItemViewHolder<>(mAdapter.onCreateViewHolder(viewGroup, position));
    }

    @Override
    public void onBindViewHolder(RecyclerViewItemViewHolder viewHolder, int position) {
        final ItemViewHolder<T, DataSource> itemViewHolder = viewHolder.getItemViewHolder();
        itemViewHolder.bindPosition(position);
        mAdapter.onBindViewHolder(itemViewHolder, position);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    private static class NotifyAdapterObserver extends AdapterDataSourceObserver {

        @NonNull
        private final RecyclerView.Adapter<RecyclerViewItemViewHolder> mAdapter;

        private NotifyAdapterObserver(@NonNull RecyclerView.Adapter<RecyclerViewItemViewHolder> adapter) {
            mAdapter = adapter;
        }

        @Override
        public void onChanged() {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            mAdapter.notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            mAdapter.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            mAdapter.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            mAdapter.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            mAdapter.notifyItemMoved(fromPosition, toPosition);
        }
    }
}
