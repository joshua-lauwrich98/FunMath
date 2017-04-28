package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class PlayFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);

        Button pvp = (Button)view.findViewById(R.id.pvp_button_play);
        Button pwf = (Button)view.findViewById(R.id.with_friend_button_play);
        Button leaderboard = (Button)view.findViewById(R.id.leaderboard_button_play);

        pvp.setOnClickListener(this);
        pwf.setOnClickListener(this);
        leaderboard.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pvp_button_play :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;

        }
    }
}
