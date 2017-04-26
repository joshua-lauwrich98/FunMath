package com.ancovy.funmath.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 4/15/2017.
 */

public class TeacherTypeAccountFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
    private EditText schoolCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_type_account, container, false);

        schoolCode = (EditText)view.findViewById(R.id.school_code_input);
        schoolCode.setOnFocusChangeListener(this);

        Button schoolCodeQuestion = (Button) view.findViewById(R.id.school_code_question);
        schoolCodeQuestion.setOnClickListener(this);

        Button schoolOk = (Button)view.findViewById(R.id.ok_button_teacher_type);
        schoolOk.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.school_code_question :
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

                dialog.setTitle( "Apa itu kode sekolah?" )
                        .setMessage("Kode sekolah adalah kode unik dari tiap sekolah untuk membuktikan " +
                                "anda adalah seorang guru. Silahkan tanyakan kepala sekolah anda untuk " +
                                "mendapatkan kode sekolah atau daftarkan sekolah anda ke email kami support_fun_math@gmail.com")

//  .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//      public void onClick(DialogInterface dialoginterface, int i) {
//          dialoginterface.cancel();
//          }})
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i) {
                            }
                        }).show();
                break;
            case R.id.ok_button_teacher_type :
                SharedPreferences.Editor sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
                sp.putString("school_code", schoolCode.getText().toString());
                sp.apply();
                Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        String code = schoolCode.getText().toString();
        if (view.getId() == R.id.school_code_input) {
            if (!b) {
                SharedPreferences.Editor sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
                sp.putString("school_code", code);
                sp.apply();
                Toast.makeText(getActivity(), "SUCCESS", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
