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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class PlayFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);

        Button pvp = (Button)view.findViewById(R.id.pvp_button_play);
        Button pwf = (Button)view.findViewById(R.id.with_friend_button_play);
        Button leaderboard = (Button)view.findViewById(R.id.leaderboard_button_play);
        final Button newChallange = (Button)view.findViewById(R.id.new_challange_play_button);

        pvp.setOnClickListener(this);
        pwf.setOnClickListener(this);
        leaderboard.setOnClickListener(this);
        newChallange.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Command").child("challange");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("ya")) {
                    newChallange.setVisibility(View.VISIBLE);
                } else {
                    newChallange.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pvp_button_play :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
            case R.id.with_friend_button_play :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayWithFriendFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
            case R.id.leaderboard_button_play :
                getFragmentManager().beginTransaction().replace(R.id.play_container, new LeaderboardFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
            case R.id.new_challange_play_button :
                ChallangeTabbedDialog dialog = new ChallangeTabbedDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "");
        }
    }
}
