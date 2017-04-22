package com.zeptsoft.myshopping.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by SSBook on 21/04/17.
 */

public class ActivityUtils {
    public static void changeActivity (Context context, Class<?> targetActivity, Bundle extras){
        Intent intent = new Intent(context, targetActivity);
        intent.putExtras(extras);

        context.startActivity(intent);
    }

}
