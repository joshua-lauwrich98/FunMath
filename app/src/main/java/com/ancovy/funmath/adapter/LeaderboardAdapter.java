package com.ancovy.funmath.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ancovy.funmath.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DarKnight98 on 4/29/2017.
 */

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private HashMap<String, List<String>> data;

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        public TextView no, usernameText, score;
        public ImageView iconNaik;

        public LeaderboardViewHolder(View itemView) {
            super(itemView);

            no = (TextView)itemView.findViewById(R.id.peringkat_leaderboard);
            usernameText = (TextView)itemView.findViewById(R.id.username_leaderboard);
            score = (TextView)itemView.findViewById(R.id.score_leaderboard);
            iconNaik = (ImageView)itemView.findViewById(R.id.icon_peringkat_leaderboard);

        }
    }

    public LeaderboardAdapter (HashMap<String, List<String>> data) {
        this.data = data;
    }

    @Override
    public LeaderboardAdapter.LeaderboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, parent, false);
        LeaderboardViewHolder vh = new LeaderboardViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LeaderboardViewHolder holder, int position) {
        holder.no.setText(data.get("peringkat").get(position));
        holder.usernameText.setText(data.get("username").get(position));
        holder.score.setText(data.get("score").get(position));
        holder.iconNaik.setImageResource(data.get("icon").get(position).equals("naik") ? R.drawable.ic_keyboard_arrow_up_black_24dp : R.drawable.ic_keyboard_arrow_down_black_24dp);
    }

    @Override
    public int getItemCount() {
        return data.get("peringkat").size();
    }
}
