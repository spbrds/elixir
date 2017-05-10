package com.zeptsoft.myshopping.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.zeptsoft.myshopping.activity.ListActivity;
import com.zeptsoft.myshopping.activity.LoginActivity;
import com.zeptsoft.myshopping.log.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SSBook on 21/04/17.
 */

public class AuthenticationUtils {

    private static final Class<?> activityAfterLogin = ListActivity.class;
    private static FirebaseUser authenticatedUser;
    private static final int PASSWORD_MIN_SIZE = 8;
    private static volatile boolean authenticated = false;
    static int counter;

    public static FirebaseAuth.AuthStateListener getAuthStateListenerForLogin(final Context context, final int failureMessageId){
        return new FirebaseAuth.AuthStateListener() {
            private boolean initiated = false;

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //already authenticated, no need to do anything else
                //put in place because of AuthStateListener called multiple times after login
                LogUtils.d("Passei aqui" + counter++);
                if(authenticated){
                    return;
                }
                authenticatedUser = firebaseAuth.getCurrentUser();
                if(authenticatedUser != null){
                    authenticated = true;
                    ActivityUtils.changeActivity(context, activityAfterLogin,null);
                }else{
                    if(initiated) {
                        Toast.makeText(context, context.getResources().getString(failureMessageId), Toast.LENGTH_SHORT).show();
                    }
                }
                this.initiated=true;
            }
        };
    }

    public static void logout(Context context){
        FirebaseAuth.getInstance().getInstance().signOut();
        authenticated = false;
        ActivityUtils.changeActivity(context, LoginActivity.class, null);
    }

    //todo: put error list validating
    //public static List<String> validateRegister(String email, String password, String confPassword){
    public static boolean validateRegister(String email, String name, String password, String confPassword){
        List<String> errors = new ArrayList<>();

        if(StringUtils.isNull(password) || StringUtils.isNull(password) || StringUtils.isNull(confPassword)){
            return false;
        }

        //validating email
        Pattern mailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = mailPattern.matcher(email);

        if(!matcher.find()){
            return false;
        }

        //validating passwords
        if(!password.equals(confPassword)){
            return false;
        }

        if(password.length()< PASSWORD_MIN_SIZE){
            return false;
        }

        //validating name
        if(StringUtils.isNull(name)){
            return false;
        }

        return true;
    }


}
