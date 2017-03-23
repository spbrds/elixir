package com.zeptsoft.myshopping.core;

import android.app.Application;

import com.zeptsoft.myshopping.core.listplayer.IListNavigator;
import com.zeptsoft.myshopping.core.listplayer.SimpleListNavigator;
import com.zeptsoft.myshopping.notification.NotificationHelper;

/**
 * Created by SSBook on 14/03/17.
 */

public class MyShoppingApplication extends Application {

    private IListNavigator navigator;

    @Override
    public void onTerminate() {
        //dismissing notification if app is killed by user or core
        NotificationHelper.getInstance().dismissNotification();

        super.onTerminate();
    }

    public IListNavigator getNavigator() {
        if(navigator == null){
            navigator = new SimpleListNavigator();
        }
        return navigator;
    }

}
