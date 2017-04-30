package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ancovy.funmath.R;
import com.ancovy.funmath.adapter.NewChallangeAdapter;

/**
 * Created by Olakunmi on 21/01/2017.
 */

public class ChallangeTabbedDialog extends DialogFragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.custom_alert_dialog_new_challange,container,false);

        tabLayout = (TabLayout) rootview.findViewById(R.id.tab_layout_challange);
        viewPager = (ViewPager) rootview.findViewById(R.id.view_pager_challange);

        NewChallangeAdapter adapter = new NewChallangeAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return rootview;
    }
}