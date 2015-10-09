package com.algo.ygntrain.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.algo.ygntrain.Model.StationItem;
import com.algo.ygntrain.R;

import java.util.List;

/**
 * Created by winthanhtike on 10/9/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<StationItem> data;

    public MyRecyclerAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list,viewGroup,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        viewHolder.tv_stationName.setText(data.get(i).get_name());
        viewHolder.tv_stationName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        viewHolder.tv_stationDistrict.setText(data.get(i).get_district());
    }


    public MyRecyclerAdapter(List<StationItem> mydata){
        data = mydata;

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_stationName, tv_stationDistrict;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_stationName = (TextView)itemView.findViewById(R.id.station_name);
            tv_stationDistrict = (TextView)itemView.findViewById(R.id.station_district);
        }
    }
}
