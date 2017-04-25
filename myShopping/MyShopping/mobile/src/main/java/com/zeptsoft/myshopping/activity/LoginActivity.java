package com.zeptsoft.myshopping.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.core.activity.AuthenticationActivity;
import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.utils.ActivityUtils;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;
import com.zeptsoft.myshopping.utils.StringUtils;

public class LoginActivity extends AuthenticationActivity {

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

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin(){
        LogUtils.d("Login invoked");
        String user = ((EditText)findViewById(R.id.login_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_pwd)).getText().toString();

        LogUtils.d(""+StringUtils.isNull(user));
        LogUtils.d(""+StringUtils.isNull(password));
        if(StringUtils.isNull(user) || StringUtils.isNull(password)){
            return;
        }
        LogUtils.d("Login invoked");
        firebaseAuth.signInWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                LogUtils.d(String.format("Task Result: %s", task.isSuccessful()));
                if(!task.isSuccessful()) {
                    ((TextView)findViewById(R.id.register_error_text)).setText(task.getException().getMessage());
                    LogUtils.d("Error Occurred: %s" +task.getException().getMessage());
                }
            }
        });


    }

    public void threatLoginError(){

    }

    private void checkLoginStatus(){}

    @Override
    protected int getErrorMessageId() {
        return R.string.login_failed;
    }
}
