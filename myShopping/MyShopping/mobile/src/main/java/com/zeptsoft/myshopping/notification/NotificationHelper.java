package com.zeptsoft.myshopping.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.receivers.NotificationBroadcastReceiver;

/**
 * Created by SSBook on 09/03/17.
 */

public class NotificationHelper {
    //why 10605? just because...
    public static final int NOTIFICATION_ID = 10605;

    private static final NotificationHelper helper = new NotificationHelper();

    private NotificationManager manager;
    private RemoteViews notificationView;
    private NotificationCompat.Builder builder;


    private NotificationHelper(){
    }

    public static NotificationHelper getInstance(){
        return helper;
    }


    public void buildNotification(Context context) {
        //mudar o builder e o Manager para statics numa classe
        //para poder fazer o update da notificação

        notificationView = new RemoteViews(context.getPackageName(), R.layout.notification_layout);
        builder = new NotificationCompat.Builder(context);

        Notification notification = builder
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContent(notificationView)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.cast_ic_mini_controller_mute)
                .setDefaults(Notification.DEFAULT_SOUND)
                .build();


        //defining actions
        this.setActionOnNotification(context, notificationView, NotificationBroadcastReceiver.NAVIGATION_DONE, R.id.notificationDone,0);
        this.setActionOnNotification(context, notificationView, NotificationBroadcastReceiver.NAVIGATION_PREVIOUS, R.id.notificationPrevious,1);
        this.setActionOnNotification(context, notificationView, NotificationBroadcastReceiver.NAVIGATION_NEXT, R.id.notificationNext,2);

        //showing notification
        this.showNotification(context, notification);

    }

    public void updateNotification(Context context, String mainText, String subText){
        this.notificationView.setTextViewText(R.id.main_text, mainText);
        this.notificationView.setTextViewText(R.id.sub_text, subText);

        builder.setDefaults(0)
                .setContent(this.notificationView);
        this.showNotification(context,builder.build());

    }


    private void showNotification(Context context, Notification notification){
        //showing notification
        if(manager == null) {
            manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        }
        manager.notify(NOTIFICATION_ID, notification);

    }

    public void dismissNotification(){
        manager.cancel(NOTIFICATION_ID);
    }

    private void setActionOnNotification(Context context, RemoteViews remoteView, String action, int buttonId, int requestCode) {
        Intent intent = new Intent(context, NotificationBroadcastReceiver.class);
        intent.putExtra("action", action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, 0);

        remoteView.setOnClickPendingIntent(buttonId,pendingIntent);
    }


}
