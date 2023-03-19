package com.android.kumardsingh.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("DChannel","DChannel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this,"DChannel")
                .setAutoCancel(true)
                .setContentTitle("My Notification")
                .setContentText("This is my first notification")
                .setSmallIcon(R.drawable.ic_launcher_foreground);


        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(1234,nBuilder.build());
    }
}