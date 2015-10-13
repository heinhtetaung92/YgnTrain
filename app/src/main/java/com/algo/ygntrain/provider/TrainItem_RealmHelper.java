package com.algo.ygntrain.provider;

import android.content.Context;

import com.algo.ygntrain.Model.StationItem;
import com.algo.ygntrain.Model.TrainItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class TrainItem_RealmHelper {

    private static TrainItem_RealmHelper realmHelper;
    private Context tContext;
    private Realm tRealm;

    public TrainItem_RealmHelper(Context _context) {
        tContext = _context;
        tRealm = Realm.getInstance(_context);
    }

    public static synchronized TrainItem_RealmHelper getInstance(Context _context) {
        if (realmHelper == null) {
            realmHelper = new TrainItem_RealmHelper(_context);
        }
        return realmHelper;
    }

    /**
     * It will update when the item was exist
     * else it will insert stationItem when
     *
     * @param trainItem
     */
    public void upsertTrain(TrainItem trainItem) {
        try {
            tRealm.beginTransaction();

            trainItem.set_id(getNextKey());
            tRealm.copyToRealmOrUpdate(trainItem);
            tRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    /**
     * delete stationitem
     *
     * @param trainItem
     */
    void deleteTrainItem(TrainItem trainItem) {
        try {
            tRealm.beginTransaction();

            TrainItem item = tRealm.where(TrainItem.class).equalTo("_id", trainItem.get_id()).findFirst();
            item.removeFromRealm();
            tRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public void deleteAllTrainList() {

        try {
            tRealm.beginTransaction();

            RealmResults<TrainItem> results = tRealm.where(TrainItem.class).findAll();
            results.removeAll(results);
            tRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public List<TrainItem> getTrainItemlist() {
        List trainlist = new ArrayList();
        try {
            RealmResults<TrainItem> results = tRealm.where(TrainItem.class).findAll();
            trainlist = results;

        } catch (RealmException re) {
            re.printStackTrace();
        }
        return trainlist;
    }

    public TrainItem getTrainById(String _id) {
        TrainItem result = new TrainItem();

        try {
            result = tRealm.where(TrainItem.class).equalTo("_id", _id).findFirst();
        } catch (RealmException re) {
            re.printStackTrace();
        }

        return result;
    }

    public int getNextKey() {
        return (int) (tRealm.where(TrainItem.class).maximumInt("_id") + 1);
    }

}
