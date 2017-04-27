package com.ancovy.funmath.other;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ancovy.funmath.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by DarKnight98 on 4/24/2017.
 */

public class CustomAlertDialogProfileUsernameEdit {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public void showDialog(final Activity activity, String username){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_alert_dialog_profile_username_edit);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid()).child("username");

        final EditText input = (EditText)dialog.findViewById(R.id.new_username_input);
        input.setHint(username);

        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.ok_button_change_username);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                String newUsername = input.getText().toString();
                databaseReference.setValue(newUsername);
                dialog.dismiss();
            }
        });

//        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_yes);
//        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                    Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
//                activity.finish();
//            }
//        });

        dialog.show();
    }
}
