package com.ancovy.funmath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ancovy.funmath.R;
import com.ancovy.funmath.fragment.PVPKlasikPlayActi;
import com.ancovy.funmath.fragment.WithFriendTimeTrialPlayActi;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();
        String status = intent.getStringExtra("jenis");

        if (status.equals("clasic")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.play_activity_container, new PVPKlasikPlayActi()).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.play_activity_container, new WithFriendTimeTrialPlayActi()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, MainActivity2.class));
    }
}
