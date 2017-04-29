package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ancovy.funmath.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class TimeTrialWithFriendSoalPlayActi1Fragment extends Fragment implements View.OnClickListener {

    private Button pil1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_with_friend_time_trial_soal_play_acti1, container, false);

        pil1 = (Button)view.findViewById(R.id.pilihan_1_with_friend_time_trial_play1);
        Button pil2 = (Button)view.findViewById(R.id.pilihan_2_with_friend_time_trial_play1);
        Button pil3 = (Button)view.findViewById(R.id.pilihan_3_with_friend_time_trial_play1);
        Button pil4 = (Button)view.findViewById(R.id.pilihan_4_with_friend_time_trial_play1);

        pil1.setOnClickListener(this);
        pil2.setOnClickListener(this);
        pil3.setOnClickListener(this);
        pil4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pilihan_1_with_friend_time_trial_play1 :
                getFragmentManager().beginTransaction().replace(R.id.default_with_friend_time_trial_temp, new TimeTrialWithFriendSoalPlayActi2Fragment()).commit();
                break;
        }
    }
}
