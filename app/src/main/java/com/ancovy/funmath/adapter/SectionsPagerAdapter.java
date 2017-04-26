package com.ancovy.funmath.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ancovy.funmath.fragment.ClassFragment;
import com.ancovy.funmath.fragment.PersonalFragment;
import com.ancovy.funmath.fragment.PersonalFragmentRoot;
import com.ancovy.funmath.fragment.PlayFragment;
import com.ancovy.funmath.fragment.PlayFragmentRoot;
import com.ancovy.funmath.fragment.ProfileFragment;
import com.ancovy.funmath.fragment.ProfileFragmentRoot;

/**
 * Created by DarKnight98 on 4/23/2017.
 */

public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        switch (position) {
            case 0 :
                return new PersonalFragmentRoot();
            case 1 :
                return new PlayFragmentRoot();
            case 2 :
                return new ClassFragment();
            case 3 :
                return new ProfileFragmentRoot();
            default :
                return new PlayFragmentRoot();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Personal";
            case 1:
                return "Main";
            case 2:
                return "Kelas";
            case 3:
                return "Profil";
        }
        return null;
    }
}
