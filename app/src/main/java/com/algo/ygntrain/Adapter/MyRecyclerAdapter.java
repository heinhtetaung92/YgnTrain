package com.algo.ygntrain.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.algo.ygntrain.Model.StationItem;
import com.algo.ygntrain.R;
import com.algo.ygntrain.ui.activity.StationListActivity;
import com.algo.ygntrain.ui.activity.Yangon_Hlawgar;

import java.util.List;


/**
 * Created by winthanhtike on 10/9/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<StationItem> data;
    private Context mContext;

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
        viewHolder.mainView.setOnClickListener(this);

    }


    public MyRecyclerAdapter(Context context, List<StationItem> mydata){
        data = mydata;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        mContext.startActivity(new Intent(mContext, Yangon_Hlawgar.class));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_stationName, tv_stationDistrict;
        private View mainView;

        public ViewHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            tv_stationName = (TextView)itemView.findViewById(R.id.station_name);
            tv_stationDistrict = (TextView)itemView.findViewById(R.id.station_district);
        }
    }
}
