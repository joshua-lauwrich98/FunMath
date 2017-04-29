package com.ancovy.funmath.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/29/2017.
 */

public class LeaderboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        ViewPager viewPager = (ViewPager)view.findViewById(R.id.view_pager_leaderboard);
        PagerAdapter pagerAdapter = new PagerAdapter(getFragmentManager(), getActivity());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tab_layout_leaderboard);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }

        return view;
    }

    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles [] = new String[] {"PVP", "Class Challange"};
        Context context;

        public PagerAdapter (FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 :
                    return new LeaderboardWeeklyFragment();
                case 1 :
                    return new LeaderboardWeeklyFragmentClass();
                default:
                    return new LeaderboardWeeklyFragment();
            }
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        public View getTabView (int position) {
            View tab = LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView)tab.findViewById(R.id.custom_text);
            tv.setText(tabTitles[position]);
            return tab;
        }
    }
}
