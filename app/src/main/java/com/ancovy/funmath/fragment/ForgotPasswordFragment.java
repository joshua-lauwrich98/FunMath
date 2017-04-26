package com.ancovy.funmath.fragment;

import android.content.DialogInterface;
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
 * Created by DarKnight98 on 4/23/2017.
 */

public class ForgotPasswordFragment extends Fragment implements View.OnClickListener {

    private EditText email, username;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        Button confirm = (Button) view.findViewById(R.id.confirmation_button);
        confirm.setOnClickListener(this);

        email = (EditText)view.findViewById(R.id.forgot_password_email_input);
        username = (EditText)view.findViewById(R.id.forgot_password_username_input);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Bagian ini kosong!", Toast.LENGTH_SHORT).show();
            email.requestFocus();
        } else if (username.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Bagian ini kosong!", Toast.LENGTH_SHORT).show();
            username.requestFocus();
        } else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

            dialog.setTitle("Sukses!")
                    .setMessage("Sebuah email telah dikirim ke " + email.getText().toString() + ". Ikuti panduan pada email tersebut!")

//  .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//      public void onClick(DialogInterface dialoginterface, int i) {
//          dialoginterface.cancel();
//          }})
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            getFragmentManager().beginTransaction().replace(R.id.login_container, new LoginFragment()).commit();
                        }
                    }).show();
        }
    }
}
