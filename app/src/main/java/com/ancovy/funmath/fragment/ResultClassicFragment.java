package com.ancovy.funmath.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class ResultClassicFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private TextView score, username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_klasik, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid());

        score = (TextView)view.findViewById(R.id.score_result_klasik);
        username = (TextView)view.findViewById(R.id.my_username_result_clasic);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                score.setText(dataSnapshot.child("poin").getValue().toString());
                username.setText(dataSnapshot.child("username").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Button ok = (Button)view.findViewById(R.id.ok_button_result_klasik);
        ok.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(getActivity(), MainActivity2.class));
        getActivity().finish();
    }
}
