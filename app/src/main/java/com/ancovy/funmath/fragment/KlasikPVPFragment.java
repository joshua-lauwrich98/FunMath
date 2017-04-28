package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity2;
import com.ancovy.funmath.other.CustomAlertDialogKlasikPVPFindOpponent;

import java.util.Random;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class KlasikPVPFragment extends Fragment implements View.OnClickListener{

    private Chronometer timer;
    private int randomNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_klasik_pvp, container, false);

        timer = (Chronometer)view.findViewById(R.id.chronometer_pvp_klasik);
        startTimer();

        Button cancel = (Button)view.findViewById(R.id.cancel_button_pvp_klasik);
        cancel.setOnClickListener(this);

        randomNum = new Random().nextInt(10) + 5;

        return view;
    }

    private void startTimer() {
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (Integer.parseInt(chronometer.getText().toString().substring(3,5)) == randomNum) {
                    timer.stop();
                    showDialog();
                }
            }
        });
        timer.start();
    }

    private void showDialog() {
        CustomAlertDialogKlasikPVPFindOpponent dialog = new CustomAlertDialogKlasikPVPFindOpponent();
        dialog.showDialog((MainActivity2)getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel_button_pvp_klasik :
                timer.stop();
                getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
                break;
        }
        timer.stop();
        getFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
    }
}
