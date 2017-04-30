package com.ancovy.funmath.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.ancovy.funmath.R;
import com.ancovy.funmath.other.SeekBarPreference;

/**
 * Created by DarKnight98 on 4/30/2017.
 */

public class RedFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SeekBarPreference _seekBarPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.pref_log_out);


        // Get widgets :
        _seekBarPref = (SeekBarPreference) this.findPreference("SEEKBAR_VALUE");

        // Set listener :
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

        // Set seekbar summary :
        int radius = PreferenceManager.getDefaultSharedPreferences(this.getActivity()).getInt("SEEKBAR_VALUE", 50);
        _seekBarPref.setSummary(this.getString(R.string.settings_summary).replace("$1", ""+radius));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        // Set seekbar summary :
        int radius = PreferenceManager.getDefaultSharedPreferences(this.getActivity()).getInt("SEEKBAR_VALUE", 50);
        _seekBarPref.setSummary(this.getString(R.string.settings_summary).replace("$1", ""+radius));
    }
}
