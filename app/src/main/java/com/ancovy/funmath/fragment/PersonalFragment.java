package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class PersonalFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, container, false);

        Button materi = (Button)view.findViewById(R.id.materi_button_personal);
        Button latihan = (Button)view.findViewById(R.id.latihan_button_personal);
        materi.setOnClickListener(this);
        latihan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.materi_button_personal :
                changeFragmentToMateri();
                break;
            case R.id.latihan_button_personal :
                changeFragmentToLatihan();
                break;
        }
    }

    private void changeFragmentToLatihan () {
        getFragmentManager().beginTransaction().replace(R.id.personal_container, new LatihanFragment()).addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }

    private void changeFragmentToMateri () {
        getFragmentManager().beginTransaction().replace(R.id.personal_container, new MateriFragment()).addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
    }
}
