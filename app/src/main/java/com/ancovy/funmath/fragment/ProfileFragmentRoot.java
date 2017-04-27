package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/24/2017.
 */

public class ProfileFragmentRoot extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_root, container, false);

        getFragmentManager().beginTransaction().replace(R.id.profile_container, new ProfileFragment()).commit();

        return view;
    }
}
