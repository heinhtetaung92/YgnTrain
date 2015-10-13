package com.algo.ygntrain.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.algo.ygntrain.Adapter.MyRecyclerAdapter;
import com.algo.ygntrain.Model.StationItem;
import com.algo.ygntrain.R;
import com.algo.ygntrain.provider.StationItem_RealmHelper;

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
    Toolbar toolbar;
    List<StationItem> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        btn_showmap = (Button)findViewById(R.id.btn_showmap);
        btn_showmap.setOnClickListener(this);
        mRecyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        datalist = new ArrayList<>();

        StationItem_RealmHelper stationHelper = StationItem_RealmHelper.getInstance(this);
        datalist = stationHelper.getStationList();

        if(datalist.size() <= 0) {
            addHardCodeDataToRealm();
            datalist = stationHelper.getStationList();
        }



        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerAdapter(this, datalist);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(StationListActivity.this, MainActivity.class));
    }


    public void addHardCodeDataToRealm(){

        StationItem_RealmHelper stationHelper = StationItem_RealmHelper.getInstance(this);

        //stationHelper.deleteAllStationList();

        stationHelper.upsertStation(new StationItem("KaMarYut", "KaMaYut"));
        stationHelper.upsertStation(new StationItem("HlalDan", "KaMayut"));
        stationHelper.upsertStation(new StationItem("ALoneLan", "Yangon"));
        stationHelper.upsertStation(new StationItem("PyayLan", "Dagon"));

        stationHelper.upsertStation(new StationItem("KaMarYut1", "KaMaYut1"));
        stationHelper.upsertStation(new StationItem("HlalDan1", "KaMayut1"));
        stationHelper.upsertStation(new StationItem("ALoneLan1", "Yangon1"));
        stationHelper.upsertStation(new StationItem("PyayLan1", "Dagon1"));
    }

}
