package com.frank.example.listwidget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frank.example.watch.sub.comment.CommentHeaderViewHolder;
import com.frank.example.watch.sub.comment.CommentItemViewHolder;
import com.frank.example.watch.sub.interactive.InteractiveViewHolder;
import com.frank.example.watch.sub.playlist.PlayItemViewHolder;
import com.frank.example.watch.sub.playlist.PlayListTitleViewHolder;
import com.frank.listwidget.core.ItemViewHolder;
import com.frank.listwidget.core.ViewHolderFactory;

/**
 * Created by zhangfan10 on 2017/9/30.
 */

public class ItemViewHolderFactory implements ViewHolderFactory {

    @Override
    public ItemViewHolder createItemViewHolder(ViewGroup parent, int type) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (type) {

            case ItemTypeConstants.TYPE_WATCH_INTERACTIVE: {
                final View view = layoutInflater.inflate(R.layout.video_watch_interactive_layout, parent, false);
                return new InteractiveViewHolder(view);
            }

            case ItemTypeConstants.TYPE_WATCH_PLAY_LIST_TITLE: {
                final View view = layoutInflater.inflate(R.layout.video_watch_play_list_title_layout, parent, false);
                return new PlayListTitleViewHolder(view);
            }

            case ItemTypeConstants.TYPE_WATCH_PLAY_LIST_ITEM: {
                final View view = layoutInflater.inflate(R.layout.video_watch_play_list_item_layout, parent, false);
                return new PlayItemViewHolder(view);
            }

            case ItemTypeConstants.TYPE_WATCH_COMMENT_HEADER: {
                final View view = layoutInflater.inflate(R.layout.video_watch_comment_header, parent, false);
                return new CommentHeaderViewHolder(view);
            }

            case ItemTypeConstants.TYPE_WATCH_COMMENT_ITEM: {
                final View view = layoutInflater.inflate(R.layout.video_watch_comment_list_item, parent, false);
                return new CommentItemViewHolder(view);
            }

            default: {
                final View view = layoutInflater.inflate(R.layout.video_default_item_view,parent, false);
                return new DefaultViewHolder(view);
            }
        }
    }
}
