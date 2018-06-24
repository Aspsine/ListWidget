package com.frank.example.listwidget;

import android.view.View;
import android.widget.TextView;

import com.frank.listwidget.adapter.ItemDataViewHolder;
import com.frank.listwidget.adapter.ItemData;

import java.util.List;
import java.util.Locale;


/**
 * Created by zhangfan10 on 2017/10/2.
 */

public class DefaultViewHolder extends ItemDataViewHolder {
    public DefaultViewHolder(View itemView) {
        super(itemView);
    }


    @Override
    protected void bindData(int position, List<ItemData> items) {
        ((TextView) getItemView()).setText(String.format(Locale.getDefault(),"%d %s:text:%s", position, this.getClass().getSimpleName(), items.get(position).get()));
    }
}
