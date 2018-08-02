package com.kurobarabenjamingeorge.mynavigationdrawer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.TabOneFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.TabThreeFragment;
import com.kurobarabenjamingeorge.mynavigationdrawer.fragments.TabTwoFragment;

/**
 * Created by George Benjamin on 8/2/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs){
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TabOneFragment();
            case 1:
                return new TabTwoFragment();
            case 2:
                return new TabThreeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
