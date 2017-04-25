package com.zeptsoft.myshopping.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.log.LogUtils;
import com.zeptsoft.myshopping.utils.ActivityUtils;
import com.zeptsoft.myshopping.utils.AuthenticationUtils;
import com.zeptsoft.myshopping.utils.StringUtils;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_layout);
        firebaseAuth = FirebaseAuth.getInstance();
        authListener = AuthenticationUtils.getAuthStateListenerForLogin(this, R.string.login_failed);

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
        String user = ((EditText)findViewById(R.id.login_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_pwd)).getText().toString();

        if(StringUtils.isNull(user) || StringUtils.isNull(password)){
            return;
        }

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
}
