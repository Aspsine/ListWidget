package com.frank.example.watch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.frank.example.irecyclerview.IRecyclerViewAdapter;
import com.frank.example.irecyclerview.LoadMoreFooterView;
import com.frank.example.listwidget.ListWidgetManager;
import com.frank.example.listwidget.R;
import com.frank.listwidget.adapter.ItemData;
import com.frank.listwidget.core.ListDataSource;
import com.frank.listwidget.adapter.listview.ListViewAdapter;
import com.frank.listwidget.adapter.recyclerview.RecyclerViewAdapter;

import java.util.Date;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class WatchVideoActivity extends AppCompatActivity {

    private ListView mListView;

    private RecyclerView mRecyclerView;

    private IRecyclerView mIRecyclerView;

    private LoadMoreFooterView mLoadMoreFooterView;

    private ListDataSource<ItemData> mListDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_watch_activity);

        initData();

        initView();

        update();
    }

    private void initData() {
        mListDataSource = new ListDataSource<>();
    }

    private void initView() {
        mListView = findViewById(R.id.listView);
        mListView.setAdapter(new ListViewAdapter<>(new WatchVideoAdapter(mListDataSource)));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter<>(new WatchVideoAdapter(mListDataSource)));

        mIRecyclerView = findViewById(R.id.iRecyclerView);
        mIRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mIRecyclerView.setIAdapter(new IRecyclerViewAdapter<>(new WatchVideoAdapter(mListDataSource)));
        mLoadMoreFooterView = (LoadMoreFooterView) mIRecyclerView.getLoadMoreFooterView();
        mIRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIRecyclerView.setRefreshing(false);
                        mListDataSource.getAdapterData().add(0, new InnerItemData("refresh:" + new Date().toString(), -1));
                        mListDataSource.notifyChanged();
                    }
                }, 200);

            }
        });

        mIRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (mLoadMoreFooterView.canLoadMore()) {
                    mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
                    mIRecyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
                            mListDataSource.getAdapterData().add(new InnerItemData("loadmore:" + new Date().toString(), -1));
                            mListDataSource.notifyChanged();
                        }
                    }, 200);
                }

            }
        });
    }

    private void update() {
        for (int i = 0; i < 20; i++) {
            ItemData itemData = new InnerItemData("data:" + i, i % ListWidgetManager.getInstance().getTypeMapper().getTypeCount());
            mListDataSource.getAdapterData().add(itemData);
        }
        mListDataSource.notifyChanged();
    }

    class InnerItemData implements ItemData {

        private String s;

        private int type;

        public InnerItemData(String s, int type) {
            this.s = s;
            this.type = type;
        }

        @Override
        public Object get() {
            return s;
        }

        @Override
        public int getType() {
            return type;
        }

        @Override
        public String toString() {
            return "InnerItemData{" +
                    "s='" + s + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
