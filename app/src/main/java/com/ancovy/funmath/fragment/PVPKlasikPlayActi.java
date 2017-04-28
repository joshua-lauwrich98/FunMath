package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class PVPKlasikPlayActi extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pvp_klasik_play_acti, container, false);

        final TextView text = (TextView)view.findViewById(R.id.text_countdown_acti_play);

        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long l) {
                if (l > 1000) {
                    text.setText((l / 1000) - 1 + "");
                } else {
                    text.setTextSize(25);
                    text.setText("START");
                }
            }

            @Override
            public void onFinish() {
                getFragmentManager().beginTransaction().replace(R.id.play_activity_container, new PVPKlasikPlayActiDefaultTempFragment()).commit();
            }
        }.start();

        return view;
    }
}
