package com.algo.ygntrain.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.algo.ygntrain.Adapter.MyRecyclerAdapter;
import com.algo.ygntrain.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 10/9/15.
 */
public class StationListActivity extends ActionBarActivity implements View.OnClickListener {
    private Button btn_showmap;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<String> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        btn_showmap = (Button)findViewById(R.id.btn_showmap);
        btn_showmap.setOnClickListener(this);
        mRecyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        datalist = new ArrayList<>();
        datalist.add("one");
        datalist.add("two");
        datalist.add("three");
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerAdapter(datalist);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(StationListActivity.this,MainActivity.class));
        finish();
    }

}
