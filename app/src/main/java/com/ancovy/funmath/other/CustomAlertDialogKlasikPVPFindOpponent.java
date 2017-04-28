package com.ancovy.funmath.other;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity2;
import com.ancovy.funmath.activity.PlayActivity;
import com.ancovy.funmath.fragment.PlayPVPFragment;

/**
 * Created by DarKnight98 on 4/24/2017.
 */

public class CustomAlertDialogKlasikPVPFindOpponent {

    private long currentTime;
    private boolean status = true;
    private boolean abandon = true;

    public void showDialog(final MainActivity2 activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_alert_dialog_pvp_find_opponent);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        final TextView text = (TextView)dialog.findViewById(R.id.time_text_pvp_klasik_find_opponent);

        final CountDownTimer countDownTimer = new CountDownTimer(6000, 1000) {

            @Override
            public void onTick(long l) {
                text.setText(l/1000 + "");
                currentTime = l;
            }

            @Override
            public void onFinish() {
                if (abandon) {
                    Intent intent = new Intent(activity, PlayActivity.class);
                    intent.putExtra("jenis", "clasic");
                    activity.startActivity(intent);
                    activity.finish();
                    dialog.dismiss();
                } else {
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).commit();
                    dialog.dismiss();
                }
            }
        }.start();

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status) {
                    countDownTimer.cancel();
                    status = false;
                } else {
                    new CountDownTimer(currentTime, 1000) {
                        @Override
                        public void onTick(long l) {
                            text.setText(""+ l/1000);
                            currentTime = l;
                        }

                        @Override
                        public void onFinish() {
                            if (abandon) {
                                activity.startActivity(new Intent(activity, PlayActivity.class));
                                activity.finish();
                                dialog.dismiss();
                            } else {
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.play_container, new PlayPVPFragment()).commit();
                                dialog.dismiss();
                            }
                        }
                    }.start();
                }
            }
        });

        final Button batal = (Button) dialog.findViewById(R.id.cancel_button_pvp_klasik_dialog);
        final Button ready = (Button) dialog.findViewById(R.id.ready_button_pvp_klasik_dialog);
        final TextView myReadyStat = (TextView)dialog.findViewById(R.id.my_ready_status_klasik_pvp);

        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();

                myReadyStat.setBackgroundResource(R.drawable.status_ready);
                ready.setEnabled(false);
                batal.setEnabled(false);
            }
        });


        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                myReadyStat.setBackgroundResource(R.drawable.status_cancel);
                ready.setEnabled(false);
                batal.setEnabled(false);
                abandon = false;
            }
        });

        dialog.show();
    }
}
