package com.zeptsoft.myshopping.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.notification.NotificationHelper;

/**
 * Created by SSBook on 09/03/17.
 */

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    public static final String NAVIGATION_NEXT = "NEXT";
    public static final String NAVIGATION_DONE = "DONE";
    public static final String NAVIGATION_PREVIOUS = "PREVIOUS";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getStringExtra("action");
        switch (action){
            case NAVIGATION_PREVIOUS:
                NotificationHelper.getInstance().updateNotification(context,"Bolachas","Snacks");
                return;
            case NAVIGATION_DONE:
                NotificationHelper.getInstance().updateNotification(context,"Café","Bebidas");
                return;
            case NAVIGATION_NEXT:
                NotificationHelper.getInstance().updateNotification(context,"Pão","Padaria");
                return;
            default:
                LogUtils.d(String.format("Unrecognized action %s",action));
                return;
        }
    }
}
