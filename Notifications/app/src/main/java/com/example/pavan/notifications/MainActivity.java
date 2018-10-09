package com.example.pavan.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.app.NotificationChannel.DEFAULT_CHANNEL_ID;

public class MainActivity extends AppCompatActivity {
    public static final String CHANNEL_ONE_ID = "1";
    public static final String CHANNEL_ONE_NAME = "Channel One";



    private void createChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //CharSequence name = getString(R.string.channel_name);
            //String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ONE_ID, "bank notifications", importance);
            channel.setDescription("this channel has notifications that are of higher priority bank stuff");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createChannel();

    }

    public void onClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(this,CHANNEL_ONE_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("my app's notification")
                .setContentText("you got bank shit to deal with ")
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        int notificationID;
        mNotificationManager.notify(1, myBuilder.build());

    }
}
