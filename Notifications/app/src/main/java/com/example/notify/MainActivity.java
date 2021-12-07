package com.example.notify;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.INotificationSideChannel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.channels.Channels;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Notify = (Button)findViewById(R.id.button_show);
        btn_Notify.setOnClickListener(new View.OnClickListener(){

           /* private void createNotificationChannel(){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    CharSequence name = getString(R.string.app_name);
                    String description = getString(R.string.app_name);
                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel channel = new NotificationChannel(1, name, importance);
                    channel.setDescription(description);
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }
            }
            */

            @Override
            public void onClick(View v){
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
                mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
                mBuilder.setContentTitle("Tutlane Send New Message");
                mBuilder.setContentText("Hi, Welcome to Tutlane tutorial site");
                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);


                /*NotificationCompat.Builder vbuilder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("My Notification")
                        .setContentText("Much longer text that cannot fit one line....")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                */

                Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, resultIntent, 0);
                int mNotificationId = 001;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(mNotificationId, mBuilder.build());
            }
        });
    }
}