package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ancovy.funmath.R;
import com.ancovy.funmath.adapter.LeaderboardAdapter;
import com.ancovy.funmath.datasource.LeaderboardeWeeklyDataSource;

/**
 * Created by DarKnight98 on 4/29/2017.
 */

public class LeaderboardWeeklyFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard_weekly, container, false);

        RecyclerView rv = (RecyclerView)view.findViewById(R.id.recycler_view_leaderboard_weekly);
        rv.setHasFixedSize(true);
        LeaderboardAdapter adapter = new LeaderboardAdapter(LeaderboardeWeeklyDataSource.getData(getActivity().getApplicationContext()));
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }
}
