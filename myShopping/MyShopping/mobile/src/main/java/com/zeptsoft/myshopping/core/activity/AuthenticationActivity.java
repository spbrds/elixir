package com.zeptsoft.myshopping.core.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.activity.ListActivity;
import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.utils.ActivityUtils;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;

/**
 * Created by SSBook on 25/04/17.
 */

public abstract class AuthenticationActivity extends AppCompatActivity {

    protected FirebaseAuth firebaseAuth;
    protected FirebaseAuth.AuthStateListener authListener;

    protected abstract int getErrorMessageId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        authListener = AuthenticationUtils.getAuthStateListenerForLogin(this, getErrorMessageId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(null != firebaseAuth.getCurrentUser()){
            ActivityUtils.changeActivity(this, ListActivity.class, null);
        }else {
            firebaseAuth.addAuthStateListener(authListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authListener != null) {
            firebaseAuth.removeAuthStateListener(authListener);
        }
    }

}
