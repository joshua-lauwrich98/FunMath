package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class PVPKlasikPlayActiDefaultTempFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private TextView timer, score;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pvp_klasik_play_acti_default_temp, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid()).child("poin");

        timer = (TextView)view.findViewById(R.id.time_remaining_pvp_klasik);
        score = (TextView)view.findViewById(R.id.poin_pvp_klasik);

        Button stop = (Button)view.findViewById(R.id.stopButton_pvp_klasik);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.play_activity_container, new ResultClassicFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                score.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long l) {
                String text = String.format(Locale.getDefault(), "00:%d:%d", l/1000, (l%1000)/100);
                timer.setText(text);
            }

            @Override
            public void onFinish() {
                getFragmentManager().beginTransaction().replace(R.id.play_activity_container, new ResultClassicFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            }
        }.start();

        getFragmentManager().beginTransaction().replace(R.id.default_pvp_klasik_temp, new PVPKlasikSoalPlayActi1Fragment()).commit();

        return view;
    }
}
