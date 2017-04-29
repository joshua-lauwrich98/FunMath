package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.ancovy.funmath.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class WithFriendTimeTrialPlayActiDefaultTempFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private Chronometer timer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_friend_time_trial_play_acti_default_temp, container, false);

        firebaseAuth = FirebaseAuth.getInstance();

        Button stop = (Button)view.findViewById(R.id.stopButton_with_friend_time_trial);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.play_activity_container, new ResultTimeTrialFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            }
        });

        timer = (Chronometer)view.findViewById(R.id.time_remaining_with_friend_time_trial);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        getFragmentManager().beginTransaction().replace(R.id.default_with_friend_time_trial_temp, new TimeTrialWithFriendSoalPlayActi1Fragment()).commit();

        return view;
    }
}
