package com.example.chunyu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private LinearLayoutManager mLineLayoutManager;
    private GridLayoutManager mGridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myDataset = {"Android", "ios", "jack", "tony", "window", "mac", "1234", "hehe", "495948", "tony", "window", "mac", "1234", "hehe", "495948", "tony", "window", "mac", "1234", "hehe", "495948"};
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //LineLayout样式
//        useLineLayout();

        //GridLayout样式
//        useGridLayout();
        //StaggeredGridLayout
        useStaggeredGridLayout();

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void useLineLayout() {
        mLineLayoutManager = new LinearLayoutManager(this);
        mLineLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLineLayoutManager);
    }

    private void useGridLayout() {
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

    }

    private void useStaggeredGridLayout() {
        StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
    }

}