package com.algo.ygntrain.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.algo.ygntrain.Model.SampleSchduleItem;
import com.algo.ygntrain.R;

import java.util.List;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class Yangon_Hlawkar_Adapter extends RecyclerView.Adapter<Yangon_Hlawkar_Adapter.ViewHolder> implements View.OnClickListener {

    List<SampleSchduleItem> data;

    public Yangon_Hlawkar_Adapter(){}

    public Yangon_Hlawkar_Adapter(List<SampleSchduleItem> mdata) {
        data = mdata;
    }

    @Override
    public Yangon_Hlawkar_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_recycler_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Yangon_Hlawkar_Adapter.ViewHolder holder, int position) {

        String train_name = data.get(position).get_trainname();
        holder.tv_train_name.setText(data.get(position).get_trainname());
        holder.tv_train_price.setText(data.get(position).get_price());
        holder.tv_train_time.setText(String.valueOf(data.get(position).get_time()));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_train_name,tv_train_time,tv_train_price;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_train_name = (TextView)itemView.findViewById(R.id.tv_train_name);
            tv_train_price = (TextView)itemView.findViewById(R.id.tv_train_price);
            tv_train_time = (TextView)itemView.findViewById(R.id.tv_train_time);
        }
    }
}
