package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class PlayFragmentRoot extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_root, container, false);

        getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayFragment()).commit();

        return view;
    }
}
