package com.algo.ygntrain.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algo.ygntrain.Adapter.Yangon_Hlawkar_Adapter;
import com.algo.ygntrain.Model.SampleSchduleItem;
import com.algo.ygntrain.R;
import com.algo.ygntrain.provider.SampleSchduleItem_RealmHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class To_Yangon extends Fragment {
    private RecyclerView to_yangon_view;
    private RecyclerView.Adapter yangon_adapter;
    private RecyclerView.LayoutManager yangon_layoutmanager;
    List<SampleSchduleItem> datalist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.to_yangon,container,false);
        to_yangon_view = (RecyclerView)v.findViewById(R.id.to_yangon_view);
        to_yangon_view.setHasFixedSize(true);

        datalist = new ArrayList<>();

        SampleSchduleItem_RealmHelper stationHelper = SampleSchduleItem_RealmHelper.getInstance(getContext());
        datalist = stationHelper.getSampleSchdulesItemList();

        if(datalist.size() <= 0) {
            addHardCodeDataToRealm();
            datalist = stationHelper.getSampleSchdulesItemList();
        }

        yangon_layoutmanager =  new LinearLayoutManager(getContext());
        to_yangon_view.setLayoutManager(yangon_layoutmanager);

        yangon_adapter = new Yangon_Hlawkar_Adapter(datalist);
        to_yangon_view.setAdapter(yangon_adapter);

        return v;
    }

    private void addHardCodeDataToRealm() {
        SampleSchduleItem_RealmHelper stationHelper = SampleSchduleItem_RealmHelper.getInstance(getContext());

        //stationHelper.deleteAllStationList();

        stationHelper.upsertSampleSchdules(new SampleSchduleItem("First Train", "300 kyats", "1:00pm"));
        stationHelper.upsertSampleSchdules(new SampleSchduleItem("Second Train", "200 kyats", "1:20pm"));
    }
}
