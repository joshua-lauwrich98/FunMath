package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/23/2017.
 */

public class LatihanFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latihan,container,false);

        Button sd = (Button)view.findViewById(R.id.sd_button_personal_latihan);
        Button smp = (Button)view.findViewById(R.id.smp_button_personal_latihan);
        Button sma = (Button)view.findViewById(R.id.sma_button_personal_latihan);

        sd.setOnClickListener(this);
        smp.setOnClickListener(this);
        sma.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
