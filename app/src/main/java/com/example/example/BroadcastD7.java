package com.example.example;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class BroadcastD7 extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.shoot);//알림 사진 지정

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,//알림누르면 이동하는 것 구현
                new Intent(context.getApplicationContext(), Num7Activity.class), PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        String channelId = "채널";
        String channelName = "채널 네임";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.enableVibration(true);
        notificationManager.createNotificationChannel(channel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)//Notification구현
                .setSmallIcon(R.drawable.shoot)
                .setContentTitle("알림이 왔어요~")
                .setContentText("오늘의 운세를 확인하세요!")
                .setDefaults(Notification.DEFAULT_ALL)
                .setLargeIcon(bitmap)
                .setTicker("한줄 출력")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager_1 = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager_1.notify(0, builder.build());
    }
}
