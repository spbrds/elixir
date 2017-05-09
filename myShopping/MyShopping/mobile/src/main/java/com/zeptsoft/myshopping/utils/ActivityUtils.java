package com.zeptsoft.myshopping.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by SSBook on 21/04/17.
 */

public class ActivityUtils {
    public static void changeActivity(Context context, Class<?> targetActivity){
        changeActivity(context, targetActivity, null);
    }

    public static void changeActivity (Context context, Class<?> targetActivity, Bundle extras){
        Intent intent = new Intent(context, targetActivity);
        if (extras != null) {
            intent.putExtras(extras);
        }

        context.startActivity(intent);
        ((Activity)context).finish();
    }

}
