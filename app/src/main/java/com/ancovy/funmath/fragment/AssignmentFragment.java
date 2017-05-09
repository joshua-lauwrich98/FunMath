package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ancovy.funmath.R;
import com.ancovy.funmath.other.CustomAlertDialogProfileAddFriend;
import com.ancovy.funmath.other.Forum;
import com.ancovy.funmath.other.ForumViewHolder;
import com.ancovy.funmath.other.Friend;
import com.ancovy.funmath.other.FriendViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DarKnight98 on 5/8/2017.
 */

public class AssignmentFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assisgnment, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.forum_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("ForumList");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Forum, ForumViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Forum, ForumViewHolder>(
                Forum.class,
                R.layout.forum_list_card_view,
                ForumViewHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(ForumViewHolder viewHolder, final Forum model, int position) {

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().beginTransaction().replace(R.id.content_main5, new FragmentAction2start()).commit();
                    }
                });

                viewHolder.setTitle(model.getTitle());
                viewHolder.setAnswer(model.getAnswer());
            }
        };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
