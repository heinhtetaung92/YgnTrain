package com.algo.ygntrain.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.algo.ygntrain.R;

import java.util.List;

/**
 * Created by winthanhtike on 10/9/15.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<String> data;

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
        final String name = data.get(i);
        viewHolder.tv_stationName.setText(data.get(i));
        viewHolder.tv_stationName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(name);
            }
        });

        viewHolder.tv_stationDistrict.setText("Footer: " + data.get(i));
    }

    public void remove(String item){
        int position = data.indexOf(item);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void add(int position,String item){
        data.add(position, item);
        notifyItemInserted(position);
    }

    public MyRecyclerAdapter(List<String> mydata){
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
