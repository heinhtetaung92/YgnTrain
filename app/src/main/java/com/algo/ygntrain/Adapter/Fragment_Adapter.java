package com.algo.ygntrain.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.algo.ygntrain.ui.activity.To_Hlawkar;
import com.algo.ygntrain.ui.activity.To_Yangon;

/**
 * Created by winthanhtike on 10/12/15.
 */
public class Fragment_Adapter extends FragmentStatePagerAdapter {

    public Fragment_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = null;
        switch (position){
            case 0:
                fg = new To_Yangon();
                break;

            case 1:
                fg = new To_Hlawkar();
                break;
        }
        return fg;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String str = null;
        switch (position){
            case 0:
                str = "To Yangon";
                break;

            case 1:
                str = "To Hlawkar";
                break;

        }
        return str;
    }
}
