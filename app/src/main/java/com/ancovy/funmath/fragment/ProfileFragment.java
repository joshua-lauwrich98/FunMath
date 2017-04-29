package com.ancovy.funmath.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ancovy.funmath.R;
import com.ancovy.funmath.other.CustomAlertDialogProfileUsernameEdit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

/**
 * Created by DarKnight98 on 4/22/2017.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private static final int GALERY_CODE = 1;
    private ImageButton profilImage;
    private Uri resultUri;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private String usernameText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profilImage = (ImageButton)view.findViewById(R.id.choose_profil_image_button);
        profilImage.setOnClickListener(this);

        final TextView username = (TextView)view.findViewById(R.id.username_profil_textview);
        username.setOnClickListener(this);

        resultUri = null;

        firebaseAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(firebaseAuth.getCurrentUser().getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                username.setText(dataSnapshot.child("username").getValue().toString());
                usernameText = dataSnapshot.child("username").getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Failed to connect to server!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton friend = (ImageButton) view.findViewById(R.id.friend_list_button_profile);
        ImageButton profile = (ImageButton) view.findViewById(R.id.statistic_button_profile);
        ImageButton statistic = (ImageButton) view.findViewById(R.id.own_profile_button_profle);

        friend.setOnClickListener(this);
        profile.setOnClickListener(this);
        statistic.setOnClickListener(this);


        getChildFragmentManager().beginTransaction().replace(R.id.profile_detail_container, new FriendListProfileFragment()).commit();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.choose_profil_image_button :
                Intent galeryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galeryIntent.setType("image/*");
                startActivityForResult(galeryIntent, GALERY_CODE);
                break;
            case R.id.username_profil_textview :
                CustomAlertDialogProfileUsernameEdit dialog = new CustomAlertDialogProfileUsernameEdit();
                dialog.showDialog(getActivity(), usernameText);
                databaseReference.child("username").setValue(usernameText);
                break;
            case R.id.friend_list_button_profile :
                getChildFragmentManager().beginTransaction().replace(R.id.profile_detail_container, new FriendListProfileFragment()).commit();
                break;
            case R.id.own_profile_button_profle :
                getChildFragmentManager().beginTransaction().replace(R.id.profile_detail_container, new MyProfileProfileFragment()).commit();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALERY_CODE && resultCode == getActivity().RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .start(getContext(), this);
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == getActivity().RESULT_OK) {
                resultUri = result.getUri();
                profilImage.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(getActivity(), result.getError().getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
