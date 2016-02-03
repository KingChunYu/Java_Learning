package com.example.chunyu.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MyAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLineLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private Button mAddBtn;
    private Button mRemoveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] myData = {"Android", "ios", "jack", "tony", "window", "mac", "1234", "hehe", "495948", "tony", "window", "mac", "1234", "hehe", "495948", "tony", "window", "mac", "1234", "hehe", "495948"};
        ArrayList<String> mDataset = new ArrayList<>();
        for (String str:myData)
        {
            mDataset.add(str);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAddBtn = (Button)findViewById(R.id.btn1);
        mRemoveBtn = (Button)findViewById(R.id.btn2);
        mAddBtn.setOnClickListener(this);
        mRemoveBtn.setOnClickListener(this);


        //LineLayout样式
//        useLineLayout();

        //GridLayout样式
        useGridLayout();
        //StaggeredGridLayout
//        useStaggeredGridLayout();

        mAdapter = new MyAdapter(mDataset);
        mAdapter.setmOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void useLineLayout() {
        mLineLayoutManager = new LinearLayoutManager(this);
        mLineLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLineLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

    }

    private void useGridLayout() {
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mGridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void useStaggeredGridLayout() {
        StaggeredGridLayoutManager mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.btn1:
                mAdapter.addData(0);
                break;
            case R.id.btn2:
                mAdapter.removeData(0);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        mAdapter.removeData(position);
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}