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
    public ImageView icon;

    public FriendViewHolder(View itemView) {
        super(itemView);

        this.mView = itemView;
        this.icon = (ImageView)mView.findViewById(R.id.user_status_icon);
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
        if (status.equals("online")) {
            icon.setImageResource(R.drawable.status_online);
        } else if (status.equals("pending")) {
            icon.setImageResource(R.drawable.ic_add_box_black_24dp);
        } else {
            icon.setImageResource(R.drawable.status_offline);
        }
    }

    public void setTime (String time) {
        TextView timeTV = (TextView)mView.findViewById(R.id.user_status);
        if (time.equals("0")) {
            timeTV.setText("Tersedia");
        } else if (time.equals("-1")) {
            timeTV.setText("Permintaan Pertemanan");
        } else if (time.equals("-2")) {
            timeTV.setText("Permintaan Terkirim");
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
