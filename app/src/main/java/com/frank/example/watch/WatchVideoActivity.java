package com.frank.example.watch;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.frank.example.listwidget.ListWidgetManager;
import com.frank.example.listwidget.R;
import com.frank.listwidget.adapter.AdapterHelper;
import com.frank.listwidget.adapter.ListDataSource;
import com.frank.listwidget.core.AdapterDataSource;
import com.frank.listwidget.adapter.ItemData;

import java.util.List;

/**
 * Created by zhangfan10 on 2017/9/29.
 */

public class WatchVideoActivity extends AppCompatActivity {

    private ListView mListView;

    private RecyclerView mRecyclerView;

    private AdapterDataSource<List<ItemData>> mAdapterDataSource;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_watch_activity);

        initData();

        initView();

        update();
    }

    private void initData() {
        mAdapterDataSource = new ListDataSource<>();
    }

    private void initView() {
        mListView = findViewById(R.id.listView);
        final WatchVideoAdapter adapter1 = new WatchVideoAdapter(mAdapterDataSource);
        AdapterHelper.setAdapter(mListView, adapter1);

        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        final WatchVideoAdapter adapter2 = new WatchVideoAdapter(mAdapterDataSource);
        AdapterHelper.setAdapter(mRecyclerView, adapter2);
    }

    private int i;

    private void update() {
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                ItemData itemData = new InnerItemData("position:" + i, i % ListWidgetManager.getInstance().getTypeMapper().getTypeCount());
//                Log.i("update", itemData.toString());
//                int size = mAdapterDataSource.getAdapterData().size();
//                mAdapterDataSource.getAdapterData().add(0, itemData);
//                if (size > 0) {
//                    mAdapterDataSource.notifyItemRangeInserted(0, 1);
//                } else {
//                    mAdapterDataSource.notifyChanged();
//                }
//                i++;
//                if (i < 100) {
//                    update();
//                }
//            }
//        }, 1000);

        for (int i =0; i< 100; i ++) {
            ItemData itemData = new InnerItemData("position:" + i, i % ListWidgetManager.getInstance().getTypeMapper().getTypeCount());
            mAdapterDataSource.getAdapterData().add(itemData);
        }
        mAdapterDataSource.notifyChanged();
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
