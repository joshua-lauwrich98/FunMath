package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 5/8/2017.
 */

public class ForumAddFragment extends Fragment {
//    private RecyclerView mRecyclerView;
//    private DatabaseReference databaseReference;
//    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_add, container, false);

//        mRecyclerView = (RecyclerView)view.findViewById(R.id.forum_recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        firebaseAuth = FirebaseAuth.getInstance();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("ForumList");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

//        FirebaseRecyclerAdapter<Forum, ForumViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Forum, ForumViewHolder>(
//                Forum.class,
//                R.layout.forum_list_card_view,
//                ForumViewHolder.class,
//                databaseReference
//        ) {
//            @Override
//            protected void populateViewHolder(ForumViewHolder viewHolder, final Forum model, int position) {
//
//                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//
//                viewHolder.setTitle(model.getTitle());
//                viewHolder.setAnswer(model.getAnswer());
//            }
//        };
//
//        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
