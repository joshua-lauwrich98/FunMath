package com.ancovy.funmath.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.Main5Activity;
import com.ancovy.funmath.other.CustomAlertDialogProfileAddClass;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class ClassFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container,false);

        Button a = (Button) view.findViewById(R.id.kelas1_class);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Main5Activity.class));
            }
        });

        ImageButton b = (ImageButton) view.findViewById(R.id.add_kelas_class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAlertDialogProfileAddClass dialog = new CustomAlertDialogProfileAddClass();
                dialog.showDialog(getActivity());
            }
        });

        return view;
    }
}
