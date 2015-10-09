package com.algo.ygntrain.provider;

import android.content.Context;

import com.algo.ygntrain.Model.StationItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by Admin on 10/9/15.
 */
public class StationItem_RealmHelper {

    private static StationItem_RealmHelper realmHelper;
    private Context mContext;
    private Realm mRealm;

    public StationItem_RealmHelper(Context _context) {
        mContext = _context;
        mRealm = Realm.getInstance(_context);
    }

    public static synchronized StationItem_RealmHelper getInstance(Context _context) {
        if (realmHelper == null) {
            realmHelper = new StationItem_RealmHelper(_context);
        }
        return realmHelper;
    }

    /**
     * It will update when the item was exist
     * else it will insert stationItem when
     *
     * @param stationItem
     */
    public void upsertStation(StationItem stationItem) {
        try {
            mRealm.beginTransaction();

            stationItem.set_id(getNextKey());
            mRealm.copyToRealmOrUpdate(stationItem);
            mRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    /**
     * delete stationitem
     *
     * @param stationItem
     */
    void deleteStationItem(StationItem stationItem) {
        try {
            mRealm.beginTransaction();

            StationItem item = mRealm.where(StationItem.class).equalTo("_id", stationItem.get_id()).findFirst();
            item.removeFromRealm();
            mRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public void deleteAllStationList() {

        try {
            mRealm.beginTransaction();

            RealmResults<StationItem> results = mRealm.where(StationItem.class).findAll();
            results.removeAll(results);
            mRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public List<StationItem> getStationList() {
        List stationList = new ArrayList();
        try {
            RealmResults<StationItem> results = mRealm.where(StationItem.class).findAll();

            stationList = results;


        } catch (RealmException re) {
            re.printStackTrace();
        }
        return stationList;
    }

    public StationItem getStationById(String _id) {
        StationItem result = new StationItem();

        try {
            result = mRealm.where(StationItem.class).equalTo("_id", _id).findFirst();
        } catch (RealmException re) {
            re.printStackTrace();
        }

        return result;
    }

    public int getNextKey() {
        return (int) (mRealm.where(StationItem.class).maximumInt("_id") + 1);
    }

}
