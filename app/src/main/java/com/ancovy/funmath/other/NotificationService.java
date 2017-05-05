package com.ancovy.funmath.other;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.ancovy.funmath.R;
import com.ancovy.funmath.activity.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotificationService extends Service {

    private DatabaseReference databaseReference;

    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Command");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("notifications").getValue().toString().equals("yes")) {
                            databaseReference.child("challange").setValue("yes");
                            databaseReference.child("notifications").setValue("no");
                            startNotification();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        };

        Thread thread = new Thread(r);
        thread.start();

        return Service.START_STICKY;
    }

    public void startNotification () {
        String ticker = "Anda memiliki tantangan baru";
        String title = "FunMath";
        String content = "Guru A telah memberikan tantangan baru untuk kelas 1";
        NotificationCompat.Builder notif = new NotificationCompat.Builder(getApplicationContext());
        notif.setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker(ticker)
                .setContentTitle(title)
                .setContentText(ticker)
                .setCategory(Notification.CATEGORY_EVENT)
                .setWhen(System.currentTimeMillis())
                .setSubText(content)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(ticker))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(ticker))
                .setColor(0x75bef9)
                .setVibrate(new long[] {1, 1, 1})
                .setPriority(Notification.PRIORITY_MAX)
                .setLights(0x75bef9, 2000, 1000);

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        notif.setContentIntent(pendingIntent);

        NotificationManager nn = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notify = new Notification();
        notify.flags = Notification.FLAG_SHOW_LIGHTS | Notification.FLAG_ONLY_ALERT_ONCE;
        nn.notify(2, notif.build());
    }
}
