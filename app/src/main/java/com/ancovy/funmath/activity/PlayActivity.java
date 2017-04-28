package com.ancovy.funmath.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ancovy.funmath.R;
import com.ancovy.funmath.fragment.PVPKlasikPlayActi;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();
        String status = intent.getStringExtra("jenis");

        if (status.equals("clasic")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.play_activity_container, new PVPKlasikPlayActi()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(this, MainActivity2.class));
    }
}
