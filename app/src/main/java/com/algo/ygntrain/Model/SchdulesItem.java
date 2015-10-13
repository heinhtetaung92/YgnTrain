package com.algo.ygntrain.Model;

import io.realm.RealmObject;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class SchdulesItem extends RealmObject {

    private int _id;
    private int _time;
    private int _train_id;

    public int get_train_id() {
        return _train_id;
    }

    public void set_train_id(int _train_id) {
        this._train_id = _train_id;
    }

    public int get_station_id() {
        return _station_id;
    }

    public void set_station_id(int _station_id) {
        this._station_id = _station_id;
    }

    private int _station_id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_time() {
        return _time;
    }

    public void set_time(int _time) {
        this._time = _time;
    }

}
