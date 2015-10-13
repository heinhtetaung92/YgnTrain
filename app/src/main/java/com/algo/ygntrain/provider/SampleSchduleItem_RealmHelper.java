package com.algo.ygntrain.provider;

import android.content.Context;

import com.algo.ygntrain.Model.SampleSchduleItem;
import com.algo.ygntrain.Model.SchdulesItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class SampleSchduleItem_RealmHelper {

    private static SampleSchduleItem_RealmHelper realmHelper;
    private Context sContext;
    private Realm sRealm;

    public SampleSchduleItem_RealmHelper(Context _context) {
        sContext = _context;
        sRealm = Realm.getInstance(_context);
    }

    public static synchronized SampleSchduleItem_RealmHelper getInstance(Context _context) {
        if (realmHelper == null) {
            realmHelper = new SampleSchduleItem_RealmHelper(_context);
        }
        return realmHelper;
    }

    /**
     * It will update when the item was exist
     * else it will insert stationItem when
     *
     * @param sampleSchduleItem
     */
    public void upsertSampleSchdules(SampleSchduleItem sampleSchduleItem) {
        try {
            sRealm.beginTransaction();

            sampleSchduleItem.set_id(getNextKey());
            sRealm.copyToRealmOrUpdate(sampleSchduleItem);
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    /**
     * delete stationitem
     *
     * @param sampleSchduleItem
     */
    void deleteSampleSchdulesItem(SampleSchduleItem sampleSchduleItem) {
        try {
            sRealm.beginTransaction();

            SampleSchduleItem item = sRealm.where(SampleSchduleItem.class).equalTo("_id", sampleSchduleItem.get_id()).findFirst();
            item.removeFromRealm();
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public void deleteAllSampleSchdulesList() {

        try {
            sRealm.beginTransaction();
            RealmResults<SampleSchduleItem> results = sRealm.where(SampleSchduleItem.class).findAll();
            results.removeAll(results);
            sRealm.commitTransaction();

        } catch (RealmException re) {
            re.printStackTrace();
        }
    }

    public List<SampleSchduleItem> getSampleSchdulesItemList() {
        List schduleslist = new ArrayList();
        try {
            RealmResults<SampleSchduleItem> results = sRealm.where(SampleSchduleItem.class).findAll();
            schduleslist = results;

        } catch (RealmException re) {
            re.printStackTrace();
        }
        return schduleslist;
    }

    public SampleSchduleItem getSchdulesById(String _id) {
        SampleSchduleItem result = new SampleSchduleItem();

        try {
            result = sRealm.where(SampleSchduleItem.class).equalTo("_id", _id).findFirst();
        } catch (RealmException re) {
            re.printStackTrace();
        }

        return result;
    }

    public int getNextKey() {
        return (int) (sRealm.where(SampleSchduleItem.class).maximumInt("_id") + 1);
    }

}
