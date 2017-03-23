package com.zeptsoft.myshopping.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.zeptsoft.myshopping.core.MyShoppingApplication;
import com.zeptsoft.myshopping.core.listplayer.IListNavigator;
import com.zeptsoft.myshopping.datatypes.Item;
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
        Item item = null;
        IListNavigator navigator = ((MyShoppingApplication)context.getApplicationContext()).getNavigator();


        String action = intent.getStringExtra("action");
        switch (action){
            case NAVIGATION_PREVIOUS:
                item = navigator.previous();
                break;
            case NAVIGATION_DONE:
                navigator.check();
                item = navigator.next();
                break;
            case NAVIGATION_NEXT:
                item = navigator.next();
                break;
            default:
                LogUtils.d(String.format("Unrecognized action %s",action));
                return;
        }
        if(item != null) {
            NotificationHelper.getInstance().updateNotification(context, item.getName(), item.getCategory());
        }else{
            NotificationHelper.getInstance().updateNotification(context, "Lista concluída", "");
        }
    }

}
