package com.ancovy.funmath.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 3/15/2017.
 */

public class SignUpFragment extends Fragment implements View.OnClickListener {

    private EditText fullName, email, password, userName;
    private ImageButton visibility;
    private boolean isPasswordVisible;
    private TextView error;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        fullName = (EditText) view.findViewById(R.id.sign_up_full_name_input);
        email = (EditText) view.findViewById(R.id.sign_up_email_input);
        password = (EditText) view.findViewById(R.id.sign_up_password_input);
        userName = (EditText) view.findViewById(R.id.sign_up_username_input);

        Button next = (Button)view.findViewById(R.id.next_sign_up_button);
        Button alreadyHaveAcc = (Button)view.findViewById(R.id.alreadyHaveAnAccount_button);
        next.setOnClickListener(this);
        alreadyHaveAcc.setOnClickListener(this);

        error = (TextView)view.findViewById(R.id.error_textview_sign_up);

        visibility = (ImageButton)view.findViewById(R.id.hide_or_show_password_signup_input);
        visibility.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_sign_up_button :
                String fullNameText = fullName.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String userNameText = userName.getText().toString();

                if (TextUtils.isEmpty(fullNameText)) {
                    fullName.requestFocus();
                    error.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(emailText)) {
                    email.requestFocus();
                    error.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(passwordText)) {
                    password.requestFocus();
                    error.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(userNameText)) {
                    userName.requestFocus();
                    error.setVisibility(View.VISIBLE);
                } else {
                    error.setVisibility(View.INVISIBLE);
                    SharedPreferences.Editor sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit();
                    sp.putString("fullname", fullNameText);
                    sp.putString("email", emailText);
                    sp.putString("password", passwordText);
                    sp.putString("username", userNameText);
                    sp.apply();
                    changeFrageToNext();
                }
                break;

            case R.id.alreadyHaveAnAccount_button :
                changeFragToLogin();
                break;

            case R.id.hide_or_show_password_signup_input :
                //cursor position
                int cursorPosition = password.getSelectionStart();

                //toogle variable
                isPasswordVisible = !isPasswordVisible;

                //change image
                visibility.setImageDrawable(getResources().getDrawable(isPasswordVisible ? R.drawable.visibility_off_icon : R.drawable.visibility_icon));

                //apply input type
                password.setInputType(isPasswordVisible ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                //returns cursor pos
                password.setSelection(cursorPosition);
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

    private void changeFrageToNext () {
        getFragmentManager().beginTransaction().replace(R.id.login_container, new SignUpFragmentNext()).addToBackStack(null).commit();
    }

}
