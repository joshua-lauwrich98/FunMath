package com.ancovy.funmath.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity2;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by DarKnight98 on 3/15/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    private ImageButton visibility;
    private EditText passInput, emailInput;
    private Button loginButton, forgotPassword, newAccount;
    private boolean isPasswordVisible;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        visibility = (ImageButton)view.findViewById(R.id.hide_or_show_password_login_input);
        visibility.setOnClickListener(this);

        passInput = (EditText)view.findViewById(R.id.login_password_input);
        emailInput = (EditText)view.findViewById(R.id.login_email_input);

        loginButton = (Button)view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        newAccount = (Button)view.findViewById(R.id.needANewAccount_button);
        newAccount.setOnClickListener(this);

        forgotPassword = (Button)view.findViewById(R.id.forgotPassword_button);
        forgotPassword.setOnClickListener(this);

        isPasswordVisible = false;

        firebaseAuth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hide_or_show_password_login_input :
                //cursor position
                int cursorPosition = passInput.getSelectionStart();

                //toogle variable
                isPasswordVisible = !isPasswordVisible;

                //change image
                visibility.setImageResource(isPasswordVisible ? R.drawable.visibility_off_icon : R.drawable.visibility_icon);

                //apply input type
                passInput.setInputType(isPasswordVisible ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                //returns cursor pos
                passInput.setSelection(cursorPosition);
                break;
            case R.id.login_button :
                String email = emailInput.getText().toString();
                String password = passInput.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    emailInput.setHint("Tolong isi bagian ini!");
                    emailInput.requestFocus();
                } else if (TextUtils.isEmpty(password)) {
                    passInput.setHint("Tolong isi bagian ini!");
                    passInput.requestFocus();
                } else {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            startActivity(new Intent(getActivity(), MainActivity2.class));
                            getActivity().finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Email atau password yang anda masukan salah!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
            case R.id.needANewAccount_button :
                changeFragmentToSignUp();
                break;
            case R.id.forgotPassword_button :
                changeFragmentToForgotPassword();
                break;
        }
    }

    private void changeFragmentToSignUp () {
        getFragmentManager().beginTransaction().replace(R.id.login_container, new SignUpFragment()).addToBackStack(null).commit();
    }

    private void changeFragmentToForgotPassword () {
        getFragmentManager().beginTransaction().replace(R.id.login_container, new ForgotPasswordFragment()).addToBackStack(null).commit();
    }
}
