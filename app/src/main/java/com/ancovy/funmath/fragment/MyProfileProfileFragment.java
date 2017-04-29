package com.ancovy.funmath.fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ancovy.funmath.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class MyProfileProfileFragment extends Fragment implements View.OnClickListener {

    private EditText email, username, fullname, school, grade, accType;
    private Button ok;
    private ImageButton edit;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_own_profile_profile, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid());

        email = (EditText)view.findViewById(R.id.email_edit_profile);
        username = (EditText)view.findViewById(R.id.username_edit_profile);
        fullname = (EditText)view.findViewById(R.id.fullname_edit_profile);
        school = (EditText)view.findViewById(R.id.school_edit_profile);
        grade = (EditText)view.findViewById(R.id.grade_edit_profile);
        accType = (EditText)view.findViewById(R.id.jenis_akun_edit_profile);

        edit = (ImageButton)view.findViewById(R.id.edit_button_profile);
        edit.setOnClickListener(this);

        ok = (Button)view.findViewById(R.id.ok_button_edit_profile);
        ok.setOnClickListener(this);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                email.setText(dataSnapshot.child("email").getValue().toString());
                username.setText(dataSnapshot.child("username").getValue().toString());
                fullname.setText(dataSnapshot.child("fullname").getValue().toString());
                school.setText(dataSnapshot.child("school").getValue().toString());
                grade.setText(dataSnapshot.child("grade").getValue().toString());
                accType.setText(dataSnapshot.child("accType").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_button_profile :

                email.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                username.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                fullname.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                school.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                grade.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

                email.setClickable(true);
                username.setClickable(true);
                fullname.setClickable(true);
                school.setClickable(true);
                grade.setClickable(true);

                email.setCursorVisible(true);
                username.setCursorVisible(true);
                fullname.setCursorVisible(true);
                school.setCursorVisible(true);
                grade.setCursorVisible(true);

                email.setFocusable(true);
                username.setFocusable(true);
                fullname.setFocusable(true);
                school.setFocusable(true);
                grade.setFocusable(true);

                email.setFocusableInTouchMode(true);
                username.setFocusableInTouchMode(true);
                fullname.setFocusableInTouchMode(true);
                school.setFocusableInTouchMode(true);
                grade.setFocusableInTouchMode(true);

                ok.setVisibility(View.VISIBLE);
                edit.setVisibility(View.INVISIBLE);

                break;

            case R.id.ok_button_edit_profile :
//                email.setBackgroundTintList(getResources().getColorStateList(R.color.transparent));
//                username.setBackgroundTintList(getResources().getColorStateList(R.color.transparent));
//                fullname.setBackgroundTintList(getResources().getColorStateList(R.color.transparent));
//                school.setBackgroundTintList(getResources().getColorStateList(R.color.transparent));
//                grade.setBackgroundTintList(getResources().getColorStateList(R.color.transparent));
//
//                email.setClickable(false);
//                username.setClickable(false);
//                fullname.setClickable(false);
//                school.setClickable(false);
//                grade.setClickable(false);
//
//                email.setCursorVisible(false);
//                username.setCursorVisible(false);
//                fullname.setCursorVisible(false);
//                school.setCursorVisible(false);
//                grade.setCursorVisible(false);
//
//                email.setFocusable(false);
//                username.setFocusable(false);
//                fullname.setFocusable(false);
//                school.setFocusable(false);
//                grade.setFocusable(false);
//
//                email.setFocusableInTouchMode(false);
//                username.setFocusableInTouchMode(false);
//                fullname.setFocusableInTouchMode(false);
//                school.setFocusableInTouchMode(false);
//                grade.setFocusableInTouchMode(false);
//
//                ok.setVisibility(View.INVISIBLE);
//                edit.setVisibility(View.VISIBLE);

                databaseReference.child("email").setValue(email.getText().toString());
                databaseReference.child("username").setValue(username.getText().toString());
                databaseReference.child("fullname").setValue(fullname.getText().toString());
                databaseReference.child("school").setValue(school.getText().toString());
                databaseReference.child("grade").setValue(grade.getText().toString());

                Toast.makeText(getActivity(), "Perubahan telah disimpan", Toast.LENGTH_SHORT).show();

                getFragmentManager().beginTransaction().replace(R.id.profile_detail_container, new MyProfileProfileFragment()).commit();
        }
    }
}
