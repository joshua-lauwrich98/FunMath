package com.ancovy.funmath.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity2;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DarKnight98 on 4/12/2017.
 */

public class SignUpFragmentNext extends Fragment implements View.OnClickListener {

    private EditText teacher, student;
    private TextView notes;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseDatabase;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up_next, container, false);

        notes = (TextView)view.findViewById(R.id.notes_textview_signup_next);
        notes.setText("* Tolong isikan data dengan benar! Informasi ini digunakan untuk menentukan dan mengatur fitur-fitur pada aplikasi ini.");

        Button studentTpye = (Button)view.findViewById(R.id.student_type_button);
        Button teacherType = (Button)view.findViewById(R.id.teacher_type_button);
        Button signUp = (Button)view.findViewById(R.id.signup_button);
        Button alreadyHaveAcc = (Button)view.findViewById(R.id.alreadyHaveAnAccount_button_next);

        studentTpye.setOnClickListener(this);
        teacherType.setOnClickListener(this);
        signUp.setOnClickListener(this);
        alreadyHaveAcc.setOnClickListener(this);

        teacher = (EditText)view.findViewById(R.id.teacher_background_edit_text);
        student = (EditText)view.findViewById(R.id.student_background_edit_text);

        getChildFragmentManager().beginTransaction().replace(R.id.account_type_container, new StudentTypeAccountFragment()).commit();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("User");

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alreadyHaveAnAccount_button_next :
                changeFragToLogin();
                break;

            case R.id.signup_button :
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Login ...");
                SharedPreferences sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                final String fullname = sp.getString("fullname", "");
                final String email = sp.getString("email", "");
                final String password = sp.getString("password", "");
                final String username = sp.getString("username", "");
                final String accType = sp.getString("acc_type", "");
                final String code = sp.getString("school_code", "");
                final String school = sp.getString("school_type", "");
                final String grade = sp.getString("grade_type", "");

                if (accType.equals("teacher") && code.isEmpty()) {
                    Toast.makeText(getActivity(), "Tolong isikan kode sekolah anda atau tekan tombol 'ok'!", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            progressDialog.show();
                            firebaseDatabase = firebaseDatabase.child(firebaseAuth.getCurrentUser().getUid());
                            firebaseDatabase.child("email").setValue(email);
                            firebaseDatabase.child("password").setValue(password);
                            firebaseDatabase.child("fullname").setValue(fullname);
                            firebaseDatabase.child("username").setValue(username);
                            firebaseDatabase.child("accType").setValue(accType);
                            if (accType.equals("student")) {
                                firebaseDatabase.child("school").setValue(school);
                                firebaseDatabase.child("grade").setValue(grade);
                            } else {
                                firebaseDatabase.child("code").setValue(code);
                            }

                            startActivity(new Intent(getActivity(), MainActivity2.class));
                            getActivity().finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
                }
//                progressDialog.show();
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                progressDialog.dismiss();
//                startActivity(new Intent(getActivity(), MainActivity2.class));
//                getActivity().finish();
                break;

            case R.id.teacher_type_button :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    teacher.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    student.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                    changeContentSharedPref("acc_type", "teacher");
                } else {
                    Toast.makeText(getActivity(), "Your Android version not meet minimum requirements!", Toast.LENGTH_LONG).show();
                }
                getChildFragmentManager().beginTransaction().replace(R.id.account_type_container, new TeacherTypeAccountFragment()).commit();
                break;

            case R.id.student_type_button :
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    student.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                    teacher.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
                    changeContentSharedPref("acc_type", "student");
                } else {
                    Toast.makeText(getActivity(), "Your Android version not meet minimum requirements!", Toast.LENGTH_LONG).show();
                }
                getChildFragmentManager().beginTransaction().replace(R.id.account_type_container, new StudentTypeAccountFragment()).commit();
                break;
        }
    }

    private void changeFragToLogin () {
        FragmentManager fm = getFragmentManager(); // or 'getSupportFragmentManager();'
        int count = fm.getBackStackEntryCount();
        for(int i = 0; i < count-1; ++i) {
            fm.popBackStack();
        }
        getFragmentManager().beginTransaction().replace(R.id.login_container, new LoginFragment()).commit();
    }

    private void changeContentSharedPref (String key, String content) {
        SharedPreferences.Editor sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
        sp.putString(key, content);
        sp.apply();
    }
}
