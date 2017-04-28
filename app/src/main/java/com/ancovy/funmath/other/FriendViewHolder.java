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

public class FriendViewHolder extends RecyclerView.ViewHolder {

    private View mView;

    public FriendViewHolder(View itemView) {
        super(itemView);

        this.mView = itemView;
    }

    public void setUsername (String username) {
        TextView usernameTV = (TextView)mView.findViewById(R.id.user_username);
        usernameTV.setText(username);
    }

    public void setImage (Context context, String url) {
        ImageView photo = (ImageView)mView.findViewById(R.id.user_image);
        Picasso.with(context).load(url).into(photo);
    }

    public void setIcon (String status) {
        ImageView icon = (ImageView)mView.findViewById(R.id.user_status_icon);
        if (status.equals("online")) {
            icon.setImageResource(R.drawable.status_online);
        } else {
            icon.setImageResource(R.drawable.status_offline);
        }
    }

    public void setTime (String time) {
        TextView timeTV = (TextView)mView.findViewById(R.id.user_status);
        if (time.equals("0")) {
            timeTV.setText("Tersedia");
        } else {
            int waktu = Integer.parseInt(time)/60;
            if (waktu == 0) {
                timeTV.setText(time + " detik lalu");
            } else {
                timeTV.setText(waktu + " menit lalu");
            }
        }
    }
}
