package com.ancovy.funmath.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ancovy.funmath.fragment.FragmentFactory;
import com.ancovy.funmath.fragment.FragmentFactory2;

/**
 * Created by Olakunmi on 21/01/2017.
 */

public class NewChallangeAdapter extends FragmentPagerAdapter {

    private String[] data;

    public NewChallangeAdapter(FragmentManager fm) {
        super(fm);
        this.data = new String[] {"Kelas 1", "Kelas 2"};
    }

    //Needed for
    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentFactory();
        } else {
            return new FragmentFactory2();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}