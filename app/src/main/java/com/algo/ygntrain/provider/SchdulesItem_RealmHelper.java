package com.algo.ygntrain.provider;

import android.content.Context;

import com.algo.ygntrain.Model.SchdulesItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class SchdulesItem_RealmHelper {
    private static SchdulesItem_RealmHelper realmHelper;
    private Context sContext;
    private Realm sRealm;

    public SchdulesItem_RealmHelper(Context _context) {
        sContext = _context;
        sRealm = Realm.getInstance(_context);
    }

    public static synchronized SchdulesItem_RealmHelper getInstance(Context _context) {
        if (realmHelper == null) {
            realmHelper = new SchdulesItem_RealmHelper(_context);
        }
        return realmHelper;
    }

    /**
     * It will update when the item was exist
     * else it will insert stationItem when
     *
     * @param schdulesItem
     */
    public void upsertSchdules(SchdulesItem schdulesItem) {
        try {
            sRealm.beginTransaction();

            schdulesItem.set_id(getNextKey());
            sRealm.copyToRealmOrUpdate(schdulesItem);
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    /**
     * delete stationitem
     *
     * @param schdulesItem
     */
    void deleteTrainItem(SchdulesItem schdulesItem) {
        try {
            sRealm.beginTransaction();

            SchdulesItem item = sRealm.where(SchdulesItem.class).equalTo("_id", schdulesItem.get_id()).findFirst();
            item.removeFromRealm();
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public void deleteAllSchdulesList() {

        try {
            sRealm.beginTransaction();
            RealmResults<SchdulesItem> results = sRealm.where(SchdulesItem.class).findAll();
            results.removeAll(results);
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public List<SchdulesItem> getSchdulesItemList() {
        List schduleslist = new ArrayList();
        try {
            RealmResults<SchdulesItem> results = sRealm.where(SchdulesItem.class).findAll();
            schduleslist = results;

        } catch (RealmException re) {
            re.printStackTrace();
        }
        return schduleslist;
    }

    public SchdulesItem getSchdulesById(String _id) {
        SchdulesItem result = new SchdulesItem();

        try {
            result = sRealm.where(SchdulesItem.class).equalTo("_id", _id).findFirst();
        } catch (RealmException re) {
            re.printStackTrace();
        }

        return result;
    }

    public int getNextKey() {
        return (int) (sRealm.where(SchdulesItem.class).maximumInt("_id") + 1);
    }
}
