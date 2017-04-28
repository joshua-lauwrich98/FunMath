package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class PVPKlasikSoalPlayActi1Fragment extends Fragment {

    private TextView score

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pvp_klasik_soal_play_acti1, container, false);

        Button pil1 = (Button)view.findViewById(R.id.pilihan_1_pvp_klasik_play1);
        Button pil2 = (Button)view.findViewById(R.id.pilihan_2_pvp_klasik_play1);
        Button pil3 = (Button)view.findViewById(R.id.pilihan_3_pvp_klasik_play1);
        Button pil4 = (Button)view.findViewById(R.id.pilihan_4_pvp_klasik_play1);



        return view;
    }
}
