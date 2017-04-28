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

public class PVPKlasikSoalPlayActi2Fragment extends Fragment implements View.OnClickListener {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private Button pil3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pvp_klasik_soal_play_acti2, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid()).child("poin");

        pil3 = (Button)view.findViewById(R.id.pilihan_3_pvp_klasik_play2);
        Button pil2 = (Button)view.findViewById(R.id.pilihan_2_pvp_klasik_play2);
        Button pil1 = (Button)view.findViewById(R.id.pilihan_1_pvp_klasik_play2);
        Button pil4 = (Button)view.findViewById(R.id.pilihan_4_pvp_klasik_play2);

        pil1.setOnClickListener(this);
        pil2.setOnClickListener(this);
        pil3.setOnClickListener(this);
        pil4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pilihan_3_pvp_klasik_play1 :
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        databaseReference.setValue(Integer.parseInt(dataSnapshot.getValue().toString()) + 10 + "");
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;
        }

        pil3.setBackgroundResource(R.drawable.status_ready);
    }
}
