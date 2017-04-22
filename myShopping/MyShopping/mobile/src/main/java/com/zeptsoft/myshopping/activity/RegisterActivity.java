package com.zeptsoft.myshopping.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);

        firebaseAuth = FirebaseAuth.getInstance();
        authListener = AuthenticationUtils.getAuthStateListenerForLogin(this, R.string.register_failed);
    }

    private void registerUser(){
        
    }


}
