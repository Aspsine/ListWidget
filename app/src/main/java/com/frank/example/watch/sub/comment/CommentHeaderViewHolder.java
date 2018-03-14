package com.frank.example.watch.sub.comment;

import android.view.View;
import android.widget.TextView;

import com.frank.listwidget.adapter.BaseItemViewHolder;
import com.frank.listwidget.core.AdapterDataSource;


/**
 * Created by zhangfan10 on 2017/10/2.
 */

public class CommentHeaderViewHolder extends BaseItemViewHolder {
    public CommentHeaderViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(int position, AdapterDataSource adapterDataSource) {
        ((TextView) getItemView()).setText(this.getClass().getSimpleName() + ":" + position);
    }
}
