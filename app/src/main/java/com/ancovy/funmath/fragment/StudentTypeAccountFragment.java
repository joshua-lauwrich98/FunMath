package com.ancovy.funmath.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/12/2017.
 */

public class StudentTypeAccountFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner school, grade;
    private ArrayAdapter<CharSequence> schoolAdapter, sdAdapter, smpSmaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_type_account, container, false);

        school = (Spinner)view.findViewById(R.id.school_type_spinner);
        grade = (Spinner)view.findViewById(R.id.grade_spinner);

        schoolAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.school_array_acc_type, R.layout.spinner_item);
        sdAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.grade_array_acc_type_SD, R.layout.spinner_item);
        smpSmaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.grade_array_acc_type_SMP_SMA, R.layout.spinner_item);

        schoolAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        sdAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        smpSmaAdapter.setDropDownViewResource(R.layout.spinner_dropdown);

        school.setAdapter(schoolAdapter);
        school.setOnItemSelectedListener(this);
        grade.setAdapter(sdAdapter);

//        school.setSelection(0, true);
//        View v = school.getSelectedView();
//        ((TextView)v).setTextColor(Color.WHITE);
//
//        grade.setSelection(0, true);
//        v = grade.getSelectedView();
//        ((TextView)v).setTextColor(Color.WHITE);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = (String) adapterView.getSelectedItem();
//        ((TextView) view).setTextColor(Color.WHITE);
        switch (item) {
            case "1" :
                changeContentSharedPref("grade_type", "1");
                break;
            case "2" :
                changeContentSharedPref("grade_type", "2");
                break;
            case "3" :
                changeContentSharedPref("grade_type", "3");
                break;
            case "4" :
                changeContentSharedPref("grade_type", "4");
                break;
            case "5" :
                changeContentSharedPref("grade_type", "5");
                break;
            case "6" :
                changeContentSharedPref("grade_type", "6");
                break;
            case "SD" :
                grade.setAdapter(sdAdapter);
                changeContentSharedPref("school_type", "SD");
                break;
            case "SMP" :
                grade.setAdapter(smpSmaAdapter);
                changeContentSharedPref("school_type", "SMP");
                break;
            case "SMA" :
                grade.setAdapter(smpSmaAdapter);
                changeContentSharedPref("school_type", "SMA");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void changeContentSharedPref (String key, String content) {
        SharedPreferences.Editor sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
        sp.putString(key, content);
        sp.apply();
    }
}
