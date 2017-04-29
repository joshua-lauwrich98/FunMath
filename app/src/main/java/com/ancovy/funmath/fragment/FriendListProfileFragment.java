package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.ancovy.funmath.R;
import com.ancovy.funmath.other.CustomAlertDialogProfileAddFriend;
import com.ancovy.funmath.other.Friend;
import com.ancovy.funmath.other.FriendViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class FriendListProfileFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list_profile, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.friend_list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("FriendList");

        ImageButton addFriend = (ImageButton) view.findViewById(R.id.add_friend_button_profile);
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAlertDialogProfileAddFriend dialog = new CustomAlertDialogProfileAddFriend();
                dialog.showDialog(getActivity());
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Friend, FriendViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Friend, FriendViewHolder>(
                Friend.class,
                R.layout.friend_list_card_view,
                FriendViewHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(FriendViewHolder viewHolder, final Friend model, int position) {

                viewHolder.icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (model.getStatus().equals("pending")) {
                            databaseReference.child("000").child("status").setValue("online");
                            databaseReference.child("000").child("time").setValue("0");
                        }
                    }
                });

                viewHolder.setUsername(model.getUsername());
                viewHolder.setTime(model.getTime());
                viewHolder.setIcon(model.getStatus());
                viewHolder.setImage(getActivity().getApplicationContext(), model.getPhoto());
            }
        };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
