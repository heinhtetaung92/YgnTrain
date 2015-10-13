package com.algo.ygntrain.Model;

import io.realm.RealmObject;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class TrainItem  extends RealmObject {

    private int _id;
    private String _train_name;
    private String _train_price;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_train_name() {
        return _train_name;
    }

    public void set_train_name(String _train_name) {
        this._train_name = _train_name;
    }

    public String get_train_price() {
        return _train_price;
    }

    public void set_train_price(String _train_price) {
        this._train_price = _train_price;
    }
}
