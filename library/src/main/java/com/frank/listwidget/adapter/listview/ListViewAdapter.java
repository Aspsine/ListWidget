package com.frank.listwidget.adapter.listview;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.frank.listwidget.core.Adapter;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.core.AdapterDataSourceObserver;
import com.frank.listwidget.core.ItemViewHolder;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class ListViewAdapter<T, DataSource extends AdapterDataSource<T>> extends BaseAdapter {

    @NonNull
    private final Adapter<T, DataSource> mInnerAdapter;

    public ListViewAdapter(@NonNull Adapter<T, DataSource> adapter) {
        this.mInnerAdapter = adapter;
        this.mInnerAdapter.getDataSource().registerObserver(new NotifyAdapterObserver(this));
    }

    @Override
    public int getViewTypeCount() {
        return mInnerAdapter.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mInnerAdapter.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return mInnerAdapter.getItemCount();
    }

    @Override
    public Object getItem(int position) {
        return mInnerAdapter.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int viewType = mInnerAdapter.getItemViewType(position);
        final ItemViewHolder<T, DataSource> itemViewHolder;
        if (convertView == null) {
            itemViewHolder = mInnerAdapter.onCreateViewHolder(parent, viewType);
            convertView = itemViewHolder.getItemView();
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }
        itemViewHolder.bindPosition(position);
        mInnerAdapter.onBindViewHolder(itemViewHolder, position);
        return itemViewHolder.getItemView();
    }

    private static class NotifyAdapterObserver extends AdapterDataSourceObserver {

        @NonNull
        private final BaseAdapter mAdapter;

        private NotifyAdapterObserver(@NonNull BaseAdapter adapter) {
            mAdapter = adapter;
        }

        @Override
        public void onChanged() {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
