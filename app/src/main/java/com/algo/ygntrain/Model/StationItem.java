package com.algo.ygntrain.Model;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admin on 10/9/15.
 */
public class StationItem extends RealmObject{

    @PrimaryKey
    private int _id;
    private String _name;
    private String _district;

    public StationItem(){

    }
    
    public StationItem(String name, String district){
        _name = name;
        _district = district;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_district() {
        return _district;
    }

    public void set_district(String _district) {
        this._district = _district;
    }
}
