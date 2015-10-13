package com.algo.ygntrain.Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class SampleSchduleItem extends RealmObject{

    private String _trainname;
    private String _time;
    @PrimaryKey
    private int _id;
    private String _price;

    public SampleSchduleItem(){}

    public SampleSchduleItem(String trainname,String price,String time){
        _trainname = trainname;
        _time = time;
        _price = price;
    }


    public String get_trainname() {
        return _trainname;
    }

    public void set_trainname(String _trainname) {
        this._trainname = _trainname;
    }

    public String get_time() {
        return _time;
    }

    public void set_time(String _time) {
        this._time = _time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }
}
