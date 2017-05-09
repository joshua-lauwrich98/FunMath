package com.ancovy.funmath.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ancovy.funmath.R;
import com.squareup.picasso.Picasso;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class ForumViewHolder extends RecyclerView.ViewHolder {

    public View mView;

    public ForumViewHolder(View itemView) {
        super(itemView);

        this.mView = itemView;
    }

    public void setTitle (String title) {
        TextView usernameTV = (TextView)mView.findViewById(R.id.forum_question_title);
        usernameTV.setText(title);
    }

    public void setAnswer (String answer) {
        TextView photo = (TextView) mView.findViewById(R.id.forum_answered_status);
        photo.setText(answer);
    }
}
