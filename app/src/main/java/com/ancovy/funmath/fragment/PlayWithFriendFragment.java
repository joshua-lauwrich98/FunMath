package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class PlayWithFriendFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_with_friends, container, false);

        Button klasik = (Button)view.findViewById(R.id.time_trial_button_with_friends);
        klasik.setOnClickListener(this);

        ImageButton back = (ImageButton)view.findViewById(R.id.back_button_play_with_friends);
        back.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.time_trial_button_with_friends :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new ChooseFriendFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
            case R.id.back_button_play_with_friends :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
        }
    }
}
