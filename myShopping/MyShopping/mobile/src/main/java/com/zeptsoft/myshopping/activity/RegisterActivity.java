package com.zeptsoft.myshopping.activity;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.zeptsoft.myshopping.R;
import com.zeptsoft.myshopping.core.activity.AuthenticationActivity;
import com.zeptsoft.myshopping.log.LogUtils;


public class RegisterActivity extends AuthenticationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_layout);

        findViewById(R.id.register_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser(){
        String username = ((EditText)findViewById(R.id.register_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.register_pwd)).getText().toString();
        String passwordConfirmation = ((EditText)findViewById(R.id.register_conf_pwd)).getText().toString();

        //if(AuthenticationUtils.validateRegister(username, password,passwordConfirmation)){
            firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    LogUtils.d(String.format("Task Result: %s", task.isSuccessful()));
                    if(!task.isSuccessful()) {
                        ((TextView)findViewById(R.id.register_error_text)).setText(task.getException().getMessage());
                        LogUtils.d("Error Occurred: %s" +task.getException().getMessage());
                    }
                }
            });
        //}

    }


    @Override
    protected int getErrorMessageId() {
        return R.string.register_failed;
    }
}
