package com.zeptsoft.myshopping.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.utils.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);

        addButtonListeners();
    }

    private void addButtonListeners(){
        findViewById(R.id.login_register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.changeActivity(LoginActivity.this, RegisterActivity.class, null);
            }
        });
    }

    private void doLogin(){

    }

    private void checkLoginStatus(){}
}
