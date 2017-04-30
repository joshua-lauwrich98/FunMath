package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ancovy.funmath.R;
import com.ancovy.funmath.other.CustomAlertDialogLogOut;
import com.ancovy.funmath.other.SeekBarPreference;

/**
 * Created by DarKnight98 on 4/30/2017.
 */

public class LogOutFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

   @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
       CustomAlertDialogLogOut dialog = new CustomAlertDialogLogOut();
       dialog.showDialog(getActivity());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
