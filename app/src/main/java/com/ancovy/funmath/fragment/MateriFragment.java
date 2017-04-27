package com.ancovy.funmath.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.Main3Activity;

/**
 * Created by DarKnight98 on 4/23/2017.
 */

public class MateriFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materi, container, false);

        Button sd = (Button)view.findViewById(R.id.sd_button_personal_materi);
        Button smp = (Button)view.findViewById(R.id.smp_button_personal_materi);
        Button sma = (Button)view.findViewById(R.id.sma_button_personal_materi);
        ImageButton back = (ImageButton)view.findViewById(R.id.back_button_materi);

        sd.setOnClickListener(this);
        smp.setOnClickListener(this);
        sma.setOnClickListener(this);
        back.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sd_button_personal_materi :
                Intent materi = new Intent(getActivity(), Main3Activity.class);
                materi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(materi);
                getActivity().finish();
                break;

            case R.id.back_button_materi :
                getFragmentManager().beginTransaction().replace(R.id.personal_container, new PersonalFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                break;
        }
    }
}
